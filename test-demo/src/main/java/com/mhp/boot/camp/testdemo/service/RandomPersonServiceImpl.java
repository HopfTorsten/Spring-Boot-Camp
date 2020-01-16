package com.mhp.boot.camp.testdemo.service;

import com.mhp.boot.camp.testdemo.dto.Person;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class RandomPersonServiceImpl implements RandomPersonService {

    @Override
    public Person getRandomPerson() {
        final RestTemplate restTemplate = new RestTemplate();
        final HttpHeaders headers = new HttpHeaders();

        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");

        final HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

        return restTemplate.exchange("https://uinames.com/api/", HttpMethod.GET, entity, Person.class).getBody();

    }
}
