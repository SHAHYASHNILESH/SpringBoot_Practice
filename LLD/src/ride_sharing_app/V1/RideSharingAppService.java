package ride_sharing_app.V1;

import java.util.ArrayList;
import java.util.List;

public class RideSharingAppService {
    //Matching Service
    private List<Driver> drivers = new ArrayList<>();
    private List<Passenger> passengers = new ArrayList<>();

    //Methods to add Drivers and Passengers
    public void addDriver(Driver driver){
        drivers.add(driver);
    }
    public void addPassenger(Passenger passenger){
        passengers.add(passenger);
    }

    //Booking Ride
    public void bookRide(Passenger passenger,double distance){
        //corner case
        if(drivers.isEmpty()){
            System.out.println("No drivers are available for " + passenger.name);
            return;
        }
        // Hard-coded assignment logic
        // find the nearest driver
        // O(N) Brute Force
        Driver assignedDriver = null;
        double minDistance = Double.MAX_VALUE;

        for(Driver driver:drivers){
            double currentDriverDistance = calcDistance(passenger.location,driver.location);
            if(currentDriverDistance<minDistance){
                minDistance = currentDriverDistance;
                assignedDriver = driver;
            }
        }
        //Fare Calculation
        double expectedFare = calcFare(assignedDriver.getVehicle(),distance);

        // Track the driver state - BOOKED/AVAILABLE

        // Show the driver and fare to the passenger
        System.out.println("Ride booked for "+passenger.name + " with driver " + assignedDriver.getName() +" for a fare of " + expectedFare);
        System.out.println("Driver is on the way " + assignedDriver.getName());
    }

    private double calcFare(Vehicle vehicle,double distance){
        if(vehicle.type.equals("Car")){
            return distance*20;
        }
        else if(vehicle.type.equals(10)){
            return distance*10;
        }
        else{
            return distance*8; //hard-code value
        }
    }

    private double calcDistance(Location one, Location two){
        //Euclidean Distance
        double dx = one.getLatitude() - two.getLatitude();
        double dy = one.getLongitude() - two.getLongitude();
        return Math.sqrt(dx*dx + dy*dy);
    }
}
