package com.careerdevs.hellointernet.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/nasa") // endpoint
public class NasaController {

    private String myNasaKey = "aBpzdFMKtVnmgmtc3GlQYfkocCVNsCxZeBfywHM2";
    //private String picDate = "2022-03-1";
    private String nasaApodEndpoint =
            "https://api.nasa.gov/planetary/apod?api_key=" + myNasaKey;

    @GetMapping("/apod")
    public Object apodHandler(RestTemplate restTemplate){
        return restTemplate.getForObject(nasaApodEndpoint, Object.class);
    }

    @GetMapping("/apod/{picDate}")
    public Object apodHand(RestTemplate restTemplate, @PathVariable("picDate") String picDate ) {
        return restTemplate.getForObject( "https://api.nasa.gov/planetary/apod?date="+ picDate +"&api_key=" + myNasaKey, Object.class);
    }
}
