package md.weatherAdventure.service;

import md.weatherAdventure.dto.WeatherDto;
import md.weatherAdventure.entity.WeatherEntity;

import java.util.Set;

public interface WeatherService {
    Set<WeatherDto> list();
    Set<WeatherDto> listTest();
    WeatherDto save(Long id);
    WeatherDto getOne(Long id);

}
