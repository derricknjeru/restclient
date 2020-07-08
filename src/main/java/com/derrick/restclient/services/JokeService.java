package com.derrick.restclient.services;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class JokeService {
    private RestTemplate restTemplate;

    private JokeService(RestTemplateBuilder builder) {
        restTemplate = builder.build();
    }

}
