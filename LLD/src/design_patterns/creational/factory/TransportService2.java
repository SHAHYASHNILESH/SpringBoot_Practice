package design_patterns.creational.factory;

public class TransportService2 {
    public static void main(String[] args) {
        //Direct create objects
        Transport vehicle = TransportFactory.createTransport("bus");
        vehicle.deliver();
    }
}
