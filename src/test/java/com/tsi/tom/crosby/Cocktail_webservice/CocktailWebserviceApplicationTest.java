package com.tsi.tom.crosby.Cocktail_webservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Iterator;

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
    public void testGetAllCocktails()
    {
        cocktailWebserviceApplication.getAllCocktails();
        verify(cocktailRepository).findAll();
    }
}
