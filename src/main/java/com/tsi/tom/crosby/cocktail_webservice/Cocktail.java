package com.tsi.tom.crosby.cocktail_webservice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cocktail {

    public Cocktail() {
    }

    @Id
    @GeneratedValue(strategy= GenerationType.TABLE)
    private int id;
    String name;
    int Cocktail_Instructions_number_of_instructions;

    public Cocktail(String name, int cocktail_Instructions_number_of_instructions) {
        this.name = name;
        this.Cocktail_Instructions_number_of_instructions = cocktail_Instructions_number_of_instructions;
    }

    public int getCocktail_Instructions() {
        return Cocktail_Instructions_number_of_instructions;
    }

    public void setCocktail_Instructions_number_of_instructions(int cocktailInstruction) {
        Cocktail_Instructions_number_of_instructions = cocktailInstruction;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }
}
