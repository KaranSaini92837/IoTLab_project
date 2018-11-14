package com.Iot.Karan_Saini_IoTLab_project.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

//			if (vehicleRepo.fi) {
				vehicleService.addVehicle(vehicle[i]);
		//	}
//			else {
//				
//			}

			System.out.println("Vehicle added: " + vehicle[i]);
		}
	}

	@CrossOrigin
	@PostMapping("/readings")
	public void postVehicleData(HttpServletRequest request, HttpServletResponse response,
			@RequestBody Reading vehiclereading) {
		
		Vehicle vehicle = vehicleRepo.findByVin(vehiclereading.getVin());
		vehicle.setReading(vehiclereading);
		vehicleService.addVehicle(vehicle);

	}

	@GetMapping
	public void getMapping() {
		System.out.println("Hello world");
	}

}
