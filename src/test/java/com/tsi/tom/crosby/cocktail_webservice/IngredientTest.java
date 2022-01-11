package com.tsi.tom.crosby.cocktail_webservice;

import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IngredientTest {
    @Test
    public void testObject()
    {
        Ingredient ingredient = new Ingredient("TestIngredient",  "Vegetable",  6.8,  "it's a test",  "frig");
        Ingredient ingredient1 = new Ingredient();
        assertEquals(true,ingredient.getName() == "TestIngredient", "The value should be 'TestIngredient'");
        assertEquals(true,ingredient.getType() == "Vegetable", "The value should be 'Vegetable'");
        assertEquals(true,ingredient.getABV() == 6.8, "The value should be '6.8'");
        assertEquals(true,ingredient.getDescription() == "it's a test", "The value should be 'it's a test'");
        assertEquals(true,ingredient.getStorage_Name() == "frig", "The value should be 'frig'");

        ingredient.setName("TestDrink2");
        ingredient.setType("fruit");
        ingredient.setABV(2.0);
        ingredient.setDescription("still a test");
        ingredient.setStorage_Name("cold place");

        assertEquals(true,ingredient.getName() == "TestDrink2", "The value should be 'TestDrink2'");
        assertEquals(true,ingredient.getType() == "fruit", "The value should be 'fruit'");
        assertEquals(true,ingredient.getABV() == 2.0, "The value should be '2.0'");
        assertEquals(true,ingredient.getDescription() == "still a test", "The value should be 'still a test'");
        assertEquals(true,ingredient.getStorage_Name() == "cold place", "The value should be 'cold place'");

        assertEquals(true,ingredient1.getName() == null, "The value should be 'TestIngredient'");
        assertEquals(true,ingredient1.getType() == null, "The value should be 'Vegetable'");
        assertEquals(true,ingredient1.getABV() == null, "The value should be '6.8'");
        assertEquals(true,ingredient1.getDescription() == null, "The value should be 'it's a test'");
        assertEquals(true,ingredient1.getStorage_Name() == null, "The value should be 'frig'");

    }
}
