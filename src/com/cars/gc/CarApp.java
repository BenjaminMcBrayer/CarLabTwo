//Benjamin McBrayer, 5.7.2018
//This Java console application permits users to select cars for purchase from an inventory.

package com.cars.gc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CarApp {

	public static void main(String[] args) {
		// Declare and initialize variables.
		Scanner scnr = new Scanner(System.in);
		int userNum = 0;
		int i = 0;
		String purchaseCar;

		// Create car and used car objects.
		Car a = new Car("Nikolai", "Model S", 2018, 54999.90, "new");
		Car b = new Car("Fourd", "Escapade", 2018, 31999.90, "new");
		Car c = new Car("Chewie", "Vette", 2018, 44989.95, "new");
		Car d = new UsedCar("Bugatti", "Atlantic", 1936, 99999.99, "used", 95959);
		Car e = new UsedCar("Tucker", "Torpedo", 1948, 89898.89, "used", 333333);
		Car f = new UsedCar("Alfa Romeo", "Stradale", 1967, 98786.99, "used", 67676);

		// Populate ArrayLists with inventory numbers and cars.
		ArrayList<Integer> inventoryNums = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
		ArrayList<Car> carList = new ArrayList<>(Arrays.asList(a, b, c, d, e, f));

		do {
			displayInventory(inventoryNums, carList);

			userNum = Validator.getInt(scnr, "\nWhich car would you like? ", 1, carList.size() + 1);

			// Exit loop if userNum is greater than number of Cars/UsedCars in carList.
			if (userNum == carList.size() + 1) {
				System.out.println("Have a great day!");
				break;
			} else {
				selectAndDisplayCar(carList, userNum);
				purchaseCar = Validator.getString(scnr, "Would you like to buy this car (y/n)? ");
				// Remove Car/UsedCar from carList and decrease size of inventoryNums by one.
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

	public static void displayInventory(ArrayList<Integer> inventoryNums, ArrayList<Car> carList) {
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
