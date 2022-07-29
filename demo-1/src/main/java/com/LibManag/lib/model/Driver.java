package com.LibManag.lib.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Driver")

public class Driver {
	
	@Id
	@GeneratedValue
	private int did;
	private String driverName;
	private String gender;
	private String carNum;
	private int age;
	private double earnings;
	private int x;
	private int y;
	
	public void setEarnings(double earnings) {
		this.earnings = earnings;
	}
	private boolean status;
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public double getEarnings() {
		return earnings;
	}

	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCarNum() {
		return carNum;
	}
	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	@Override
	public String toString() {
		return "Driver [did=" + did + ", driverName=" + driverName + ", gender=" + gender + ", carNum=" + carNum
				+ ", age=" + age + ", x=" + x + ", y=" + y + ", earnings=" + earnings + ", status=" + status
				+ ", isStatus()=" + isStatus() + ", getEarnings()=" + getEarnings() + ", getDid()=" + getDid()
				+ ", getDriverName()=" + getDriverName() + ", getGender()=" + getGender() + ", getCarNum()="
				+ getCarNum() + ", getAge()=" + getAge() + ", getX()=" + getX() + ", getY()=" + getY() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
   
	

}
