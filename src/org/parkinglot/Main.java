package org.parkinglot;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       
        ParkingLot parkingLot = new ParkingLot(1, 2);

        while (true) {
            System.out.println("\nParking Lot System");
            System.out.println("1. Add Vehicle");
            System.out.println("2. Remove Vehicle by Token");
            System.out.println("3. Display Parking Lot Status");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter Vehicle Type (Car/Bike/Bus): ");
                    String type = scanner.nextLine();
                    System.out.print("Enter Vehicle Registration Number: ");
                    String regNumber = scanner.nextLine();
                    System.out.print("Enter Vehicle Color: ");
                    String color = scanner.nextLine();

                    // Create a new Vehicle and try to add it to the parking lot
                    Vehicle vehicle = new Vehicle(regNumber, type, color);
                    parkingLot.addVehicle(vehicle);
                    break;

                case 2:
                    System.out.print("Enter Vehicle Token ID: ");
                    String tokenId = scanner.nextLine();
                    parkingLot.removeVehicle(tokenId);
                    break;

                case 3:
                    parkingLot.displayStatus();
                    break;

                case 4:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
