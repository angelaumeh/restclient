package com.oreilly.restclient.services;

import com.oreilly.restclient.json.Joke;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class JokeService {
    private static final String BASE = "http://api.icndb.com/jokes/random?limitTo=[nerdy]";
    private RestTemplate restTemplate;

    @Autowired
    public JokeService(RestTemplateBuilder builder) {
        restTemplate = builder.build();
    }

    public String getJoke(String first, String last) {
        String url = String.format("%s&firstName=%s&lastName=%s", BASE, first, last);
        Joke joke = restTemplate.getForObject(url, Joke.class);
        return joke.getValue().getJoke();
    }
}
