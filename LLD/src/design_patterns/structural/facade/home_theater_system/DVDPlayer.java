package design_patterns.structural.facade.home_theater_system;

public class DVDPlayer {

    public void play() {
        System.out.println("DVD Player: Playing the movie");
    }

    public void pause() {
        System.out.println("DVD Player: Paused the movie");
    }

    public void stop() {
        System.out.println("DVD Player: Stopped the movie");
    }
}
