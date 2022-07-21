package com.solbeg.testtask.citiesshower.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class City {
    @Id
    private int id;
    private String name;
    private String photoReference;

    public City(int id, String name, String photoReference) {
        this.id = id;
        this.name = name;
        this.photoReference = photoReference;
    }

    public City() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhotoReference() {
        return photoReference;
    }

    public void setPhotoReference(String photoReference) {
        this.photoReference = photoReference;
    }
}
