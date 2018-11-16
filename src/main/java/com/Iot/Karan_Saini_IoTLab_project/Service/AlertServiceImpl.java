package com.Iot.Karan_Saini_IoTLab_project.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Iot.Karan_Saini_IoTLab_project.Entity.Alert;
import com.Iot.Karan_Saini_IoTLab_project.Repository.AlertRepository;

@Service
public class AlertServiceImpl implements AlertService {

	@Autowired
	private AlertRepository alertRepo;

	@Override
	public List<Alert> getAllHighAlerts() {

		// return alertRepo.findByPriority("HIGH");
		return alertRepo.getListOfHighAlerts();
	}

}
