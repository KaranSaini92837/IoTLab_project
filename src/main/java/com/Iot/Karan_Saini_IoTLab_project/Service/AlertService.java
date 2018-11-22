package com.Iot.Karan_Saini_IoTLab_project.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Iot.Karan_Saini_IoTLab_project.Entity.Alert;

@Service
public interface AlertService {

	public List<Alert> getAllHighAlerts();
	
	public List<Alert> getVinAlerts(String vin);

}
