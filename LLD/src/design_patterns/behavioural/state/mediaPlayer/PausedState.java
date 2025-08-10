package design_patterns.behavioural.state.mediaPlayer;

public class PausedState implements State {

	@Override
	public void pressPlay() {
		System.out.println("Resuming playback");
	}

	@Override
	public void pressStop() {
		System.out.println("Stopping playback from pause");
	}

	@Override
	public void pressPause() {
		System.out.println("Pausing playback");
	}

	@Override
	public void display() {
		System.out.println("Current State: Paused");
	}
}