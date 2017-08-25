package com.oreilly.restclient.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JokeServiceTest {

    @Autowired
    private JokeService service;

    private Logger logger = LoggerFactory.getLogger(JokeServiceTest.class);

    @Test
    public void getJoke() throws Exception {
        String joke = service.getJoke("Chuck", "Norris");
        logger.info(joke);
        assertTrue(joke.contains("Chuck") || joke.contains("Norris"));
    }

}