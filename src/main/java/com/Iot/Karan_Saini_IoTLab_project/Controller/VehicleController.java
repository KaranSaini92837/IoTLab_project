package com.Iot.Karan_Saini_IoTLab_project.Controller;

import java.sql.Timestamp;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Iot.Karan_Saini_IoTLab_project.Entity.Alert;
import com.Iot.Karan_Saini_IoTLab_project.Entity.Vehicle;
import com.Iot.Karan_Saini_IoTLab_project.Service.AlertService;
import com.Iot.Karan_Saini_IoTLab_project.Service.VehicleService;
import com.Iot.Karan_Saini_IoTLab_project.model.Reading;

@RestController
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;

	@Autowired
	private AlertService alertService;
	

	@CrossOrigin()
	@PutMapping("/vehicles")
	public void putVehicles(@RequestBody Vehicle [] vehicle) {

		for (int i = 0; i < vehicle.length; i++) {
			if (vehicleService.getVehicleByVin(vehicle[i].getVin()) != null) {

				Vehicle veh = vehicleService.getVehicleByVin(vehicle[i].getVin());
				veh.setLastServiceDate(vehicle[i].getLastServiceDate());
				veh.setMake(vehicle[i].getMake());
				veh.setMaxFuelVolume(vehicle[i].getMaxFuelVolume());
				veh.setModel(vehicle[i].getModel());
				veh.setRedlineRpm(vehicle[i].getRedlineRpm());
				veh.setYear(vehicle[i].getYear());
				veh.getAlerts().clear();
				vehicleService.addVehicle(veh);
			} else {

				vehicleService.addVehicle(vehicle[i]);
			}

			System.out.println("Vehicle added: " + vehicle[i]);
		}
		
	}

	@CrossOrigin
	@PostMapping("/readings")
	public void postVehicleData(@RequestBody Reading vehiclereading) {
		
		Vehicle vehicle = vehicleService.getVehicleByVin(vehiclereading.getVin());

		if (vehicle.getRedlineRpm() < vehiclereading.getEngineRpm()) {

			Alert alert = new Alert("HIGH", "Warning!!!!", new Timestamp(System.currentTimeMillis()), vehiclereading.getVin());
			vehicle.addAlert(alert);
		}
		if (vehiclereading.getFuelVolume() < (0.1) * vehicle.getMaxFuelVolume()) {

			Alert alert = new Alert("MEDIUM", "BeWare", new Timestamp(System.currentTimeMillis()), vehiclereading.getVin());
			vehicle.addAlert(alert);
		}
		if (vehiclereading.getTires().getBackLeft() < 32 || vehiclereading.getTires().getBackLeft() > 36
				|| vehiclereading.getTires().getBackRight() > 36 || vehiclereading.getTires().getBackRight() < 32
				|| vehiclereading.getTires().getFrontLeft() < 32 || vehiclereading.getTires().getFrontLeft() > 36
				|| vehiclereading.getTires().getFrontRight() > 36 || vehiclereading.getTires().getFrontRight() < 32) {

			Alert alert = new Alert("LOW", "Careful", new Timestamp(System.currentTimeMillis()), vehiclereading.getVin());
			vehicle.addAlert(alert);

		}
		vehicleService.addVehicle(vehicle);

	}

	@GetMapping("/getAllVehicleDetails")
	public List<Vehicle> getAllVehicleDetails() {

		return vehicleService.getAllVehicles();
	}

	@GetMapping("/getVehicleAlerts/{vin}")
	public List<Alert> getVehicleAlerts(@PathVariable String vin) {
		
		return alertService.getVinAlerts(vin);
	}

	@GetMapping("/getHighAlerts")
	public List<Alert> getHighAlerts() {

		List<Alert> alerts = alertService.getAllHighAlerts();
		return alerts;
	}

}
