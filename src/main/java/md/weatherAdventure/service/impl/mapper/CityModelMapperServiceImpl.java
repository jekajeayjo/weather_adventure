package md.weatherAdventure.service.impl.mapper;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import md.weatherAdventure.dto.CityDto;
import md.weatherAdventure.entity.CityEntity;
import md.weatherAdventure.service.ModelMapperService;
import md.weatherAdventure.service.impl.CountryServiceIMpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

@Service("cityMapper")
public class CityModelMapperServiceImpl implements ModelMapperService<CityDto, CityEntity> {

    CountryServiceIMpl countryServiceIMpl;

    @Autowired
    public void setCountryServiceIMpl(CountryServiceIMpl countryServiceIMpl) {
        this.countryServiceIMpl = countryServiceIMpl;
    }

    @Override
    public CityDto entityToDto(CityEntity entity) {
        return null;
    }

    @Override
    public CityEntity dtoToEntity(CityDto dto) {
        return null;
    }


    @Override
    public CityEntity FromMapToEntity(Map map) {

        CityEntity cityEntity = new CityEntity();
        map.forEach((key, value) ->
        {
            if (key != null || key != "") {
//                System.out.println("key"+key+"val"+value);
                if (key.equals("id")) {
                    if (value instanceof  Double)
                    {
                        cityEntity.setCityId((double)value);
                    }
                    else if  (value instanceof  String)
                    {
                        cityEntity.setCityId(value.toString());
                    }

                } else if (key.equals("name")) {
                    cityEntity.setName_en((String) value);
                } else if (key.equals("state")) {
                    cityEntity.setState_en((String) value);
                } else if (key.equals("country")) {
                    cityEntity.setCountryEntity(countryServiceIMpl.findByCode((String) value));
                } else if (key.equals("coord")) {
                    Map mapCoord = (Map) value;
                    mapCoord.forEach((keyCoord, valueCoord) ->
                    {
                        if (keyCoord.equals("lon")) {
                            if (valueCoord instanceof Double)
                            {
                                cityEntity.setLon((double)valueCoord);
                            }

                        } else if (keyCoord.equals("lat")) {
                        if (valueCoord instanceof  Double)
                        {
                            cityEntity.setLat((double)valueCoord);
                        }
                        }
                    });
                }

            }


        });

        return cityEntity;
    }


}
