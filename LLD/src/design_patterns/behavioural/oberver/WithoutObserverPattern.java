package design_patterns.behavioural.oberver;

class DisplayDevice {
	public void showTemp(float temp) {
		System.out.println("Current Temp: " + temp + " C");
	}
}

class WeatherStation {
	private float temperature;
	private DisplayDevice device;

	public WeatherStation(DisplayDevice device) {
		this.device = device;
	}

	public void setTemperature(float temperature) {
		this.temperature = temperature;
		notifyDevice(temperature);
	}

	public void notifyDevice(float temperature) {
		device.showTemp(temperature);
	}
}

public class WithoutObserverPattern {

	public static void main(String[] args) {
		DisplayDevice device = new DisplayDevice();
		WeatherStation weatherStation = new WeatherStation(device);
		weatherStation.setTemperature(30);
		weatherStation.setTemperature(45);
	}
}
