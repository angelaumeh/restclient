package com.oreilly.restclient.services;

import com.oreilly.restclient.entities.Site;
import com.oreilly.restclient.json.Response;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class GeocoderService {
    private Logger logger = LoggerFactory.getLogger(GeocoderService.class);
    private static final String BASE = "https://maps.googleapis.com/maps/api/geocode/json";

    private RestTemplate restTemplate;


    public GeocoderService(RestTemplateBuilder builder) {
        restTemplate = builder.build();
    }

    private String encodeString(String s) {
        try {
            return URLEncoder.encode(s,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return s;
    }

    public Site getLatLng(String... address) {
        String encodedAddress = Stream.of(address)
                .map(this::encodeString)
                .collect(Collectors.joining(","));
        String url = String.format("%s?address=%s", BASE, encodedAddress);
        Response response = restTemplate.getForObject(url, Response.class);
        Site site = new Site(response.getFormattedAddress(),
                response.getLocation().getLat(),
                response.getLocation().getLng());
        logger.info(site.toString());
        return site;
    }
}
