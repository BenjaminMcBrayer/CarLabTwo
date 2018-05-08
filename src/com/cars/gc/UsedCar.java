//Benjamin McBrayer, 5.7.2018
//The Car class already contains private instance variables for condition and mileage. 
//Trying to override the toString() method in the UsedCar class made it difficult to format the inventory display.

package com.cars.gc;

public class UsedCar extends Car {

	public UsedCar(String make, String model, int year, double price, String condition, double mileage) {
		super(make, model, year, price, condition, mileage);
	}
}
