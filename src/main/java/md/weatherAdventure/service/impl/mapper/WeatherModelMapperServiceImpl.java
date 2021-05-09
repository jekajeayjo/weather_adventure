package md.weatherAdventure.service.impl.mapper;

import md.weatherAdventure.dto.WeatherDto;
import md.weatherAdventure.entity.CityEntity;
import md.weatherAdventure.entity.WeatherEntity;
import md.weatherAdventure.repository.CityRepository;
import md.weatherAdventure.repository.WeatherRepository;
import md.weatherAdventure.service.ModelMapperService;
import md.weatherAdventure.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Service("weatherMapper")
public class WeatherModelMapperServiceImpl implements ModelMapperService<WeatherDto, WeatherEntity> {
    WeatherRepository weatherRepository;
    CityRepository cityRepository;

    @Autowired
    public void setCityRepository(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Autowired
    public void setWeatherRepository(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    @Override
    @CachePut(value = "weather", key = "#entity.id")
    public WeatherDto entityToDto(WeatherEntity entity) {
        WeatherDto dto = new WeatherDto();
        dto.setId(entity.getId());
        dto.setCountryId(entity.getCityEntity().getCountryEntity().getId());
        dto.setCountryName(entity.getCityEntity().getCountryEntity().getName_en());
        dto.setCityId(entity.getCityEntity().getId());
        dto.setCityName(entity.getCityEntity().getName_en());
        dto.setMain(entity.getMain());
        dto.setWindSpeed(entity.getWidnSpeed());
        dto.setWindGed(entity.getWindDeg());
        dto.setTemp(entity.getTemp());
        dto.setFeelsLike(entity.getFeelsLike());
        dto.setPressure(entity.getPressure());
        dto.setHumidity(entity.getHumidity());
        return dto;
    }

    @Override

    public WeatherEntity dtoToEntity(WeatherDto dto) {
        WeatherEntity weatherEntity = null;

        if (dto.getId() == null) {
            weatherEntity.setCityEntity(cityRepository.getOne(dto.getCityId()));
        }
        return null;
    }

    /*
     * TODO FIX FROM MAP TO ENTITY
     * */
    @Override
    public WeatherEntity FromMapToEntity(Map map) {
        WeatherEntity weatherEntity = new WeatherEntity();
        map.forEach((key, value) ->
        {
            if (key.equals("weather")) {
                List weathers = (List) value;
                Map weather = (Map) weathers.get(0);
                weather.forEach((weatherKey, weatherValue) ->
                {
                    if (weatherKey.equals("main")) {
                        weatherEntity.setMain((String) weatherValue);
                    } else if (weatherKey.equals("description")) {
                        weatherEntity.setDescription((String) weatherValue);
                    }
                });
            } else if (key.equals("main")) {
                Map main = (Map) value;
                main.forEach((mainKey, mainValue) -> {
                    if (mainKey.equals("temp")) {
                        weatherEntity.setTemp((double) mainValue);
                    } else if (mainKey.equals("feels_like")) {
                        weatherEntity.setFeelsLike((double) mainValue);
                    } else if (mainKey.equals("temp_min")) {
                        weatherEntity.setTempMin((double) mainValue);
                    } else if (mainKey.equals("temp_max")) {
                        weatherEntity.setTempMax((double) mainValue);
                    } else if (mainKey.equals("pressure")) {
                        weatherEntity.setPressure((double) mainValue);
                    } else if (mainKey.equals("humidity")) {
                        weatherEntity.setHumidity((double) mainValue);
                    }
                });
            } else if (key.equals("wind")) {
                Map wind = (Map) value;
                wind.forEach((windKey, windValue) ->
                {
                    if (windKey.equals("speed")) {
                        weatherEntity.setWidnSpeed((double)windValue);
                    }
                    else if (windKey.equals("deg")) {
                        weatherEntity.setWindDeg((double)windValue);
                    }

                });
            }
        });
        return weatherEntity;
    }
}
