package com.Iot.Karan_Saini_IoTLab_project.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Iot.Karan_Saini_IoTLab_project.Entity.Vehicle;

@Repository
public interface VehicleRepository extends CrudRepository<Vehicle, Integer> {

	// public boolean findByVin(String id);
	public Vehicle findByVin(String id);
}
