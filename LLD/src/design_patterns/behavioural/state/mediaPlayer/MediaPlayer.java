package design_patterns.behavioural.state.mediaPlayer;

public class MediaPlayer {

	private State state;

	public MediaPlayer() {
		// TODO: Set the initial state of the Media Player to PlayingState
		this.state = new PlayingState();
	}

	public void setState(State state) {
		this.state = state;
	}

	public void play() {
		// TODO: Implement the functionality for pressing play
		state.pressPlay();
	}

	public void stop() {
		// TODO: Implement the functionality for pressing stop
		state.pressStop();
	}

	public void pause() {
		// TODO: Implement the functionality for pressing pause
		state.pressPause();
	}

	public void displayState() {
		// TODO: Implement the functionality to display the current state
		state.display();
	}
}
