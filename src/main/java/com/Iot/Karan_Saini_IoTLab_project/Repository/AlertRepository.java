package com.Iot.Karan_Saini_IoTLab_project.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.Iot.Karan_Saini_IoTLab_project.Entity.Alert;

public interface AlertRepository extends CrudRepository<Alert, Integer> {
	
	//public List<Alert> findByPriority(String priority);
	
	@Query(value = "SELECT * FROM IoT.alert a WHERE a.timestamp >= DATE_SUB(NOW(),INTERVAL 2 HOUR) and priority = 'HIGH'",
			nativeQuery = true)
	public List<Alert> getListOfHighAlerts();

}

//WHERE TIMESTAMP > Current time - 2 hours”

/*
 * 13:21:31	SELECT * FROM IoT.alert WHERE Timestamp > current_time()-2hour and Priortiy = HIGH LIMIT 0, 1000	Error Code: 1054. Unknown column '2hour' in 'where clause'	0.00063 sec

 */
