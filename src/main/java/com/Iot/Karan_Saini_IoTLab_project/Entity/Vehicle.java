package com.Iot.Karan_Saini_IoTLab_project.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String vin;
	private String make;
	private String model;
	private int year;
	private int redlineRpm;
	private int maxFuelVolume;
	private String lastServiceDate;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "reading_id")
	private List<Reading> readings = new ArrayList<>();

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "alert_id")
	private List<Alert> alerts = new ArrayList<>();

	public Vehicle() {

	}

	public Vehicle(String vin, String make, String model, int year, int redlineRpm, int maxFuelVolume,
			String lastServiceDate) {
		super();
		this.vin = vin;
		this.make = make;
		this.model = model;
		this.year = year;
		this.redlineRpm = redlineRpm;
		this.maxFuelVolume = maxFuelVolume;
		this.lastServiceDate = lastServiceDate;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getRedlineRpm() {
		return redlineRpm;
	}

	public void setRedlineRpm(int redlineRpm) {
		this.redlineRpm = redlineRpm;
	}

	public int getMaxFuelVolume() {
		return maxFuelVolume;
	}

	public void setMaxFuelVolume(int maxFuelVolume) {
		this.maxFuelVolume = maxFuelVolume;
	}

	public String getLastServiceDate() {
		return lastServiceDate;
	}

	public void setLastServiceDate(String lastServiceDate) {
		this.lastServiceDate = lastServiceDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Reading> getReadings() {
		return readings;
	}

	public void setReadings(List<Reading> readings) {
		this.readings = readings;
	}

	public List<Alert> getAlerts() {
		return alerts;
	}

	public void setAlerts(List<Alert> alerts) {
		this.alerts = alerts;
	}

	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", vin=" + vin + ", make=" + make + ", model=" + model + ", year=" + year
				+ ", redlineRpm=" + redlineRpm + ", maxFuelVolume=" + maxFuelVolume + ", lastServiceDate="
				+ lastServiceDate + "]";
	}

}
