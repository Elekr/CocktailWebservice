package com.tsi.tom.crosby.Cocktail_webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
@RestController
@RequestMapping("/cocktails")
public class CocktailWebserviceApplication {

	//Generates a list of containers to be used for the ingredients (pre-selected)
	List<Storage> containers = new ArrayList();

	@Autowired
	private CocktailRepository cocktailRepos;
	@Autowired
	private IngredientRepository ingredientRepos;
	@Autowired
	private GlassRepository glassRepos;

	public static void main(String[] args) {
		SpringApplication.run(CocktailWebserviceApplication.class, args);
	}

	//GET
	@GetMapping("/all")
	public @ResponseBody
	Iterable<Cocktail> getSpecificCocktails() {return cocktailRepos.findAll();}

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

	@GetMapping("/all/glasses")
	public @ResponseBody
	Iterable<Glass> getAllGlasses() {
		return glassRepos.findAll();
	}

	//POST
	@PostMapping("/add/cocktail")
	public @ResponseBody
	String addCocktail(@RequestParam String name, int Cocktail_Instructions_number_of_instructions) {

		Cocktail savedDrink = new Cocktail(name, Cocktail_Instructions_number_of_instructions);
		cocktailRepos.save(savedDrink);
		return "Cocktail saved into list";
	}

	@PostMapping("/add/ingredient")
	public @ResponseBody
	String addItem(@RequestParam String Name, String Type, Double ABV,
				   String Description, String Storage_Name) {

		Ingredient item = new Ingredient(Name, Type, ABV, Description, Storage_Name);
		ingredientRepos.save(item);
		return "Ingredient saved into list";
	}

	@PostMapping("/add/glass")
	public @ResponseBody
	String addItem(@RequestParam String type, int volume, String description) {

		Glass item = new Glass(type, volume, description);
		glassRepos.save(item);
		return "Glass saved into list";
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

	@DeleteMapping("/delete/glass")
	public @ResponseBody
	String deleteGlass(@RequestParam int glassNo) {
		Optional<Glass> glass = glassRepos.findById(glassNo);
		if (glass.isEmpty()) {
			return "it ain't workin chief but glass";
		} else {
			ingredientRepos.deleteById(glassNo);
			return "poggers! but glass";
		}
	}
}
