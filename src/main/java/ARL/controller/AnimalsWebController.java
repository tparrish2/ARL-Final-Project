package ARL.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ARL.beans.Animals;
import ARL.repository.AnimalsRepository;

/**
 * @author Bradh 
 * CIS175 23290 Java II Spring 2023
 * Apr 2, 2023
 * Updated by Trevor on Apr 29, 2023
 */

@Controller
public class AnimalsWebController {
	
	@Autowired
	AnimalsRepository repo;
	
	// These controllers add, edit, and delete animals. This is set up
	// to do these things on the same page, not automatically redirecting 
	// to a view of all animals (in a list). So that way the arl user does not have to return
	// to the enter page over and over again. - Brad 4/16/23
	
	@GetMapping({"/view-animal-list"})
	public String ViewAnimalList(Model model) {
		
		if (repo.findAll().isEmpty()) {
			return EnterAnAnimal(model);
		}
		
		model.addAttribute("animals", repo.findAll());
		return "view-animal-list";
	}
	
	@GetMapping({"/view-animal-list-adoptee"})
	public String ViewAnimalListAdoptee(Model model) {
		
		//if (repo.findAll().isEmpty()) {
			//return EnterAnAnimal(model);
		//}
		
		model.addAttribute("animals", repo.findAll());
		return "view-animal-list-adoptee";
	}
	
	@GetMapping("/enter-an-animal")
	public String EnterAnAnimal(Model model) {
		Animals a = new Animals();
		model.addAttribute("newAnimal", a);
		return "/enter-an-animal";
	} 
	
	@PostMapping("/enter-an-animal")
	public String EnterAnAnimal(@ModelAttribute Animals a, Model model) {
		repo.save(a);
		return EnterAnAnimal(model);
	}
	
	@GetMapping("/edit/{id}")
	public String showUpdateAnimal(@PathVariable("id") long id, Model model) {
		Animals a = repo.findById(id).orElse(null);
		model.addAttribute("newAnimal", a);
		return "enter-an-animal";
	}
	
	@PostMapping("/update/{id}")
	public String reviseAnimal(Animals a, Model model) {
		repo.save(a);
		return EnterAnAnimal(model);
	}
	
	@GetMapping("/delete/{id}")
	public String deleteAnimals(@PathVariable("id") long id, Model model) {
		Animals a = repo.findById(id).orElse(null);
		repo.delete(a);
		return EnterAnAnimal(model);
	}
	@GetMapping("/animal-search")
	public String searchAnimal(Model model) {
		model.addAttribute("searchAnimal", new Animals());
	    return "animal-search";
	}

	@PostMapping("/animal-search")
	public String searchAnimal(@ModelAttribute Animals searchAnimal, Model model) {
		List<Animals> animals = repo.findAll().stream().filter(animal -> animalMatchesSearch(animal, searchAnimal)).collect(Collectors.toList());
	    model.addAttribute("animals", animals);
	    return "animal-search-results";
	}

	private boolean animalMatchesSearch(Animals animal, Animals searchAnimal) {
		boolean nameMatches = searchAnimal.getAnimalName() == null || searchAnimal.getAnimalName().trim().isEmpty() || animal.getAnimalName().equalsIgnoreCase(searchAnimal.getAnimalName());
	    boolean typeMatches = searchAnimal.getAnimalType() == null || searchAnimal.getAnimalType().trim().isEmpty() || animal.getAnimalType().equalsIgnoreCase(searchAnimal.getAnimalType());
	    boolean breedMatches = searchAnimal.getBreed() == null || searchAnimal.getBreed().trim().isEmpty() || animal.getBreed().equalsIgnoreCase(searchAnimal.getBreed());

	    return nameMatches && typeMatches && breedMatches;
	}


 
}
