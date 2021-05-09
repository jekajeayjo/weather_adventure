package md.weatherAdventure.service.impl;

import md.weatherAdventure.service.SendToGateService;
import md.weatherAdventure.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("weather")
public class WeatherServiceImpl implements WeatherService {

    SendToGateService sendToGateService;


    @Autowired
    @Qualifier("rest")
    public void setSendToGateService(SendToGateService sendToGateService) {
        this.sendToGateService = sendToGateService;
    }

    @Override
    public Object getWeatherOfcurrentCountry(String country) {
        return null;
    }

    @Override
    public Object getWethersFromCountries(Set<String> stringSet) {
        return null;
    }
}
