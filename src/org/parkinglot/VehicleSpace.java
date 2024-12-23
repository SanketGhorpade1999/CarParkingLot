package org.parkinglot;

public class VehicleSpace {
    private boolean available; // True if available, false if occupied
    private String vehicleType; // Type of vehicle (Car, Bike, Bus)
    private Vehicle vehicle; // The actual vehicle in this space

    // Constructor
    public VehicleSpace() {
        this.available = true; // Initially, all spaces are available
        this.vehicleType = "None"; // Default vehicle type, "None" means no vehicle
        this.vehicle = null; // No vehicle is parked yet
    }

    // Get the vehicle type for this space
    public String getVehicleType() {
        return vehicleType;
    }

    // Set the vehicle in this space
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.vehicleType = vehicle.getType(); // Set the vehicle type based on the vehicle parked
        this.available = false; // Once a vehicle is parked, the space is no longer available
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
