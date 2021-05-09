package md.weatherAdventure.service.impl;

import md.weatherAdventure.service.SendToGateService;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("rest")
public class SendToGateSericeImpl implements SendToGateService {
    @Override
    @Cacheable( value = "sendString",key = "#url")
    public String sendGetRequest(String url) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForEntity(url, String.class).getBody();
    }
}
