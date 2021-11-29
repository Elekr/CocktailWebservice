package com.tsi.tom.crosby.Cocktail_webservice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy= GenerationType.TABLE)
    private int id;

    String Name;
    String Type;
    Double ABV;
    String Description;
    String Storage_Name;

    public Ingredient() {
    }

    public Ingredient(String name, String type, Double ABV, String description, String storage_Name) {
        Name = name;
        Type = type;
        this.ABV = ABV;
        Description = description;
        Storage_Name = storage_Name;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public Double getABV() {
        return ABV;
    }

    public void setABV(Double ABV) {
        this.ABV = ABV;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getStorage_Name() {
        return Storage_Name;
    }

    public void setStorage_Name(String storage_Name) {
        Storage_Name = storage_Name;
    }

}
