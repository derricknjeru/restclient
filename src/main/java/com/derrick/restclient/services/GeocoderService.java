package com.derrick.restclient.services;

import com.derrick.restclient.entities.Site;
import com.derrick.restclient.json.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Service
public class GeocoderService {
    //No need to hide this key.(It's a test key)
    private static final String KEY = "AIzaSyDw_d6dfxDEI7MAvqfGXEIsEMwjC1PWRno";

    private static final String BASE = "https://maps.googleapis.com/maps/api/geocode/json";

    private RestTemplate restTemplate;

    @Autowired
    public GeocoderService(RestTemplateBuilder builder) {
        restTemplate = builder.build();
    }

    public Site getLatLng(String... address) {
        String joinedAddress = String.join(",", address);

        String encodedAddress = URLEncoder.encode(joinedAddress, StandardCharsets.UTF_8);

        String url = String.format("%s?address=%s&key=%s", BASE, encodedAddress, KEY);

        Response response = restTemplate.getForObject(url, Response.class);

        assert response != null;
        return new Site(response.getFormattedAddress(),
                response.getLocation().getLat(),
                response.getLocation().getLng());
    }


}
