package com.tsi.tom.crosby.Cocktail_webservice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IngredientTest {
    @Test
    public void testObject()
    {
        Ingredient ingredient = new Ingredient("TestIngredient",  "Vegetable",  6.8,  "it's a test",  "frig");
        Ingredient ingredient1 = new Ingredient();
        assertEquals(ingredient.getName() == "TestIngredient", true, "The value should be 'TestIngredient'");
        assertEquals(ingredient.getType() == "Vegetable", true, "The value should be 'Vegetable'");
        assertEquals(ingredient.getABV() == 6.8, true, "The value should be '6.8'");
        assertEquals(ingredient.getDescription() == "it's a test", true, "The value should be 'it's a test'");
        assertEquals(ingredient.getStorage_Name() == "frig", true, "The value should be 'frig'");

        ingredient.setName("TestDrink2");
        ingredient.setType("fruit");
        ingredient.setABV(2.0);
        ingredient.setDescription("still a test");
        ingredient.setStorage_Name("cold place");

        assertEquals(ingredient.getName() == "TestDrink2", true, "The value should be 'TestDrink2'");
        assertEquals(ingredient.getType() == "fruit", true, "The value should be 'fruit'");
        assertEquals(ingredient.getABV() == 2.0, true, "The value should be '2.0'");
        assertEquals(ingredient.getDescription() == "still a test", true, "The value should be 'still a test'");
        assertEquals(ingredient.getStorage_Name() == "cold place", true, "The value should be 'cold place'");

        assertEquals(ingredient1.getName() == null, true, "The value should be 'TestIngredient'");
        assertEquals(ingredient1.getType() == null, true, "The value should be 'Vegetable'");
        assertEquals(ingredient1.getABV() == null, true, "The value should be '6.8'");
        assertEquals(ingredient1.getDescription() == null, true, "The value should be 'it's a test'");
        assertEquals(ingredient1.getStorage_Name() == null, true, "The value should be 'frig'");

    }
}
