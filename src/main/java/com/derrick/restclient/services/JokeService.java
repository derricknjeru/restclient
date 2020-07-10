package com.derrick.restclient.services;

import com.derrick.restclient.json.JokeResponse;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URLEncoder;

@Service
public class JokeService {
    private static final String BASE_URL = "http://api.icndb.com/jokes/random?limitTo=[nerdy]";

    private RestTemplate restTemplate;

    private JokeService(RestTemplateBuilder builder) {
        restTemplate = builder.build();
    }

    public String getJoke(String firstName, String lastName) {
        String url = String.format("%s&firstName=%s&lastName=%s", BASE_URL, firstName, lastName);

        JokeResponse response = restTemplate.getForObject(url, JokeResponse.class);
        String joke = "";
        if (response != null) {
            joke = response.getValue().getJoke();
        }
        return joke;
    }

}
