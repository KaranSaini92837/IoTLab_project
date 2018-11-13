package com.Iot.Karan_Saini_IoTLab_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.Iot.Karan_Saini_IoTLab_project.Entity")
public class KaranSainiIoTLabProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(KaranSainiIoTLabProjectApplication.class, args);
	}
}

//com.mysql.jdbc.Driver?
