package com.tsi.tom.crosby.Cocktail_webservice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EquipmentTest {
    @Test
    public void testObject()
    {
        Equipment equipment = new Equipment("Fork", "Pointy", "poke poke");

        Equipment equipment1 = new Equipment();
        assertSame("Fork", equipment.getName(), "The value should be 'Fork'");
        assertSame("Pointy", equipment.getType(), "The value should be 'Pointy'");
        assertSame("poke poke", equipment.getMethod(), "The value should be 'poke poke'");

        equipment.setName("spoon");
        equipment.setType("soup");
        equipment.setMethod("spooooon");

        assertSame("spoon", equipment.getName(), "The value should be 'spoon'");
        assertSame("soup", equipment.getType(), "The value should be 'soup'");
        assertSame("spooooon", equipment.getMethod(), "The value should be 'spooooon'");

        assertNull(equipment1.getName(), "The value should be 'null'");
        assertNull(equipment1.getType(), "The value should be 'null'");
        assertNull(equipment1.getMethod(), "The value should be 'null'");
    }
}