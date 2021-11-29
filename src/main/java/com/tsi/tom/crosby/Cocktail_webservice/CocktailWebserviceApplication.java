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
	@Autowired
	private IngredientRepository ingredientRepos;


	public static void main(String[] args) {
		SpringApplication.run(CocktailWebserviceApplication.class, args);
	}

	//GET
	@GetMapping("/all/cocktails/Mojito")
	public @ResponseBody
	Iterable<Cocktail> getSpecificCocktails() {
		return cocktailRepos.findAllProjectedBy();
	}

	@GetMapping("/all/cocktails")
	public @ResponseBody
	Iterable<Cocktail> getAllCocktails() {
		return cocktailRepos.findAll();
	}

	@GetMapping("/all/ingredients")
	public @ResponseBody
	Iterable<Ingredient> getAllInstructions() {
		return ingredientRepos.findAll();
	}

	//POST
	@PostMapping("/add/cocktail")
	public @ResponseBody
	String addCocktail(@RequestParam String name, @RequestParam int Cocktail_Instructions_number_of_instructions) {

		Cocktail savedDrink = new Cocktail(name, Cocktail_Instructions_number_of_instructions);
		cocktailRepos.save(savedDrink);
		return "Cocktail saved into list";
	}

	@PostMapping("/add/ingredient")
	public @ResponseBody
	String addItem(@RequestParam String Name, @RequestParam String Type, Double ABV,
				   String Description, String Storage_Name) {

		Ingredient item = new Ingredient(Name, Type, ABV, Description, Storage_Name);
		ingredientRepos.save(item);
		return "Ingredient saved into list";
	}

	//DELETE
	@DeleteMapping("/delete/cocktail")
	public @ResponseBody
	String deleteACocktail(@RequestParam int drink) {
		Optional<Cocktail> cocktail = cocktailRepos.findById(drink);
		if (cocktail.isEmpty()) {
			return "it ain't workin chief";
		} else {
			cocktailRepos.deleteById(drink);
			return "poggers!";
		}
	}

	@DeleteMapping("/delete/ingredient")
	public @ResponseBody
	String deleteInstruction(@RequestParam int instr) {
		Optional<Ingredient> ingredient = ingredientRepos.findById(instr);
		if (ingredient.isEmpty()) {
			return "it ain't workin chief but ingredient";
		} else {
			ingredientRepos.deleteById(instr);
			return "poggers! but ingredient";
		}
	}
}
