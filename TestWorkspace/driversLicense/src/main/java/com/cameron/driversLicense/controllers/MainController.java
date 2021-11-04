package com.cameron.driversLicense.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cameron.driversLicense.models.License;
import com.cameron.driversLicense.models.Person;
import com.cameron.driversLicense.services.LicenseService;
import com.cameron.driversLicense.services.PersonService;

@Controller
public class MainController {
	@Autowired
	public PersonService pService;
	@Autowired
	public LicenseService lService;
	
	@GetMapping("/")
	public String index(@ModelAttribute("person")Person newPerson, @ModelAttribute("license")License newLicense, Model viewModel) {
		List<Person> allPeople = this.pService.getAll();
		viewModel.addAttribute("allPeople", allPeople);
		return "index.jsp";
	}
	@PostMapping("/person")
	public String createPerson(@Valid @ModelAttribute("person")Person newPerson, BindingResult results) {
		this.pService.createEntry(newPerson);
		return"redirect:/";
	}
	@PostMapping("/license")
	public String createLicense(@Valid @ModelAttribute("license")License newLicense, BindingResult results) {
		License thisLicense = this.lService.createLicense(newLicense);
		Person licensedPerson = thisLicense.getPerson();
		thisLicense.setLicenseNumber(this.lService.createLicenseNumber(licensedPerson.getId()));
		return "redirect:/";
	}
}
