package org.parkinglot;

import java.util.*;

public class Floor {
    private int floorNumber;
    private List<VehicleSpace> spaces;

    // Constructor to initialize the floor and the parking spaces
    public Floor(int floorNumber, int spacesPerType) {
        this.floorNumber = floorNumber;
        this.spaces = new ArrayList<>();
        // Initialize spaces for Car, Bike, and Bus (3 types of vehicles)
        for (int i = 0; i < spacesPerType * 3; i++) {
            spaces.add(new VehicleSpace());
        }
    }

    // Get the floor number
    public int getFloorNumber() {
        return floorNumber;
    }

    // Park a vehicle and return the space number
    public int parkVehicle(Vehicle vehicle) {
        String vehicleType = vehicle.getType();
        for (int i = 0; i < spaces.size(); i++) {
            // Only park the vehicle in an available space that matches the vehicle type
            if (spaces.get(i).isAvailable() && spaces.get(i).getVehicleType().equals("None")) {
                spaces.get(i).setVehicle(vehicle);
                return i + 1;  // Return space number (1-based index)
            }
        }
        return -1;  // No space available
    }

    // Display floor status
    public void displayStatus() {
        System.out.println("Floor " + floorNumber + " Status:");
        System.out.println("Car: Available: " + getAvailableSpaces("Car") + ", Occupied: " + (spaces.size() - getAvailableSpaces("Car")));
        System.out.println("Bike: Available: " + getAvailableSpaces("Bike") + ", Occupied: " + (spaces.size() - getAvailableSpaces("Bike")));
        System.out.println("Bus: Available: " + getAvailableSpaces("Bus") + ", Occupied: " + (spaces.size() - getAvailableSpaces("Bus")));
    }

    // Get the available spaces for a specific vehicle type (Car, Bike, Bus)
    public int getAvailableSpaces(String vehicleType) {
        int availableSpaces = 0;
        for (VehicleSpace space : spaces) {
            if (space.isAvailable() && space.getVehicleType().equals(vehicleType)) {
                availableSpaces++;
            }
        }
        return availableSpaces;
    }
}
