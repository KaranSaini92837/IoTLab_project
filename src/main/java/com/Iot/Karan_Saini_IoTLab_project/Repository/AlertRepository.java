package com.Iot.Karan_Saini_IoTLab_project.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.Iot.Karan_Saini_IoTLab_project.Entity.Alert;

public interface AlertRepository extends CrudRepository<Alert, Integer> {

	// public List<Alert> findByPriority(String priority);

	@Query(value = "SELECT * FROM IoT.alert a WHERE a.timestamp >= DATE_SUB(NOW(),INTERVAL 2 HOUR) and priority = 'HIGH'", nativeQuery = true)
	public List<Alert> getListOfHighAlerts();

}
