package com.codesnippet.weather_service.controller;


import com.codesnippet.weather_service.entity.Weather;
import com.codesnippet.weather_service.repository.WeatherRepository;
import com.codesnippet.weather_service.service.CacheInspectionService;
import com.codesnippet.weather_service.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @Autowired
    private WeatherRepository weatherRepository;
    @Autowired
    CacheInspectionService cacheInspectionService;

    @GetMapping
    public String getWeather(@RequestParam String city) {
        String weatherByCity
                = weatherService.getWeatherByCity(city);
        return weatherByCity;
    }

    @PostMapping
    public Weather addWeather(@RequestBody Weather weather) {
        return weatherRepository.save(weather);
    }

    @GetMapping("/all")
    public List<Weather> getAllWeather() {
        return weatherRepository.findAll();
    }
    @GetMapping("/cacheData")
    public void getCacheDate() {
        cacheInspectionService.printCacheContents("weather");
    }
    @PutMapping("/{city}")
    public String updateWeather(@PathVariable String city, @RequestParam String weatherUpdate) {
        return weatherService.updateWeather(city, weatherUpdate);
    }
    @DeleteMapping("/{city}")
    public String deleteWeather(@PathVariable String city) {
        weatherService.deleteWeather(city);
        return "Weather data for " + city + " has been deleted and cache evicted.";
    }

}
