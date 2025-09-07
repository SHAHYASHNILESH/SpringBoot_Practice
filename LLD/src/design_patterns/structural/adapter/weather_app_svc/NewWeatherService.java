package design_patterns.structural.adapter.weather_app_svc;

public class NewWeatherService {

    private String temperature;
    private String condition;

    public NewWeatherService(String temperature, String condition) {
        this.temperature = temperature;
        this.condition = condition;
    }

    public String getTemperature() {
        return temperature;
    }

    public String getCondition() {
        return condition;
    }

    public String fetchWeather() {
        return "{\"temperature\": " + temperature + ", \"condition\": \"" + condition + "\"}";
    }
}
