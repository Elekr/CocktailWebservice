package com.tsi.tom.crosby.Cocktail_webservice;

import com.tsi.tom.crosby.Cocktail_webservice.Cocktail;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CocktailTest {

    @Test
    public void testObject()
    {
        Cocktail cocktail = new Cocktail("TestDrink", 2 );
        assertEquals(cocktail.getName() == "TestDrink", true, "The value should be 'TestDrink'");
        assertEquals(cocktail.getCocktail_Instructions_number_of_instructions() == 2, true, "The value should be '2'");
        cocktail.setName("TestDrink2");
        cocktail.setCocktail_Instructions_number_of_instructions(242);
        assertEquals(cocktail.getName() == "TestDrink2", true, "The value should be 'TestDrink2'");
        assertEquals(cocktail.getCocktail_Instructions_number_of_instructions() == 242, true, "The value should be '242'");
    }

}
