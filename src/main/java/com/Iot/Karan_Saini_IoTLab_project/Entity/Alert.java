package com.Iot.Karan_Saini_IoTLab_project.Entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Alert {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String priority;
	private String message;
	private Timestamp timestamp;

	public Alert() {
		super();
	}

	public Alert(String priority, String message, Timestamp timestamp) {
		super();
		this.priority = priority;
		this.message = message;
		this.timestamp = timestamp;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "Alert [priority=" + priority + ", message=" + message + ", timestamp=" + timestamp + "]";
	}
	
}
