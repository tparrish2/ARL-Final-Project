package ARL.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ARL.beans.Animals;
import ARL.repository.AnimalsRepository;

/**
 * @author Bradh 
 * CIS175 23290 Java II Spring 2023
 * Apr 2, 2023
 */

@Controller
public class AnimalsWebController {
	
	@Autowired
	AnimalsRepository repo;
	
	// These controllers add, edit, and delete animals. This is set up
	// to do these things on the same page, not automatically redirecting 
	// to a view of all animals (in a list). So that way the arl user does not have to return
	// to the enter page over and over again. - Brad 4/16/23
	
	@GetMapping({"/", "View-animal-list"})
	public String ViewAnimalList(Model model) {
		
		if (repo.findAll().isEmpty()) {
			return EnterAnAnimal(model);
		}
		
		model.addAttribute("Animals", repo.findAll());
		return "view-animal-list";
	}
	
	@GetMapping("/enter-an-animal")
	public String EnterAnAnimal(Model model) {
		Animals newAn = new Animals();
		model.addAttribute("animal", newAn);
		return "enter-an-animal";
	}
	
	@PostMapping("/enter-an-animal")
	public String EnterAnAnimal(@ModelAttribute Animals a, Model model) {
		repo.save(a);
		return EnterAnAnimal(model);
	}
	
	@GetMapping("/edit/{id}")
	public String EditAnimals(@PathVariable("id") long id, Model model) {
		Animals a = repo.findById(id).orElse(null);
		model.addAttribute("animal", a);
		return "enter-an-animal";
	}
	
	@PostMapping("/update/{id}")
	public String ReviseAnimals(Animals a, Model model) {
		repo.save(a);
		return EnterAnAnimal(model);
	}
	
	@GetMapping("/delete/{id}")
	public String deleteAnimals(@PathVariable("id") long id, Model model) {
		Animals a = repo.findById(id).orElse(null);
		repo.delete(a);
		return EnterAnAnimal(model);
	}
	
	@GetMapping("/view-adoptee-application-list")
	public String ViewAdopteeApps() {
		return "view-adoptee-application-list";
	}

}
