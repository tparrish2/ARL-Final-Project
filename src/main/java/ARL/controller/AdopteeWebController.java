package ARL.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ARL.beans.Adoptee;
import ARL.repository.AdopteeRepository;

@Controller
public class AdopteeWebController {

    @Autowired
    AdopteeRepository repo;

    @GetMapping("/create-adoptee-application")
    public String createAdopteeApplication(Model model) {
        Adoptee adoptee = new Adoptee();
        model.addAttribute("adoptee", adoptee);
        return "create-adoptee-application";
    }

    @PostMapping("/create-adoptee-application")
    public String submitAdopteeApplication(@ModelAttribute Adoptee adoptee, Model model) {
        repo.save(adoptee);
        return "redirect:/view-adoptee-application-list";
    }

    @GetMapping("/view-adoptee-application-list")
    public String viewAdopteeApplicationList(Model model) {
        model.addAttribute("adoptees", repo.findAll());
        return "view-adoptee-application-list";
    }
}
