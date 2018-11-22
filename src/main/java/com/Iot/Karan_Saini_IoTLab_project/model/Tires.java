package com.Iot.Karan_Saini_IoTLab_project.model;

public class Tires {
	
	private int id;
	private int frontLeft;
	private int frontRight;
	private int backLeft;
	private int backRight;

	public Tires() {

	}

	public Tires(int id, int frontLeft, int frontRight, int backLeft, int backRight) {
		super();
		this.id = id;
		this.frontLeft = frontLeft;
		this.frontRight = frontRight;
		this.backLeft = backLeft;
		this.backRight = backRight;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFrontLeft() {
		return frontLeft;
	}

	public void setFrontLeft(int frontLeft) {
		this.frontLeft = frontLeft;
	}

	public int getFrontRight() {
		return frontRight;
	}

	public void setFrontRight(int frontRight) {
		this.frontRight = frontRight;
	}

	public int getBackLeft() {
		return backLeft;
	}

	public void setBackLeft(int backLeft) {
		this.backLeft = backLeft;
	}

	public int getBackRight() {
		return backRight;
	}

	public void setBackRight(int backRight) {
		this.backRight = backRight;
	}

	@Override
	public String toString() {
		return "Tires [id=" + id + ", frontLeft=" + frontLeft + ", frontRight=" + frontRight + ", backLeft=" + backLeft
				+ ", backRight=" + backRight + "]";
	}

}
