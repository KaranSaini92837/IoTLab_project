package com.Iot.Karan_Saini_IoTLab_project.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Iot.Karan_Saini_IoTLab_project.Entity.Alert;
import com.Iot.Karan_Saini_IoTLab_project.Entity.Reading;
import com.Iot.Karan_Saini_IoTLab_project.Entity.Vehicle;
import com.Iot.Karan_Saini_IoTLab_project.Repository.VehicleRepository;
import com.Iot.Karan_Saini_IoTLab_project.Service.VehicleService;

@RestController
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;

	@Autowired
	private VehicleRepository vehicleRepo;

	@CrossOrigin
	@PutMapping("/vehicles")
	public void putVehicles(HttpServletRequest request, HttpServletResponse response, @RequestBody Vehicle vehicle[]) {
		for (int i = 0; i < vehicle.length; i++) {

			 if (vehicleService.getVehicleByVin(vehicle[i].getVin()) != null) {
				 Vehicle veh = vehicleService.getVehicleByVin(vehicle[i].getVin());
				// veh.setAlerts(vehicle[i].getAlerts());
				// veh.setId(vehicle[i].getId());
				 veh.setLastServiceDate(vehicle[i].getLastServiceDate());
				 veh.setMake(vehicle[i].getMake());
				 veh.setMaxFuelVolume(vehicle[i].getMaxFuelVolume());
				 veh.setModel(vehicle[i].getModel());
				// veh.setReadings(vehicle[i].getReadings());
				 veh.setRedlineRpm(vehicle[i].getRedlineRpm());
				 veh.setYear(vehicle[i].getYear());
				 vehicleService.addVehicle(veh);
				 System.out.println("==================================Vehicle Updated===============================================");
			 }
			 else {
				 vehicleService.addVehicle(vehicle[i]);
			 }

			System.out.println("Vehicle added: " + vehicle[i]);
		}
	}

	@CrossOrigin
	@PostMapping("/readings")
	public void postVehicleData(HttpServletRequest request, HttpServletResponse response,
			@RequestBody Reading vehiclereading) {

		Vehicle vehicle = vehicleService.getVehicleByVin(vehiclereading.getVin());
		vehicle.getReadings().add(vehiclereading);
		if (vehicle.getRedlineRpm() < vehiclereading.getEngineRpm()) {
			Alert alert = new Alert("HIGH", "Warning!!!!", vehiclereading.getTimestamp());
			vehicle.getAlerts().add(alert);
		}
		if (vehiclereading.getFuelVolume() < (0.1) * vehicle.getMaxFuelVolume()) {
			Alert alert = new Alert("MEDIUM", "BeWare", vehiclereading.getTimestamp());
			vehicle.getAlerts().add(alert);
		}
		if (vehiclereading.getTires().getBackLeft() < 32 ||
			vehiclereading.getTires().getBackLeft() > 36|| 
			vehiclereading.getTires().getBackRight() > 36 ||
			vehiclereading.getTires().getBackRight() < 32|| 
			vehiclereading.getTires().getFrontLeft() < 32 || 
			vehiclereading.getTires().getFrontLeft() > 36 || 
			vehiclereading.getTires().getFrontRight() > 36 || 
			vehiclereading.getTires().getFrontRight() < 32) {
			Alert alert = new Alert("LOW", "Careful", vehiclereading.getTimestamp());
			vehicle.getAlerts().add(alert);
		}
		vehicleService.addVehicle(vehicle);

	}

	@CrossOrigin
	@GetMapping("/getVehicleDetails")
	public List<Vehicle> getVehicleDetails(HttpServletResponse response) {

		return vehicleService.getAllVehicles();
	}

	@CrossOrigin
	@GetMapping("/getVehicleAlerts/{vin}")
	public List<Alert> getVehicleAlerts(@PathVariable String vin, HttpServletRequest request,
			HttpServletResponse response) {

		Vehicle vehicle = vehicleRepo.findByVin(vin);
		// return vehicle.getReading().getAlerts();
		return vehicle.getAlerts();

	}

}
