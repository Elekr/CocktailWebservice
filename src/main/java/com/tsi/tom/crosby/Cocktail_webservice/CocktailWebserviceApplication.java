package com.tsi.tom.crosby.Cocktail_webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@SpringBootApplication
@RestController
@RequestMapping("/cocktails")
public class CocktailWebserviceApplication {

	@Autowired
	private CocktailRepository cocktailRepos;

	public static void main(String[] args) {
		SpringApplication.run(CocktailWebserviceApplication.class, args);
	}

	@GetMapping()
	public String index() {
		return "is a cocktail menu boiii";
	}
	@GetMapping("/all")
	public @ResponseBody Iterable<Cocktail> getAllCocktails() {
		return cocktailRepos.findAll();
	}

    @PostMapping("/addCocktail")
    public @ResponseBody String addACat (@RequestParam String name, @RequestParam int Cocktail_Instructions_number_of_instructions) {

        Cocktail savedCat = new Cocktail(name, Cocktail_Instructions_number_of_instructions);
		cocktailRepos.save(savedCat);
        return "Cocktail saved into list";

    }

	@DeleteMapping("deleteCocktail")
	public @ResponseBody String deleteACocktail(@RequestParam int drink)
	{
		Optional<Cocktail> cocktail = cocktailRepos.findById(drink);
		if(cocktail.isEmpty())
		{
			return"it ain't workin chief";
		}
		else
		{
			cocktailRepos.deleteById(drink);
			return"poggers!";
		}
	}

}