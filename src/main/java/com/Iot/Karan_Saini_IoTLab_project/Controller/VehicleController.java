package com.Iot.Karan_Saini_IoTLab_project.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VehicleController {

	@PutMapping("/vehicle")
	public void putVehicles() {

	}

	@PostMapping("/readings")
	public void postVehicleData() {

	}
	
	@GetMapping
	public void getMapping() {
		System.out.println("Hello world");
	}

}
