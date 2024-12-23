package org.parkinglot;

public class CostStrategy {
    private static final double BIKE_COST_PER_HOUR = 10.0;
    private static final double CAR_COST_PER_HOUR = 20.0;
    private static final double BUS_COST_PER_HOUR = 30.0;

    public double calculateCost(String vehicleType, long hoursParked) {
        double ratePerHour = 0.0;

        switch (vehicleType) {
            case "Bike":
                ratePerHour = BIKE_COST_PER_HOUR;
                break;
            case "Car":
                ratePerHour = CAR_COST_PER_HOUR;
                break;
            case "Bus":
                ratePerHour = BUS_COST_PER_HOUR;
                break;
            default:
                System.out.println("Unknown vehicle type: " + vehicleType);
        }

        // If ratePerHour is still 0, the vehicle type was not recognized properly
        if (ratePerHour == 0.0) {
            System.out.println("Error: Invalid vehicle type or missing cost.");
        }

        // Calculate the total cost based on the hours parked and the vehicle type rate
        return ratePerHour * hoursParked;
    }


}