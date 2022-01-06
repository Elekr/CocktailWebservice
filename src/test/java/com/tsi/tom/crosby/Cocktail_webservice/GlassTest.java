package com.tsi.tom.crosby.Cocktail_webservice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GlassTest {
    @Test
    public void testObject()
    {
        Glass glass = new Glass("big", 500, "is a glass");
        Glass glass1 = new Glass();
        assertEquals(glass.getType() == "big", true, "The value should be 'big'");
        assertEquals(glass.getVolume() == 500, true, "The value should be '500'");
        assertEquals(glass.getDescription() == "is a glass", true, "The value should be 'is a glass'");

        glass.setType("ti");
        glass.setVolume(55);
        glass.setDescription("still a glass");

        assertEquals(glass.getType() == "ti", true, "The value should be 'ti'");
        assertTrue(glass.getVolume() == 55, "The value should be '55'");
        assertEquals(glass.getDescription() == "still a glass", true, "still a glass'");

        assertEquals(glass1.getType() == null, true, "The value should be 'null'");
        assertEquals(0, glass1.getVolume(), "The value should be 'null'");
        assertNull(glass1.getDescription(), "The value should be 'null");
    }
}
