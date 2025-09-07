package design_patterns.structural.adapter.weather_app_svc;

import java.util.Scanner;

public class Exercise {

    // Do not modify the run method. It is designed to demonstrate the usage of legacy and new weather services through the Adapter pattern.
    public void run() {

        Scanner sc = new Scanner(System.in);

        String legacyTemperature = sc.nextLine();
        String legacyCondition = sc.nextLine();

        // Using the legacy weather service with user input
        WeatherService legacyService = new LegacyWeatherService(legacyTemperature, legacyCondition);
        System.out.println("Legacy Weather Service Data:");

        // TODO: Print the weather data retrieved from the Legacy weather service.
        System.out.println(legacyService.getWeatherData());


        String temperature = sc.nextLine();
        String condition = sc.nextLine();

        // TODO: Create an adapter for the new weather service.
        NewWeatherService newService = new NewWeatherService(temperature,condition);


        WeatherService adaptedService = new NewWeatherServiceAdapter(newService);
        System.out.println("New Weather Service Data:");

        // TODO: Print the weather data retrieved from the new weather service.
        System.out.println(adaptedService.getWeatherData());


        sc.close();
    }
}
