package design_patterns.structural.facade.home_theater_system;

import java.util.Scanner;

public class Exercise {

    // Do not modify the run method. It demonstrates the usage of the Home Theater system facade to watch a movie.
    public void run() {

        Scanner sc = new Scanner(System.in);
        HomeTheaterFacade homeTheater = new HomeTheaterFacade();

        int dimmingPercentage = sc.nextInt();

        int volumeLevel = sc.nextInt();

        // TODO: Initiate the movie-watching experience by providing the dimming percentage and the volume level
        homeTheater.watchMovie(dimmingPercentage, volumeLevel);


        sc.close();
    }
}
