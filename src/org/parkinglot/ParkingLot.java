package org.parkinglot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {
    private List<Floor> floors;
    private Map<String, Vehicle> vehiclesByToken; // Store vehicles by their token ID
    private int totalSpacesPerVehicleType;  // Total spaces for each vehicle type per floor
    private int capacity;  // Total capacity of the parking lot
    private int currentVehicles; // Number of vehicles currently parked

    public ParkingLot(int totalFloors, int spacesPerType) {
        this.capacity = totalFloors * spacesPerType * 3;  // 3 types of vehicles (Car, Bike, Bus)
        this.currentVehicles = 0;
        this.floors = new ArrayList<>();
        this.vehiclesByToken = new HashMap<>();
        this.totalSpacesPerVehicleType = spacesPerType;

        // Initialize each floor with parking spaces for different vehicle types
        for (int i = 1; i <= totalFloors; i++) {
            Floor floor = new Floor(i, spacesPerType);
            this.floors.add(floor);
        }
    }

    // Add vehicle to parking lot
    public void addVehicle(Vehicle vehicle) {
        if (currentVehicles >= capacity) {
            System.out.println("Error: Parking lot is full.");
            return;
        }

        // Check if there is space available for the vehicle type
        boolean parked = false;
        for (Floor floor : floors) {
            int spaceNumber = floor.parkVehicle(vehicle);
            if (spaceNumber != -1) {
                parked = true;
                currentVehicles++;
                vehicle.setParkingTime(System.currentTimeMillis());  // Set the parking time
                vehiclesByToken.put(vehicle.getTokenId(), vehicle);  // Store vehicle by token ID
                System.out.println("Vehicle parked at Floor " + floor.getFloorNumber() + ", Space " + spaceNumber);
                break;
            }
        }

        if (!parked) {
            System.out.println("Error: No space available for " + vehicle.getType());
        }
    }

    // Remove vehicle by token
    public void removeVehicle(String tokenId) {
        Vehicle vehicle = vehiclesByToken.get(tokenId);

        if (vehicle != null) {
            // Calculate the parking duration and cost
            long parkedTime = (System.currentTimeMillis() - vehicle.getParkingTime()) / 1000; // in seconds
            double hoursParked = parkedTime / 3600.0; // Convert to hours
            System.out.println("Vehicle removed: " + vehicle + " | Total Cost: ₹ " + (10 * hoursParked));
            vehiclesByToken.remove(tokenId);  // Remove from map
            currentVehicles--;  // Decrease total vehicles count
        } else {
            System.out.println("Vehicle not found with Token ID: " + tokenId);
        }
    }

    // Display status of the parking lot
    public void displayStatus() {
        for (Floor floor : floors) {
            floor.displayStatus();
        }
    }
}
