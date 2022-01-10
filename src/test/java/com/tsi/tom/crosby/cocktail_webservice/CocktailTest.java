package com.tsi.tom.crosby.cocktail_webservice;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CocktailTest {

    @Test
    public void testObject()
    {
        Cocktail cocktail = new Cocktail("TestDrink", 2 );
        Cocktail cocktail2 = new Cocktail();
        assertEquals(true,cocktail.getName() == "TestDrink", "The value should be 'TestDrink'");
        assertEquals(true,cocktail.getCocktail_Instructions() == 2, "The value should be '2'");

        cocktail.setName("TestDrink2");
        cocktail.setCocktail_Instructions_number_of_instructions(242);
        assertEquals(true, cocktail.getId() == 0,  "The value should be '0'");
        assertEquals(true, cocktail.getName() == "TestDrink2",  "The value should be 'TestDrink2'");
        assertEquals(true,cocktail.getCocktail_Instructions() == 242,  "The value should be '242'");

        assertEquals(true,cocktail2.getName() == null,  "The value should be 'TestDrink2'");
        assertEquals(true,cocktail2.getCocktail_Instructions() == 0,  "The value should be '242'");
    }

}
