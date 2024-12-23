# Parking Lot System

A simple Parking Lot System implemented in Java to manage parking spaces for different types of vehicles (Car, Bike, Bus). This system supports adding vehicles, removing vehicles using a token, and displaying the parking lot's current status.

## Features

- **Add Vehicle**: Park a vehicle in the parking lot, specifying the vehicle type (Car, Bike, Bus), registration number, and color.
- **Remove Vehicle by Token**: Remove a vehicle from the parking lot using the vehicle's unique token ID.
- **Display Parking Lot Status**: Display the current status of all parking floors, including available and occupied spaces for each vehicle type.
- **Parking Full Check**: Handles parking space full error for each vehicle type when there are no available spots.

## Project Structure

1. **Vehicle**: Represents the vehicle object, containing details like registration number, color, vehicle type, and parking time.
2. **VehicleSpace**: Represents a parking space in the parking lot, which holds information about its availability, vehicle type, and the vehicle parked in it.
3. **Floor**: Represents a floor in the parking lot, with multiple parking spaces for different vehicle types.
4. **ParkingLot**: Manages multiple floors and provides methods for adding and removing vehicles, and displaying the status of the parking lot.
5. **Main**: Contains the main method, providing an interactive console-based user interface for interacting with the parking lot system.

## Installation

1. Clone or download the project repository.
   
   ```bash
   git clone https://github.com/your-username/parking-lot-system.git
