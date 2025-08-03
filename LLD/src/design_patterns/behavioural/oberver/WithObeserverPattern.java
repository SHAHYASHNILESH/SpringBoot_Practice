package design_patterns.behavioural.oberver;

import java.util.ArrayList;
import java.util.List;

interface Observer {
	void update(float temperature);
}

class DisplayDevice1 implements Observer {

	@Override
	public void update(float temperature) {
		// TODO Auto-generated method stub
		System.out.println("Current Temperature from Display Device 1: " + temperature + " C");
	}

}

class DisplayDevice2 implements Observer {

	@Override
	public void update(float temperature) {
		// TODO Auto-generated method stub
		System.out.println("Current Temperature from Display Device 2: " + temperature + " C");
	}

}

interface Subject {
	void addObserver(Observer observer);

	void removeObserver(Observer observer);

	void notifyObervers(float temperature);
}

class WeatherStationIn implements Subject {

	private float temperature;
	private List<Observer> observers;

	public WeatherStationIn() {
		this.observers = new ArrayList<Observer>();
	}

	@Override
	public void addObserver(Observer observer) {
		// TODO Auto-generated method stub
		observers.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		// TODO Auto-generated method stub
		observers.remove(observer);
	}

	public void setTemperature(float temperature) {
		this.temperature = temperature;
		notifyObervers(temperature);
	}

	@Override
	public void notifyObervers(float temperature) {
		// TODO Auto-generated method stub
		for (Observer observer : observers) {
			observer.update(temperature);
		}
	}
}

public class WithObeserverPattern {
	public static void main(String[] args) {

		DisplayDevice1 device1 = new DisplayDevice1();
		DisplayDevice2 device2 = new DisplayDevice2();

		WeatherStationIn weatherStationIn = new WeatherStationIn();
		weatherStationIn.addObserver(device1);
		weatherStationIn.addObserver(device2);

		weatherStationIn.setTemperature(24);
		weatherStationIn.setTemperature(30);

		weatherStationIn.removeObserver(device2);
		weatherStationIn.setTemperature(40);
	}
}
