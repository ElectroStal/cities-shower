package com.solbeg.testtask.citiesshower.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/")
    public String homePage() {
        return "home";
    }

    @GetMapping("/mainPage")
    public String mainPage() {
        return "mainPage";
    }
}
