//Benjamin McBrayer, 5.7.2018
//The Car class already contains private instance variables for condition and mileage. 
//Trying to override the toString() method in the UsedCar class made it difficult to format the inventory display.

package com.cars.gc;

public class UsedCar extends Car {

	private double mileage;

	public UsedCar(String make, String model, int year, double price, String condition, double mileage) {
		super(make, model, year, price, condition);
		this.setMileage(mileage);
	}

	public double getMileage() {
		return mileage;
	}

	public void setMileage(double mileage) {
		this.mileage = mileage;
	}
	
	@Override
    public String toString(){
        return super.toString() + String.format("%6$,-15.2f", getMileage());
    }
}
