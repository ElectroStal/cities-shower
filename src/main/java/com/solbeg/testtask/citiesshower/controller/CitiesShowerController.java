package com.solbeg.testtask.citiesshower.controller;

import com.solbeg.testtask.citiesshower.model.Message;
import com.solbeg.testtask.citiesshower.service.FindCityByNameService;
import com.solbeg.testtask.citiesshower.service.ShowPageOfCitiesService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CitiesShowerController {

    private ShowPageOfCitiesService showPageOfCitiesService;
    private FindCityByNameService findCityByNameService;

    public CitiesShowerController(ShowPageOfCitiesService showPageOfCitiesService, FindCityByNameService findCityByNameService) {
        this.showPageOfCitiesService = showPageOfCitiesService;
        this.findCityByNameService = findCityByNameService;
    }

    @PostMapping("/pageRequest")
    public Message pageRequest(@RequestBody Message request) {
        return showPageOfCitiesService.getCities(request);
    }

    @PostMapping("/cityFind")
    public Message cityFind(@RequestBody Message request) {
        return findCityByNameService.findCityByName(request);
    }
}
