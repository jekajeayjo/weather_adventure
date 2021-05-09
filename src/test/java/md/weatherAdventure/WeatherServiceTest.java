package md.weatherAdventure;

import md.weatherAdventure.dto.WeatherDto;
import md.weatherAdventure.entity.WeatherEntity;
import md.weatherAdventure.service.WeatherService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Set;

public class WeatherServiceTest extends AbstractTest {

    private WeatherService weatherService;

    @Autowired
    @Qualifier("weather")
    public void setWeatherService(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @Test
    public void listWethers() {
        Set<WeatherDto> set=list();
        Set<WeatherDto> setOne=list();
    }

    private Set< WeatherDto> list() {
        System.out.println("check test");
        return weatherService.listTest();
    }
}
