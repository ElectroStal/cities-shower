package com.solbeg.testtask.citiesshower.controller;

import com.solbeg.testtask.citiesshower.model.Message;
import com.solbeg.testtask.citiesshower.service.CitiesUpdateService;
import com.solbeg.testtask.citiesshower.service.FindCityByNameService;
import com.solbeg.testtask.citiesshower.service.ShowPageOfCitiesService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CitiesShowerController {

    private ShowPageOfCitiesService showPageOfCitiesService;
    private FindCityByNameService findCityByNameService;
    private CitiesUpdateService citiesUpdateService;

    public CitiesShowerController(ShowPageOfCitiesService showPageOfCitiesService, FindCityByNameService findCityByNameService, CitiesUpdateService citiesUpdateService) {
        this.showPageOfCitiesService = showPageOfCitiesService;
        this.findCityByNameService = findCityByNameService;
        this.citiesUpdateService = citiesUpdateService;
    }

    @PostMapping("/pageRequest")
    public Message pageRequest(@RequestBody Message request) {
        return showPageOfCitiesService.getCities(request);
    }

    @PostMapping("/cityFind")
    public Message cityFind(@RequestBody Message request) {
        return findCityByNameService.findCityByName(request);
    }

    @PostMapping("/cityUpdate")
    public Message cityUpdate(@RequestBody Message request) {
        return citiesUpdateService.changeCity(request);
    }
}
