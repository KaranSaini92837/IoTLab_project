package com.Iot.Karan_Saini_IoTLab_project.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.Iot.Karan_Saini_IoTLab_project.Entity.Alert;

public interface AlertRepository extends CrudRepository<Alert, Integer> {
	
	public List<Alert> findByPriority(String priority);

}
