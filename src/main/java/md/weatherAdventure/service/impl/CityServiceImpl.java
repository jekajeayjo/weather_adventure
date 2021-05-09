package md.weatherAdventure.service.impl;

import com.google.gson.Gson;
import md.weatherAdventure.dto.CityDto;
import md.weatherAdventure.entity.CityEntity;
import md.weatherAdventure.entity.CountryEntity;
import md.weatherAdventure.repository.CityRepository;
import md.weatherAdventure.service.FileService;
import md.weatherAdventure.service.ModelMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CityServiceImpl {
    @Value("${file.path.city.list}")
    private String pathFile;


    FileService fileService;
    CityRepository cityRepository;
    ModelMapperService modelMapperService;

    @Autowired
    public void setFileService(FileService fileService) {
        this.fileService = fileService;
    }

    @Autowired
    public void setCityRepository(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Autowired
    @Qualifier("cityMapper")
    public void setModelMapperService(ModelMapperService modelMapperService) {
        this.modelMapperService = modelMapperService;
    }

    @Cacheable(value = "cities",key = "#counrtyId")
    public Set<CityDto> findByCountryId(CountryEntity counrtyId) {
        return cityRepository.findByCountryEntity(counrtyId).stream().map(CityDto::new).collect(Collectors.toSet());
    }

    CityEntity findByCityId(Long cityId) {
        return cityRepository.findByCityId(cityId);
    }
CityEntity findById(Long id )
{

    return  cityRepository.findById(id).get();
}
    public void syncCities() {
        Gson gson = new Gson();
        String strAnswer = fileService.readFile(pathFile);
        List listcities = gson.fromJson(strAnswer, ArrayList.class);
        for (Object item : listcities) {
            CityEntity cityEnttFrmGt = (CityEntity) modelMapperService.FromMapToEntity((Map) item);
            CityEntity currentCityEntt = cityRepository.findByCityId(cityEnttFrmGt.getCityId());
            if (currentCityEntt != null) {
                currentCityEntt.setName_en(cityEnttFrmGt.getName_en());
                currentCityEntt.setCountryEntity(cityEnttFrmGt.getCountryEntity());
            } else {
                currentCityEntt = cityEnttFrmGt;
            }
            cityRepository.saveAndFlush(currentCityEntt);
        }

    }

}
