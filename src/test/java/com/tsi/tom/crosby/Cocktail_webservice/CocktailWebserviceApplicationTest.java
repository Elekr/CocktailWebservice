package com.tsi.tom.crosby.Cocktail_webservice;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CocktailWebserviceApplicationTest {


    private CocktailWebserviceApplication cocktailWebserviceApplication;
    @Mock
    CocktailRepository cocktailRepository;
    @Mock
    IngredientRepository ingredientRepository;
    @Mock
    GlassRepository glassRepository;
    @Mock
    EquipmentRepository equipmentRepository;


    @BeforeEach
    void setUp()
    {
        cocktailWebserviceApplication = new CocktailWebserviceApplication(cocktailRepository, ingredientRepository,glassRepository, equipmentRepository);
    }

    @Test
    public void testGetAll()
    {
        cocktailWebserviceApplication.getAllCocktails();
        verify(cocktailRepository).findAll();
        cocktailWebserviceApplication.getAllIngredients();
        verify(ingredientRepository).findAll();
        cocktailWebserviceApplication.getAllGlasses();
        verify(glassRepository).findAll();
        cocktailWebserviceApplication.getAllEquipment();
        verify(equipmentRepository).findAll();
    }

    @Test
    public void testAddCocktails()
    {
        String dd = cocktailWebserviceApplication.addCocktail("mojito", 2);
        ArgumentCaptor<Cocktail> d = ArgumentCaptor.forClass(Cocktail.class);
        verify(cocktailRepository).save(d.capture());
        assertEquals("Cocktail saved into list", dd, "The value should be 'Cocktail saved into list'");
    }

    @Test
    public void testAddIngredients()
    {
        String dd = cocktailWebserviceApplication.addIngredient("Milk", "2%", 2.2, "milky", "fridge");
        ArgumentCaptor<Ingredient> d = ArgumentCaptor.forClass(Ingredient.class);
        verify(ingredientRepository).save(d.capture());
        assertEquals("Ingredient saved into list", dd, "The value should be 'Ingredient saved into list'");
    }

    @Test
    public void testAddGlass()
    {
        String dd = cocktailWebserviceApplication.addGlass("Glassy", 500, "for milk");
        ArgumentCaptor<Glass> d = ArgumentCaptor.forClass(Glass.class);
        verify(glassRepository).save(d.capture());
        assertEquals("Glass saved into list", dd, "The value should be 'Glass saved into list'");
    }

    @Test
    public void testAddEquipment()
    {
        String dd = cocktailWebserviceApplication.addEquipment("Spoon", "spoony", "stir");
        ArgumentCaptor<Equipment> d = ArgumentCaptor.forClass(Equipment.class);
        verify(equipmentRepository).save(d.capture());
        assertEquals("Equipment saved into list", dd, "The value should be 'Equipment saved into list'");
    }

    @Test
    public void testDeleteCocktails()
    {
        cocktailWebserviceApplication.addCocktail("mojito", 2);
        String dd = cocktailWebserviceApplication.deleteACocktail(1);
        ArgumentCaptor<Cocktail> d = ArgumentCaptor.forClass(Cocktail.class);
    }
}
