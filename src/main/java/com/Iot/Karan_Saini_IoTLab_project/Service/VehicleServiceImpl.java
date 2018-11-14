package com.Iot.Karan_Saini_IoTLab_project.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Iot.Karan_Saini_IoTLab_project.Entity.Vehicle;
import com.Iot.Karan_Saini_IoTLab_project.Repository.VehicleRepository;

@Service
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	private VehicleRepository vehicleRepo;
	
	@Override
	public void addVehicle(Vehicle vehicle) {
		vehicleRepo.save(vehicle);
	}

	@Override
	public void updateVehicle(Vehicle vehicle) {
		vehicleRepo.save(vehicle);
	}

	@Override
	public List<Vehicle> getAllVehicles() {
		return (List<Vehicle>) vehicleRepo.findAll();
	}

}
