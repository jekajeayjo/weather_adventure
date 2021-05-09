package md.weatherAdventure.service.impl.mapper;

import md.weatherAdventure.dto.CountryDto;
import md.weatherAdventure.entity.CountryEntity;
import md.weatherAdventure.service.ModelMapperService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("countryMapper")
public class CountryModelServiceMapper implements ModelMapperService<CountryDto, CountryEntity> {
    @Override
    public CountryDto entityToDto(CountryEntity entity) {
        return null;
    }

    @Override
    public CountryEntity dtoToEntity(CountryDto dto) {
        return null;
    }



    @Override
    public CountryEntity FromMapToEntity(Map map) {
        CountryEntity countryEntity=new CountryEntity();
        map.forEach((key, value) ->
        {
            if (key != null || key != "") {
                if (key.equals("code")) {
                    countryEntity.setCode((String) value);
                }
                else if (key.equals("name"))
                {
                    countryEntity.setName_en((String) value);
                }
            }
        });
        return countryEntity;
    }
}
