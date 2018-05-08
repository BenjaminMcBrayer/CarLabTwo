//Benjamin McBrayer, 5.7.2018
//This Java console application permits users to select cars for purchase from an inventory.

package com.cars.gc;

import java.util.ArrayList;
import java.util.Scanner;

public class CarApp {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		ArrayList<Car> carList = new ArrayList<>(7);
		ArrayList<Integer> inventoryNums = new ArrayList<>(7);
		Car a = new Car("Nikolai", "Model S", 2018, 54999.90, "new", 0);
		Car b = new Car("Fourd", "Escapade", 2018, 31999.90, "new", 0);
		Car c = new Car("Chewie", "Vette", 2018, 44989.95, "new", 0);
		int userNum = 0;
		int i = 0;
		String purchaseCar;
		UsedCar d = new UsedCar("Bugatti", "Atlantic", 1936, 99999.99, "used", 95959);
		UsedCar e = new UsedCar("Tucker", "Torpedo", 1948, 89898.89, "used", 333333);
		UsedCar f = new UsedCar("Alfa Romeo", "Stradale", 1967, 98786.99, "used", 67676);

		// Populate ArrayLists with inventory numbers and cars.
		inventoryNums.add(1);
		inventoryNums.add(2);
		inventoryNums.add(3);
		inventoryNums.add(4);
		inventoryNums.add(5);
		inventoryNums.add(6);
		inventoryNums.add(7);
		carList.add(a);
		carList.add(b);
		carList.add(c);
		carList.add(d);
		carList.add(e);
		carList.add(f);

		do {

			displayCategories(inventoryNums, carList);

			userNum = Validator.getInt(scnr, "\nWhich car would you like? ", 1, carList.size() + 1);

			// Exit the loop if userNum is greater than the number of Cars/UsedCars in
			// carList.
			if (userNum == carList.size() + 1) {
				System.out.println("Have a great day!");
				break;
			} else {
				selectAndDisplayCar(carList, userNum);
				purchaseCar = Validator.getString(scnr, "Would you like to buy this car (y/n)? ");
				// Remove Car/UsedCar from carList and decrease the size of inventoryNums by
				// one.
				if (purchaseCar.equalsIgnoreCase("y")) {
					System.out.println("Excellent! Our finance department will be in touch shortly.");
					i = userNum - 1;
					carList.remove(i);
					inventoryNums.remove(inventoryNums.size() - 1);
				}
				if (purchaseCar.equalsIgnoreCase("n")) {
					System.out.println("Have a great day!");
					break;
				}
			}

		} while (purchaseCar.equalsIgnoreCase("y"));

		scnr.close();
	}

	// Methods.
	public static void selectAndDisplayCar(ArrayList<Car> carList, int userNum) {
		if (userNum == 1) {
			System.out.println(carList.get(0));

		} else if (userNum == 2) {
			System.out.println(carList.get(1));

		} else if (userNum == 3) {
			System.out.println(carList.get(2));

		} else if (userNum == 4) {
			System.out.println(carList.get(3));

		} else if (userNum == 5) {
			System.out.println(carList.get(4));

		} else if (userNum == 6) {
			System.out.println(carList.get(5));
		}
	}

	public static void displayCategories(ArrayList<Integer> inventoryNums, ArrayList<Car> carList) {
		System.out.println("Current Inventory: ");
		System.out.printf("%1$-4s %2$-15s %3$-15s %4$-8s %5$-15s %6$-15s %7$-15s", "", "Make", "Model", "Year", "Price",
				"Condition", "Mileage");
		System.out.printf("\n%1$-4s %2$-15s %3$-15s %4$-8s %5$-15s %6$-15s %7$-15s", "", "=======", "=======", "====",
				"=======", "=======", "=======");

		for (int i = 0; i < inventoryNums.size() - 1; ++i) {
			System.out.printf("\n%1$-5s", inventoryNums.get(i) + ".");
			System.out.print(carList.get(i));
		}
		System.out.printf("\n%1$-5s %2$-15s", inventoryNums.get(inventoryNums.size() - 1) + ".", "Quit");
	}
}
