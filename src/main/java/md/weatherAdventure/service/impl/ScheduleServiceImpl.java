package md.weatherAdventure.service.impl;

import md.weatherAdventure.service.FileService;
import md.weatherAdventure.service.ModelMapperService;
import md.weatherAdventure.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Caching;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

@Service("scheduleTest")
@EnableScheduling
public class ScheduleServiceImpl implements ScheduleService {

    FileService fileService;

    TaskScheduler taskScheduler;
    CountryServiceIMpl countryServiceIMpl;
    CityServiceImpl cityService;

    private CacheManager cacheManager;

    @Autowired
    public void setCacheManager(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    @Autowired
    public void setCountryServiceIMpl(CountryServiceIMpl countryServiceIMpl) {
        this.countryServiceIMpl = countryServiceIMpl;
    }

    @Autowired(required = false)
    public void setTaskScheduler(TaskScheduler taskScheduler) {
        this.taskScheduler = taskScheduler;
    }

    @Autowired
    public void setFileService(FileService fileService) {
        this.fileService = fileService;
    }

    @Autowired
    public void setCityService(CityServiceImpl cityService) {
        this.cityService = cityService;
    }

    @Override
    @Scheduled(fixedRate = 600000)
    public void scheduleReadFromFiles() {

        ThreadPoolExecutor executor =
                (ThreadPoolExecutor) Executors.newCachedThreadPool();


        executor.submit(() -> {
            System.out.println("start");
            countryServiceIMpl.syncCountries();
            cityService.syncCities();
        });
    }

    @Override
    @Scheduled(fixedRate = 600000)
    @Caching(
            evict = {
                    @CacheEvict(value = "weathers", allEntries = true),
                    @CacheEvict(value = "cities", allEntries = true),
                    @CacheEvict(value = "countries", allEntries = true)
            }
    )
    public void evictCache() {
        System.out.println("Evict Cache");
    }


}
