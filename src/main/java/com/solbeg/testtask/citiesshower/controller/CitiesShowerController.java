package com.solbeg.testtask.citiesshower.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.solbeg.testtask.citiesshower.model.BusinessEntity;
import com.solbeg.testtask.citiesshower.model.Message;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CitiesShowerController {

    @PostMapping("/pageRequest")
    public Message pageRequest(@RequestBody Message request) {
        return request;
    }

    @PostMapping("/cityFind")
    public Message cityFind(@RequestBody Message request) {
        return request;
    }
}
