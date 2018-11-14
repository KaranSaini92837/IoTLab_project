package com.Iot.Karan_Saini_IoTLab_project.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Reading {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String vin;
	private long lattitude;
	private long longitude;
	private String timeStamp;
	private float fuelVolume;
	private int speed;
	private int engineHp;
	private boolean checkEngineLightOn;
	private boolean engineCoolantLow;
	private boolean cruiseControlOn;
	private long engineRpm;

	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name = "tires_id")
	private Tires tires;

	public Reading() {
		super();

	}

	public Reading(int id, long lattitude, long longitude, String timeStamp, float fuelVolume, int speed, int engineHp,
			boolean checkEngineLightOn, boolean engineCoolantLow, boolean cruiseControlOn, long engineRpm) {
		super();
		this.id = id;
		this.lattitude = lattitude;
		this.longitude = longitude;
		this.timeStamp = timeStamp;
		this.fuelVolume = fuelVolume;
		this.speed = speed;
		this.engineHp = engineHp;
		this.checkEngineLightOn = checkEngineLightOn;
		this.engineCoolantLow = engineCoolantLow;
		this.cruiseControlOn = cruiseControlOn;
		this.engineRpm = engineRpm;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getLattitude() {
		return lattitude;
	}

	public void setLattitude(long lattitude) {
		this.lattitude = lattitude;
	}

	public long getLongitude() {
		return longitude;
	}

	public void setLongitude(long longitude) {
		this.longitude = longitude;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public float getFuelVolume() {
		return fuelVolume;
	}

	public void setFuelVolume(float fuelVolume) {
		this.fuelVolume = fuelVolume;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getEngineHp() {
		return engineHp;
	}

	public void setEngineHp(int engineHp) {
		this.engineHp = engineHp;
	}

	public boolean isCheckEngineLightOn() {
		return checkEngineLightOn;
	}

	public void setCheckEngineLightOn(boolean checkEngineLightOn) {
		this.checkEngineLightOn = checkEngineLightOn;
	}

	public boolean isEngineCoolantLow() {
		return engineCoolantLow;
	}

	public void setEngineCoolantLow(boolean engineCoolantLow) {
		this.engineCoolantLow = engineCoolantLow;
	}

	public boolean isCruiseControlOn() {
		return cruiseControlOn;
	}

	public void setCruiseControlOn(boolean cruiseControlOn) {
		this.cruiseControlOn = cruiseControlOn;
	}

	public long getEngineRpm() {
		return engineRpm;
	}

	public void setEngineRpm(long engineRpm) {
		this.engineRpm = engineRpm;
	}

	public String getVin() {
		return vin;
	}

	public Tires getTires() {
		return tires;
	}

	public void setTires(Tires tires) {
		this.tires = tires;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	@Override
	public String toString() {
		return "Reading [id=" + id + ", vin=" + vin + ", lattitude=" + lattitude + ", longitude=" + longitude
				+ ", timeStamp=" + timeStamp + ", fuelVolume=" + fuelVolume + ", speed=" + speed + ", engineHp="
				+ engineHp + ", checkEngineLightOn=" + checkEngineLightOn + ", engineCoolantLow=" + engineCoolantLow
				+ ", cruiseControlOn=" + cruiseControlOn + ", engineRpm=" + engineRpm + ", tires=" + tires + "]";
	}

}
