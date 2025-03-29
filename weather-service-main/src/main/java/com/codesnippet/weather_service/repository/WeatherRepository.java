package com.codesnippet.weather_service.repository;


import com.codesnippet.weather_service.entity.Weather;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WeatherRepository extends JpaRepository<Weather, Long> {

    Optional<Weather> findByCity(String city);
    void deleteByCity(String city);
}
