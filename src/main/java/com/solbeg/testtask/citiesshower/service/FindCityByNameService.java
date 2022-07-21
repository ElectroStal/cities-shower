package com.solbeg.testtask.citiesshower.service;

import com.solbeg.testtask.citiesshower.model.BusinessEntity;
import com.solbeg.testtask.citiesshower.model.City;
import com.solbeg.testtask.citiesshower.model.Message;
import com.solbeg.testtask.citiesshower.repository.CitiesRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class FindCityByNameService {

    private CitiesRepository citiesRepository;
    private ErrorHandler errorHandler;

    public FindCityByNameService(CitiesRepository citiesRepository, ErrorHandler errorHandler) {
        this.citiesRepository = citiesRepository;
        this.errorHandler = errorHandler;
    }

    @Transactional
    public Message findCityByName(Message message) {
        Message result = new Message();
        try {
            String cityName = Optional.ofNullable(message.getBusinessEntity())
                    .map(BusinessEntity::getCity)
                    .map(t -> t.get(0))
                    .map(City::getName).get();
            City city = citiesRepository.findByName(cityName);
            result = createMessage(new Message(), city);
            result = errorHandler.createErrorMessage(0, null, result);
        } catch (Exception e) {
            result = errorHandler.createErrorMessage(1, "Internal error", result);
        }
        return result;
    }

    private Message createMessage(Message message, City city) {
        Message responseMessage = new Message();
        BusinessEntity businessEntity = new BusinessEntity();
        businessEntity.getCity().add(city);
        responseMessage.setBusinessEntity(businessEntity);
        return responseMessage;
    }
}
