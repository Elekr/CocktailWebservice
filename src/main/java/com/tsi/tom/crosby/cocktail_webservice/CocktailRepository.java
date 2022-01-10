package com.tsi.tom.crosby.cocktail_webservice;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CocktailRepository extends CrudRepository<Cocktail, Integer> {

    //Selects from the database
    @Query(value = "SELECT * FROM cocktail.cocktail WHERE Name = 'Mojito'", nativeQuery = true)
    //Stores data relating to the query
    List<Cocktail> findAllProjectedBy();

    @Query(value = "SHOW DATABASES LIKE 'cocktail'", nativeQuery = true)
        //Stores data relating to the query
    List<Cocktail> doesDBExist();
}