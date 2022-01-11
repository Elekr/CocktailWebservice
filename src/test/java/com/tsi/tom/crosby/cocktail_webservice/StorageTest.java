package com.tsi.tom.crosby.cocktail_webservice;

import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StorageTest {
    @Test
    public void testObject()
    {
        Storage storage = new Storage("house", "big", 50);
        assertSame("house", storage.getName(), "The value should be 'house'");
        assertSame("big", storage.getType(), "The value should be 'big'");
        assertEquals(50, storage.getSize(), "The value should be '50'");

        storage.setName("restaurant");
        storage.setType("bigger");
        storage.setSize(503);

        assertSame("restaurant", storage.getName(), "The value should be 'restaurant'");
        assertSame("bigger", storage.getType(), "The value should be 'bigger'");
        assertEquals(503, storage.getSize(), "The value should be '503'");
    }
}
