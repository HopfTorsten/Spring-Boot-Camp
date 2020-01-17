package com.mhp.boot.camp.testdemo.service;

import com.mhp.boot.camp.testdemo.dto.Person;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class RandomPersonServiceImpl implements RandomPersonService {

    @Override
    public List<Person> getRandomPersons(int amount) {
        final RestTemplate restTemplate = new RestTemplate();
        final HttpHeaders headers = new HttpHeaders();

        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");

        final HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

        if(amount == 1) {
            Person person = restTemplate.exchange("https://uinames.com/api/",
                                         HttpMethod.GET,
                                         entity,
                                         Person.class).getBody();

            return Collections.singletonList(person);
        } else {
            return restTemplate.exchange("https://uinames.com/api/?amount=" + amount,
                                         HttpMethod.GET,
                                         entity,
                                         new ParameterizedTypeReference<List<Person>>() {}).getBody();
        }
    }
}
