package design_patterns.structural.facade.home_theater_system;

public class Projector {

    public void on() {
        System.out.println("Projector: Turned on");
    }

    public void off() {
        System.out.println("Projector: Turned off");
    }

    public void setInput() {
        System.out.println("Projector: Input set to DVD");
    }
}
