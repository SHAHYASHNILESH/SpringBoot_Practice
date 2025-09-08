package design_patterns.structural.facade.home_theater_system;

public class HomeTheaterFacade {

    private DVDPlayer dvdPlayer;
    private Projector projector;
    private SoundSystem soundSystem;
    private LightingControl lightingControl;

    public HomeTheaterFacade() {
        this.dvdPlayer = new DVDPlayer();
        this.projector = new Projector();
        this.soundSystem = new SoundSystem();
        this.lightingControl = new LightingControl();
    }

    public void watchMovie(int dimmingPercentage, int volumeLevel) {
        System.out.println("Get ready to watch a movie");

        // TODO: Dim the lights to the specified percentage
        lightingControl.dim(dimmingPercentage);

        // TODO: Turn on the projector
        projector.on();

        // TODO: Set the projector input to DVD
        projector.setInput();

        // TODO: Turn on the sound system.
        soundSystem.on();

        // TODO: Set the sound system volume to the specified level.
        soundSystem.setVolume(volumeLevel);

        // TODO: Play the DVD.
        dvdPlayer.play();

        System.out.println("Movie is ready to watch!");
    }
}
