package design_patterns.behavioural.state;

enum TransportationMode {
	WALKING, CYCLING, CAR, TRAIN
}

public class DirectionService {
	private TransportationMode mode;

	public DirectionService(TransportationMode mode) {
		this.mode = mode;
	}

	public void setMode(TransportationMode mode) {
		this.mode = mode;
	}

	// Method to calc ETA based upon transportation Mode
	public int getETA() {
		switch (mode) {
		case WALKING:
			System.out.println("Calc ETA for walking 10");
			return 10;
		case CYCLING:
			System.out.println("Calc ETA for cycling 5");
			return 5;
		case CAR:
			System.out.println("Calc ETA for car 2");
			return 2;
		case TRAIN:
			System.out.println("Calc ETA for cycling 3");
			return 3;
		default:
			throw new IllegalArgumentException("Unknown Mode");
		}
	}

	public String getDirection() {
		switch (mode) {
		case WALKING:
			return "Directions for walking: Head north for 500 meters.";
		case CYCLING:
			return "Directions for cycling: Take the bike lane on Elm Street.";
		case CAR:
			return "Directions for driving: Use highway 50 towards downtown.";
		case TRAIN:
			return "Directions for train: Board the Red Line at Central Station.";
		default:
			return "No directions available for the selected mode.";
		}
	}
}
