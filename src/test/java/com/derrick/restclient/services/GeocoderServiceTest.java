package com.derrick.restclient.services;

import com.derrick.restclient.entities.Site;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class GeocoderServiceTest {
    @Autowired
    GeocoderService service;

    private Logger logger = LoggerFactory.getLogger(GeocoderServiceTest.class);

    @Test
    void getLatLngForGoogleHeadQuarters() {

        Site site = service.getLatLng("1600 Amphitheatre Parkway", "Mountain View", "CA");

        logger.info(String.valueOf(site));

        Assert.assertEquals(37.42, site.getLatitude(), 0.01);
        Assert.assertEquals(-122.08, site.getLongitude(), 0.01);
    }

    @Test
    void getLatLngForWithoutStreet() {

        Site site = service.getLatLng("Boston", "MA");

        logger.info(String.valueOf(site));

        Assert.assertEquals(42.36, site.getLatitude(), 0.01);
        Assert.assertEquals(-71.05, site.getLongitude(), 0.01);
    }

    @Test
    void getLatLngForCellulantAddress() {

        Site site = service.getLatLng("State House Crescent Road Vienna Court", "Nairobi", "Kenya");

        logger.info(String.valueOf(site));

        Assert.assertEquals(-1.28, site.getLatitude(), 0.01);
        Assert.assertEquals(36.80, site.getLongitude(), 0.01);
    }

    @Test
    void getLatLngForMicrosoftAddress() {

        Site site = service.getLatLng("The Oval", "Ring Rd Parklands", "Nairobi", "Kenya");

        logger.info(String.valueOf(site));

        Assert.assertEquals(-1.25, site.getLatitude(), 0.01);
        Assert.assertEquals(36.80, site.getLongitude(), 0.01);
    }
}