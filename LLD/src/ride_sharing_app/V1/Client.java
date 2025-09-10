package ride_sharing_app.V1;

public class Client {
    public static void main(String[] args) {
        Location loc1 = new Location(12.9716, 77.5946);  // Bangalore
        Location loc2 = new Location(12.9352, 77.6245);  // Near Bangalore
        Location loc3 = new Location(13.0352, 77.6175);  // Another place near Bangalore

        // Create Vehicles
        Vehicle car = new Vehicle("AB123CD", "Car");
        Vehicle bike = new Vehicle("XY987Z", "Bike");

        // Create Drivers
        Driver driver1 = new Driver("Alice", loc2, car);
        Driver driver2 = new Driver("Bob", loc3, bike);

        // Create Passengers
        Passenger passenger1 = new Passenger("John", loc1);
        Passenger passenger2 = new Passenger("Rahul", loc3);

        // Ride Sharing App
        RideSharingAppService app = new RideSharingAppService();
        app.addDriver(driver1);
        app.addDriver(driver2);
        app.addPassenger(passenger1);
        app.addPassenger(passenger2);

        //Book the Ride
        app.bookRide(passenger1, 10);
        app.bookRide(passenger2, 20);
        app.bookRide(passenger2, 20);
    }
}
