package ARL.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import ARL.repository.ARLInfoRepository;

/**
 * @author Bradh 
 * CIS175 23290 Java II Spring 2023
 * Apr 10, 2023
 */

@Controller
public class HomeController {
	
	@Autowired
	ARLInfoRepository repo;
	
	/* The commented out code below is in-development code for a sign in view/controller for an arl
	/* I (Brad) am placing this in the back of priotities as of now (4/14/23) in the interst of time 
	/* to continue development and construction of the rest of the website. ***********************/
	
	/*@GetMapping("/arlSignIn")
	public String ARLSignIn(Model model) {
		ARLInfo signIn = new ARLInfo();
		if (signIn.) {
			return "sign-in";
		}
	}
	
	// CODE TO BE DEVELOPED
	
	/* @PostMapping("/arlSignIn")
	public String ARLSignIn(@ModelAttribute ARLInfo signIn, Model model) {
		// code i'm unsure of as of this time - Bradley 4/10/2023
		return ARLAdminPage(model);
	} */
	
	@GetMapping("/index")
	public String Index() {
		return "index";
	}
	
	@GetMapping("/arlHomePage")
	public String ARLHomePage() {
		return "arl-homepage";
	} 
	
	@GetMapping("/adoptee-homepage") 
	public String AdopteeHomepage() {
		return "adoptee-homepage";
	}
	
	@GetMapping("/about")
	public String About() {
		return "about";
	}
}
