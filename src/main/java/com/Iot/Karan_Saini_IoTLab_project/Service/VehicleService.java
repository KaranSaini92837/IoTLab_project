package com.Iot.Karan_Saini_IoTLab_project.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Iot.Karan_Saini_IoTLab_project.Entity.Alert;
import com.Iot.Karan_Saini_IoTLab_project.Entity.Vehicle;

@Service
public interface VehicleService {
	
	public List<Vehicle> getAllVehicles();
	public void addVehicle(Vehicle vehicle);
	public void updateVehicle(Vehicle vehicle);
	public Vehicle getVehicleByVin(String vin);
	public List<Alert> getHighAlerts();
	

}
