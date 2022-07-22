package com.solbeg.testtask.citiesshower.service;

import com.solbeg.testtask.citiesshower.exception.CitiesException;
import com.solbeg.testtask.citiesshower.model.BusinessEntity;
import com.solbeg.testtask.citiesshower.model.City;
import com.solbeg.testtask.citiesshower.model.Message;
import com.solbeg.testtask.citiesshower.repository.CitiesRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ShowPageOfCitiesService {

    private CitiesRepository citiesRepository;
    private ErrorHandler errorHandler;

    public ShowPageOfCitiesService(CitiesRepository citiesRepository, ErrorHandler errorHandler) {
        this.citiesRepository = citiesRepository;
        this.errorHandler = errorHandler;
    }

    @Transactional
    public Message getCities(Message message) {
        Message result = new Message();
        try {
            BusinessEntity businessEntity = Optional.ofNullable(message.getBusinessEntity())
                    .orElseThrow(() -> new CitiesException("Incorrect request"));
            Page<City> page = citiesRepository.findAll(PageRequest.of(businessEntity.getCurrentPage(),
                    businessEntity.getPageSize()));
            result = createMessage(new Message(), page.getContent());
            result = errorHandler.createErrorMessage(0, null, result);
        } catch (CitiesException e) {
            result = errorHandler.createErrorMessage(1, e.getErrorMessage(), result);
        }catch (Exception e) {
            result = errorHandler.createErrorMessage(1, "Internal error", result);
        }
        return result;
    }

    private Message createMessage(Message message, List<City> cities) {
        Message responseMessage = new Message();
        BusinessEntity businessEntity = new BusinessEntity();
        businessEntity.getCity().addAll(cities);
        responseMessage.setBusinessEntity(businessEntity);
        return responseMessage;
    }
}
