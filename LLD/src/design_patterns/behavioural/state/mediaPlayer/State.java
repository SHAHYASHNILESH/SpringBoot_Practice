package design_patterns.behavioural.state.mediaPlayer;

public interface State {
	void pressPlay();

	void pressStop();

	void pressPause();

	void display();
}
