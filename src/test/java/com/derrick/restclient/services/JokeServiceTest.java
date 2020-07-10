package com.derrick.restclient.services;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class JokeServiceTest {
    @Autowired
    private JokeService service;

    private Logger logger = LoggerFactory.getLogger(JokeServiceTest.class);

    @Test
    void getJoke() {
        String joke = service.getJoke("Chuck", "Norris");
        logger.info(joke);
        Assert.assertTrue(joke.contains("Chuck") || joke.contains("Norris"));
    }
}