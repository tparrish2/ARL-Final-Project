package ARL.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ARL.beans.ARLInfo;
import ARL.repository.ARLInfoRepository;

/**
 * @author Bradh 
 * CIS175 23290 Java II Spring 2023
 * Apr 10, 2023
 */

@Controller
public class ARLController {
	
	@Autowired
	ARLInfoRepository repo;
	
	@GetMapping("/arlSignIn")
	public String ARLSignIn(Model model) {
		ARLInfo signIn = new ARLInfo();
		model.equals(signIn); // I'm assuming we would use equals for checking sign in info from the database
		return "sign-in";
	}
	
	// CODE TO BE DEVELOPED
	
	/* @PostMapping("/arlSignIn")
	public String ARLSignIn(@ModelAttribute ARLInfo signIn, Model model) {
		// code i'm unsure of as of this time - Bradley 4/10/2023
		return ARLAdminPage(model);
	}
	
	@GetMapping("/ARLAdminPage")
	public String ARLAdminPage(Model model) {
		
	} */

}
