package org.parkinglot;

import java.util.*;

public class Floor {
    private int floorNumber;
    private List<VehicleSpace> spaces;

    
    public Floor(int floorNumber, int spacesPerType) {
        this.floorNumber = floorNumber;
        this.spaces = new ArrayList<>();
      
        for (int i = 0; i < spacesPerType * 3; i++) {
            spaces.add(new VehicleSpace());
        }
    }

  
    public int getFloorNumber() {
        return floorNumber;
    }

 
    public int parkVehicle(Vehicle vehicle) {
        String vehicleType = vehicle.getType();
        for (int i = 0; i < spaces.size(); i++) {
            
            if (spaces.get(i).isAvailable() && spaces.get(i).getVehicleType().equals("None")) {
                spaces.get(i).setVehicle(vehicle);
                return i + 1; 
            }
        }
        return -1; 
    }

    // Display floor status
    public void displayStatus() {
        System.out.println("Floor " + floorNumber + " Status:");
        System.out.println("Car: Available: " + getAvailableSpaces("Car") + ", Occupied: " + (spaces.size() - getAvailableSpaces("Car")));
        System.out.println("Bike: Available: " + getAvailableSpaces("Bike") + ", Occupied: " + (spaces.size() - getAvailableSpaces("Bike")));
        System.out.println("Bus: Available: " + getAvailableSpaces("Bus") + ", Occupied: " + (spaces.size() - getAvailableSpaces("Bus")));
    }

  
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
