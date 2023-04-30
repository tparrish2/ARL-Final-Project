package ARL.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ARL.repository.AdopteeRepository;
import ARL.repository.AnimalsRepository;

/**
 * @author Trevor P 
 * CIS175 23290 Java II Spring 2023
 * Apr 29, 2023
 */

@Controller
public class AdopteeWebController {
	
	@Autowired
	AnimalsRepository repo;
	
	

}
