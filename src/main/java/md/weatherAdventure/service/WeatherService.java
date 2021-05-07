package md.weatherAdventure.service;

import java.util.Set;

public interface WeatherService {
    Object getWeatherOfcurrentCountry(String country);
    Object getWethersFromCountries(Set<String> stringSet);
}
