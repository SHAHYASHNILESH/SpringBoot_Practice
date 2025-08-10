package design_patterns.behavioural.state.mediaPlayer;

public class PlayingState implements State {

	@Override
	public void pressPlay() {
		System.out.println("Starting playback");
	}

	@Override
	public void pressStop() {
		System.out.println("Stopping playback");
	}

	@Override
	public void pressPause() {
		System.out.println("Pausing playback");
	}

	@Override
	public void display() {
		System.out.println("Current State: Playing");
	}
}
