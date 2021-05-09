package md.weatherAdventure.controller;

import md.weatherAdventure.dto.WeatherDto;
import md.weatherAdventure.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import java.util.Set;

@RestController
@RequestMapping(TravelController.URL_RREFIX)
public class TravelController {

    public static final String URL_RREFIX = "/travel";
    public static final String SAVE = "/save/{cityId}";
    public static final String LIST = "/list";
    public static final String GET_ONE = "/get_one/{id}";

    WeatherService weatherService;

    @Autowired
    public void setWeatherService(WeatherService weatherService) {
        this.weatherService = weatherService;
    }


    @RequestMapping(method = RequestMethod.GET, value = LIST)
    public Set<WeatherDto> list() {

        return weatherService.list();
    }

    @RequestMapping(method = RequestMethod.GET, value = SAVE)
    public WeatherDto save(@PathVariable Long cityId)
    {

        return weatherService.save(cityId);
    }

}
