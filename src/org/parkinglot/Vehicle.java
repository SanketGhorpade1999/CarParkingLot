package org.parkinglot;

import java.util.UUID;

public class Vehicle {
	 private String registrationNumber;
	    private String color;
	    private String type; // "Car", "Bike", "Bus"
	    private String tokenId;// Unique ID to identify the vehicle
	    private long parkingTime;

	    public Vehicle(String registrationNumber, String color, String type) {
	        this.registrationNumber = registrationNumber;
	        this.color = color;
	        this.type = type;
	        this.tokenId = registrationNumber;  // Using registration number as the token ID
	    }

	    // Getter for token ID
	    public String getTokenId() {
	        return tokenId;
	    }


    public String getType() {
        return type;
    }

    public long getParkingTime() {
        return parkingTime;
    }

    // This method sets the parking time when the vehicle is parked
    public void setParkingTime(long parkingTime) {
        this.parkingTime = parkingTime;
    }

    @Override
    public String toString() {
        return "Vehicle [RegistrationNumber=" + registrationNumber + ", Type=" + type + ", Color=" + color + "]";
    }
}
