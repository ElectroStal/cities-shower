package com.solbeg.testtask.citiesshower.model;

import java.util.ArrayList;
import java.util.List;

public class BusinessEntity {
    private int currentPage;
    private int pageSize;
    private int amountOfEntities;
    private List<City> entities = new ArrayList<>();

    public BusinessEntity(int currentPage, int pageSize, int amountOfEntities, List<City> entities) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.amountOfEntities = amountOfEntities;
        this.entities = entities;
    }

    public BusinessEntity() {
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getAmountOfEntities() {
        return amountOfEntities;
    }

    public void setAmountOfEntities(int amountOfEntities) {
        this.amountOfEntities = amountOfEntities;
    }

    public List<City> getCity() {
        return entities;
    }

    public void setEntities(List<City> entities) {
        this.entities.addAll(entities);
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
