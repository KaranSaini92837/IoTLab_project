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

			// if (vehicleRepo.fi) {
			vehicleService.addVehicle(vehicle[i]);
			// }
			// else {
			//
			// }

			System.out.println("Vehicle added: " + vehicle[i]);
		}
	}

	@CrossOrigin
	@PostMapping("/readings")
	public void postVehicleData(HttpServletRequest request, HttpServletResponse response,
			@RequestBody Reading vehiclereading) {

		Vehicle vehicle = vehicleRepo.findByVin(vehiclereading.getVin());
		vehicle.getReadings().add(vehiclereading);
		if (vehicle.getRedlineRpm() < vehiclereading.getEngineRpm()) {
			Alert alert = new Alert("HIGH", "Warning!!!!", vehiclereading.getTimestamp());
			vehicle.getAlerts().add(alert);
		}
		if (vehiclereading.getFuelVolume() < (0.1) * vehicle.getMaxFuelVolume()) {
			Alert alert = new Alert("MEDIUM", "Warning!!!!", vehiclereading.getTimestamp());
			vehicle.getAlerts().add(alert);
		}
		// if(vehiclereading.getTires().getBackLeft()<32 ||
		// vehiclereading.getTires().getBackLeft() >36 ||
		// vehiclereading.getTires().getBackRight() >36 ||
		// vehiclereading.getTires().getBackRight() <32) {
		//
		// }
		vehicleService.addVehicle(vehicle);

	}

	@CrossOrigin
	@GetMapping("/getVehicleDetails")
	public List<Vehicle> getVehicleDetails(HttpServletResponse response) {

		return vehicleService.getAllVehicles();
	}

	 @CrossOrigin
	 @GetMapping("/getVehicleAlerts/{vin}")
	 public List<Alert> getVehicleAlerts(@PathVariable String vin, HttpServletRequest request, HttpServletResponse response){
		 
		 Vehicle vehicle = vehicleRepo.findByVin(vin);
		//  return vehicle.getReading().getAlerts();
		 return vehicle.getAlerts();
		 
	 }

}
