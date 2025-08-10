package design_patterns.behavioural.state.mediaPlayer;

public class StoppedState implements State {

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
		System.out.println("Can't pause. Media is already stopped");
	}

	@Override
	public void display() {
		System.out.println("Current State: Stopped");
	}
}