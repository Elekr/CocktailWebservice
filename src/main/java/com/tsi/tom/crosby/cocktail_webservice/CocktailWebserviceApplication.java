package com.tsi.tom.crosby.cocktail_webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@SpringBootApplication
@RestController
@CrossOrigin
@RequestMapping("/cocktails")
public class CocktailWebserviceApplication {

	@Autowired
	private CocktailRepository cocktailRepos;
	@Autowired
	private IngredientRepository ingredientRepos;
	@Autowired
	private GlassRepository glassRepos;
	@Autowired
	private EquipmentRepository equipmentRepos;

	public static void main(String[] args) {
		SpringApplication.run(CocktailWebserviceApplication.class, args);
	}

	public CocktailWebserviceApplication(CocktailRepository cocktailRepos, IngredientRepository ingredientRepos, GlassRepository glassRepos, EquipmentRepository equipmentRepos) {
		this.cocktailRepos = cocktailRepos;
		this.ingredientRepos = ingredientRepos;
		this.glassRepos = glassRepos;
		this.equipmentRepos = equipmentRepos;
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
	Iterable<Ingredient> getAllIngredients() {
		return ingredientRepos.findAll();
	}

	@GetMapping("/all/glasses")
	public @ResponseBody
	Iterable<Glass> getAllGlasses() {
		return glassRepos.findAll();
	}

	@GetMapping("/all/equipment")
	public @ResponseBody
	Iterable<Equipment> getAllEquipment() {
		return equipmentRepos.findAll();
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
	String addIngredient(@RequestParam String Name, String Type, Double ABV,
				   String Description, String Storage_Name) {

		Ingredient item = new Ingredient(Name, Type, ABV, Description, Storage_Name);
		ingredientRepos.save(item);
		return "Ingredient saved into list";
	}

	@PostMapping("/add/glass")
	public @ResponseBody
	String addGlass(@RequestParam String type, int volume, String description) {

		Glass item = new Glass(type, volume, description);
		glassRepos.save(item);
		return "Glass saved into list";
	}

	@PostMapping("/add/equipment")
	public @ResponseBody
	String addEquipment(@RequestParam String name, String type, String method) {

		Equipment equip = new Equipment(name, type, method);
		equipmentRepos.save(equip);
		return "Equipment saved into list";
	}

	//DELETE TODO: Remove this
	@DeleteMapping("/delete/cocktail")
	public @ResponseBody
	String deleteACocktail(@RequestParam int drink) {
		Optional<Cocktail> cocktail = cocktailRepos.findById(drink);
		if (cocktail.isEmpty()) {
			return "pog";
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

	@DeleteMapping("/delete/equipment")
	public @ResponseBody
	String deleteEquipment(@RequestParam int equipNo) {
		Optional<Equipment> glass = equipmentRepos.findById(equipNo);
		if (glass.isEmpty()) {
			return "it ain't workin chief but equip";
		} else {
			ingredientRepos.deleteById(equipNo);
			return "poggers! but equip";
		}
	}
}
