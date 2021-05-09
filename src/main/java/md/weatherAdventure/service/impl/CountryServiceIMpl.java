package md.weatherAdventure.service.impl;

import com.google.gson.Gson;
import md.weatherAdventure.dto.CountryDto;
import md.weatherAdventure.entity.CountryEntity;
import md.weatherAdventure.repository.CountryRepository;
import md.weatherAdventure.service.FileService;
import md.weatherAdventure.service.ModelMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service("jsonCountry")
public class CountryServiceIMpl {
    @Value("${file.path.country.list}")
    private String pathFile;

    FileService fileService;
    CountryRepository countryRepository;
    ModelMapperService<CountryDto, CountryEntity> modelMapperService;

    @Autowired
    public void setCountryRepository(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Autowired
    @Qualifier("countryMapper")
    public void setModelMapperService(ModelMapperService<CountryDto, CountryEntity> modelMapperService) {
        this.modelMapperService = modelMapperService;
    }

    @Autowired
    public void setFileService(FileService fileService) {
        this.fileService = fileService;
    }

    public CountryEntity findByCode(String code) {
        return countryRepository.findByCode(code);
    }
    public CountryEntity findById(Long id) {
        return countryRepository.getOne(id);
    }
    @Cacheable("countries")
    public Set<CountryDto> getAlllCountries() {
        return countryRepository.findAll().stream().map(CountryDto::new).collect(Collectors.toSet());
    }

    public void syncCountries() {
        Gson gson = new Gson();
        String strAnswer = fileService.readFile(pathFile);
        List listMaps = gson.fromJson(strAnswer, ArrayList.class);
        for (Object item : listMaps) {
            CountryEntity entityFromGate = modelMapperService.FromMapToEntity((Map) item);
            CountryEntity entityFromCurrntDb = countryRepository.findByCode(entityFromGate.getCode());
            if (entityFromCurrntDb == null) {
                entityFromCurrntDb = entityFromGate;
            } else {
                entityFromCurrntDb.setName_en(entityFromGate.getName_en());
                entityFromCurrntDb.setCode(entityFromGate.getCode());
            }
            countryRepository.saveAndFlush(entityFromCurrntDb);

        }

    }

}
