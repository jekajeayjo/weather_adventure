package md.weatherAdventure.controller;

import md.weatherAdventure.dto.CityDto;
import md.weatherAdventure.dto.CountryDto;
import md.weatherAdventure.service.impl.CityServiceImpl;
import md.weatherAdventure.service.impl.CountryServiceIMpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.PushBuilder;
import java.util.Set;

@RestController
@RequestMapping(CountryController.URL_PREFIX)
public class CountryController {

    public static final String URL_PREFIX = "/country";
    private static final String GET_ALL_COUNTRY = "/all_countries";
    private static final String GET_ALL_CITY = "/all_city";
    private static final String GET_CITY_BY_COUNTRY = "/city/{countryId}";

    CountryServiceIMpl countryServiceIMpl;
    CityServiceImpl cityService;

    @Autowired
    public void setCountryServiceIMpl(CountryServiceIMpl countryServiceIMpl) {
        this.countryServiceIMpl = countryServiceIMpl;
    }

    @Autowired
    public void setCityService(CityServiceImpl cityService) {
        this.cityService = cityService;
    }

    @RequestMapping(method = RequestMethod.GET, value = GET_ALL_CITY)
    public Set<Object> getAllCity() {
        return null;
    }

    @RequestMapping(method = RequestMethod.GET, value = GET_ALL_COUNTRY)
    public Set<CountryDto> getAllCountry() {
        return countryServiceIMpl.getAlllCountries();
    }

    @RequestMapping(method = RequestMethod.GET, value = GET_CITY_BY_COUNTRY)
    public Set<CityDto> getCityByCountry(@PathVariable Long countryId) {

        return cityService.findByCountryId(countryServiceIMpl.findById(countryId));
    }
}
