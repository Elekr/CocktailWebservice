package com.tsi.tom.crosby.cocktail_webservice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Equipment {

    public Equipment() {
    }

    @Id
    @GeneratedValue(strategy= GenerationType.TABLE)
    private int id;

    public Equipment(String name, String type, String method) {
        Name = name;
        Type = type;
        Method = method;
    }

    String Name;
    String Type;
    String Method;

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

    public String getMethod() {
        return Method;
    }

    public void setMethod(String method) {
        Method = method;
    }

    public int getId() {
        return id;
    }
}
