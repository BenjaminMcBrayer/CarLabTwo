package com.cars.gc;

public class Car {
	private String make;
	private String model;
	private int year;
	private double price;
	private String condition;

	public Car() {
		super();
		make = "";
		model = "";
		year = 0;
		price = 0.0;
	}

	public Car(String make, String model, int year, double price, String condition) {
		super();
		this.make = make;
		this.model = model;
		this.year = year;
		this.price = price;
		this.condition = condition;
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

	public double getPrice() {
		return price;
	}

	public String getFormattedPrice() {
		return formatNumber(getPrice());
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getCondition() {
		return condition;
	}
	
	public void setCondition(String condition) {
		this.condition = condition;
	}

	private String formatNumber(double x) {
		return String.format("%.2f", x);
	}

	@Override
	public String toString() {
		return String.format("%1$-15s %2$-15s %3$-8s $%4$,-15.2f %5$-15s\n", make, model, year, price, condition);
	}
}
