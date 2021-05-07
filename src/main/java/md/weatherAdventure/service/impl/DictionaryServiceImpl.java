package md.weatherAdventure.service.impl;

;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DictionaryServiceImpl {

//    @CacheEvict(value="dictionary", key="#dicti")
    List<Object> getByModule(String module) {
        return null;
    }

}
