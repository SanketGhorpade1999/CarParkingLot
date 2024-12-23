package org.parkinglot;

public class VehicleSpace {
    private boolean available; 
    private String vehicleType; 
    private Vehicle vehicle; 
    // Constructor
    public VehicleSpace() {
        this.available = true; 
        this.vehicleType = "None"; 
        this.vehicle = null; 
    }

    // Get the vehicle type for this space
    public String getVehicleType() {
        return vehicleType;
    }

    // Set the vehicle in this space
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.vehicleType = vehicle.getType(); 
        this.available = false; 
    }

    // Check if the space is available
    public boolean isAvailable() {
        return available;
    }

    // Get the vehicle in the space
    public Vehicle getVehicle() {
        return vehicle;
    }
}
