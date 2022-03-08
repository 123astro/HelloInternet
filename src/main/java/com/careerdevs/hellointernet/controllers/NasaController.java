package com.careerdevs.hellointernet.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/nasa") // endpoint
public class NasaController {

    @Autowired
    private Environment env;

    private String nasaApodEndpoint = "https://api.nasa.gov/planetary/apod?api_key=";

    @GetMapping("/apod")
    public Object apodHandler(RestTemplate restTemplate) {
        String apikey = env.getProperty("NASA_API_KEY");
        return restTemplate.getForObject(nasaApodEndpoint + apikey, Object.class);
    }

    @GetMapping("/apod/{picDate}")
    public Object apodHand(RestTemplate restTemplate, @PathVariable("picDate") String picDate) {
        String apikey = env.getProperty("NASA_API_KEY");
        return restTemplate.getForObject("https://api.nasa.gov/planetary/apod?date=" + picDate + "&api_key=" + apikey,
                Object.class);
    }
}
