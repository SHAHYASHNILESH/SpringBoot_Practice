package ride_sharing_app.V1;

public class Driver {
    private String name;
    private Vehicle vehicle;
    Location location;

    public Driver(String name, Location location, Vehicle vehicle) {
        this.name = name;
        this.vehicle = vehicle;
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}