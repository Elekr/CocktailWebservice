package com.tsi.tom.crosby.cocktail_webservice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Glass {

    public Glass() {
    }

    public Glass(String type, int volume, String description) {
        this.type = type;
        this.volume = volume;
        Description = description;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.TABLE)
    private int id;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getId() {
        return id;
    }

    String type;
    int volume;
    String Description;
}
