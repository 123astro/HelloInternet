package com.careerdevs.hellointernet.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {

    /*
    Mapping annotations
    Method: Get
    Path: /
    Host:  Localhost:4000
    URL: http://localhost:4000/
     */


    @GetMapping("/")
    private String rootRoute(){
        return "You requested the root route";
    }

    @GetMapping("/random")
    private int randomNum(){
        return (int) (Math.floor(Math.random() * (100 - 1 + 1)) + 1);

    }

}
