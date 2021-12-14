package com.cars;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cars")
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cid;
	
	private String brand;
	private String model;
	private int year;
	private int no_of_km;
	private int price;
	private String fuel;
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
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
	public int getNo_of_km() {
		return no_of_km;
	}
	public void setNo_of_km(int no_of_km) {
		this.no_of_km = no_of_km;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getFuel() {
		return fuel;
	}
	public void setFuel(String fuel) {
		this.fuel = fuel;
	}
	@Override
	public String toString() {
		return "Car [cid=" + cid + ", brand=" + brand + ", model=" + model + ", year=" + year + ", no_of_km=" + no_of_km
				+ ", price=" + price + ", fuel=" + fuel + "]";
	}
	public Car(int cid, String brand, String model, int year, int no_of_km, int price, String fuel) {
		super();
		this.cid = cid;
		this.brand = brand;
		this.model = model;
		this.year = year;
		this.no_of_km = no_of_km;
		this.price = price;
		this.fuel = fuel;
	}
	public Car() {
		super();
	}
}