package com.solbeg.testtask.citiesshower.service;

import com.solbeg.testtask.citiesshower.model.BusinessEntity;
import com.solbeg.testtask.citiesshower.model.City;
import com.solbeg.testtask.citiesshower.model.Message;
import com.solbeg.testtask.citiesshower.repository.CitiesRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Slf4j
public class CitiesUpdateService {

    private final CitiesRepository citiesRepository;
    private final ErrorHandler errorHandler;

    public CitiesUpdateService(CitiesRepository citiesRepository, ErrorHandler errorHandler) {
        this.citiesRepository = citiesRepository;
        this.errorHandler = errorHandler;
    }

    @Transactional
    public Message changeCity(Message message) {
        Message result = new Message();
        try {
            City city = Optional.ofNullable(message.getBusinessEntity())
                    .map(BusinessEntity::getEntities)
                    .map(t -> t.get(0)).get();
            log.info("Prepare to call database for message with messageId = {}, Parameters: {}, {}, {}",
                    message.getMessageId(), city.getId(), city.getName(), city.getPhoto());
            citiesRepository.setCity(city.getId(), city.getName(), city.getPhoto());
            log.info("Database called successfully for request with messageId = {}", message.getMessageId());
            result = errorHandler.createErrorMessage(0, null, message);
        } catch (Exception e) {
            result = errorHandler.createErrorMessage(1, "Internal error", result);
        }
        return result;
    }
}