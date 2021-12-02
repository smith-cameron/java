package com.cameronsmith.driverslicense.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cameronsmith.driverslicense.models.License;
import com.cameronsmith.driverslicense.models.Person;
import com.cameronsmith.driverslicense.services.LicenseService;
import com.cameronsmith.driverslicense.services.PersonService;

@Controller
public class MainController {
	@Autowired
	private PersonService pService;
	@Autowired
	private LicenseService lService;
	
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@GetMapping("/person/new")
	public String newPerson(@ModelAttribute("person")Person person) {
		return "newPerson.jsp";
	}
	
	@PostMapping("/person/add")
    public String createObject(@Valid @ModelAttribute("person")Person person, BindingResult result) {
		if (result.hasErrors()) {
            return "newPerson.jsp";
        } 
        this.pService.createEntry(person);
        return "redirect:/person/new";
    }
	
	@GetMapping("/license/new")
	public String newLicense(@ModelAttribute("license")License license, Model viewModel) {
		List<Person> allPeople = pService.getAll();
		viewModel.addAttribute("allPeople", allPeople);
		return "newLicense.jsp";
	}
	
	@PostMapping("/license/add")
	public String createObject(@Valid @ModelAttribute("license")License license, BindingResult result, RedirectAttributes redirectAttr, Model viewModel) {
		List<Person> allPeople = pService.getAll();
		ArrayList<String> errors = new ArrayList<String>();
		List<License> allLicense = lService.getAll();
		if (result.hasErrors()) {
			viewModel.addAttribute("allPeople", allPeople);
            return "newLicense.jsp";
        }
		for(License l: allLicense) {
			if(license.getPerson().equals(l.getPerson())) {
				errors.add("That person already has a license!");
			}
		}
		if(errors.size() > 0) {
			for(String e: errors){
				viewModel.addAttribute("allPeople", allPeople);
				viewModel.addAttribute("errors", errors);
				redirectAttr.addFlashAttribute("errors", e);
				return "newLicense.jsp";
			}
		}
		License newL = this.lService.createLicense(license);
		this.lService.generateLicenseNum(newL);
		return "redirect:/person/"+newL.getPerson().getId();
		
	}
	@GetMapping("/person/{id}")
	public String showInfo( @PathVariable("id")Long id, Model viewModel) {
		viewModel.addAttribute("person", pService.getById(id));
		viewModel.addAttribute("license", pService.getById(id).getLicense());
		return "showInfo.jsp";
	}
}
