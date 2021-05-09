package md.weatherAdventure.service.impl;

import com.google.gson.Gson;
import md.weatherAdventure.config.security.jwt.JwtTokenProvider;
import md.weatherAdventure.dto.WeatherDto;
import md.weatherAdventure.entity.CityEntity;
import md.weatherAdventure.entity.UserEntity;
import md.weatherAdventure.entity.WeatherEntity;
import md.weatherAdventure.repository.WeatherRepository;
import md.weatherAdventure.service.ModelMapperService;
import md.weatherAdventure.service.SendToGateService;
import md.weatherAdventure.service.UserService;
import md.weatherAdventure.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service("weather")
public class WeatherServiceImpl implements WeatherService {
    @Value("${weather.url}")
    private String url;
    @Value("${weather.api.key}")
    private String apiKeyWeather;
    WeatherRepository weatherRepository;
    SendToGateService sendToGateService;
    JwtTokenProvider jwtTokenProvider;
    UserService userService;
    ModelMapperService<WeatherDto, WeatherEntity> modelMapperService;
    CityServiceImpl cityService;

    @Autowired
    public void setCityService(CityServiceImpl cityService) {
        this.cityService = cityService;
    }

    @Autowired
    public void setWeatherRepository(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    @Autowired
    public void setJwtTokenProvider(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    @Qualifier("rest")
    public void setSendToGateService(SendToGateService sendToGateService) {
        this.sendToGateService = sendToGateService;
    }

    @Autowired
    @Qualifier("weatherMapper")
    public void setModelMapperService(ModelMapperService<WeatherDto, WeatherEntity> modelMapperService) {
        this.modelMapperService = modelMapperService;
    }

    @Override
    public Set<WeatherDto> list() {
//        UserEntity userEntity = ;

        return weatherRepository
                .findByUserEntity(userService.findById(jwtTokenProvider.getId())).stream()
                .map(WeatherDto::new).collect(Collectors.toSet());
    }

    @Override
    @Cacheable(value = "weathers")
    public Set<WeatherDto> listTest() {
        System.out.println("formDb");
        List<WeatherEntity> entities = weatherRepository.findAll();
        Set<WeatherDto> set = entities.stream()
                .map(WeatherDto::new).collect(Collectors.toSet());
        return set;
    }

    @Override
    @Cacheable(value = "weathers", key = "#id")
    public WeatherDto save(Long id) {
        System.out.println("get From gate");
        Gson gson = new Gson();
        CityEntity cityEntity = cityService.findById(id);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(url)
                .append("?")
                .append("id=")
                .append(cityEntity.getCityId().toString())
                .append("&")
                .append("appid=")
                .append(apiKeyWeather);
//        Map answer =gson.fromJson(sendToGateService.sendGetRequest(stringBuilder.toString()), Map.class) ;

        WeatherEntity weatherEntity = modelMapperService
                .FromMapToEntity(gson
                        .fromJson(sendToGateService
                                .sendGetRequest(stringBuilder
                                        .toString()), Map.class));
        weatherEntity.setUserEntity(userService.findById(jwtTokenProvider.getId()));
        weatherEntity.setCityEntity(cityEntity);
        weatherEntity.setLocalDateTime(LocalDateTime.now());
        return modelMapperService
                .entityToDto(weatherRepository
                        .saveAndFlush(weatherEntity));
    }

    @Override
    public WeatherDto getOne(Long id) {
        return null;
    }


}
