package com.tsi.tom.crosby.cocktail_webservice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GlassTest {
    @Test
    public void testObject()
    {
        Glass glass = new Glass("big", 500, "is a glass");
        Glass glass1 = new Glass();
        assertEquals(true,glass.getType() == "big", "The value should be 'big'");
        assertEquals(true,glass.getVolume() == 500, "The value should be '500'");
        assertEquals(true,glass.getDescription() == "is a glass", "The value should be 'is a glass'");

        glass.setType("ti");
        glass.setVolume(55);
        glass.setDescription("still a glass");

        assertEquals(true,glass.getType() == "ti", "The value should be 'ti'");
        assertEquals(55, glass.getVolume(), "The value should be '55'");
        assertEquals(true,glass.getDescription() == "still a glass", "still a glass'");

        assertEquals(true,glass1.getType() == null, "The value should be 'null'");
        assertEquals(0, glass1.getVolume(),"The value should be 'null'");
        assertNull(glass1.getDescription(), "The value should be 'null");
    }
}
