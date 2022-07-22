package com.solbeg.testtask.citiesshower.service;

import com.solbeg.testtask.citiesshower.model.BusinessEntity;
import com.solbeg.testtask.citiesshower.model.City;
import com.solbeg.testtask.citiesshower.model.Message;
import com.solbeg.testtask.citiesshower.repository.CitiesRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CitiesUpdateService {

    private CitiesRepository citiesRepository;
    private ErrorHandler errorHandler;

    public CitiesUpdateService(CitiesRepository citiesRepository, ErrorHandler errorHandler) {
        this.citiesRepository = citiesRepository;
        this.errorHandler = errorHandler;
    }

    @Transactional
    public Message changeCity(Message message) {
        Message result = new Message();
        try {
            City city = Optional.ofNullable(message.getBusinessEntity())
                    .map(BusinessEntity::getCity)
                    .map(t -> t.get(0)).get();
            citiesRepository.setCity(city.getId(), city.getName(), city.getPhoto());
            result = errorHandler.createErrorMessage(0, null, message);
        } catch (Exception e) {
            result = errorHandler.createErrorMessage(1, "Internal error", result);
        }
        return result;
    }
}