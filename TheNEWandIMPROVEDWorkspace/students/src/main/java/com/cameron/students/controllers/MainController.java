package com.cameron.students.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cameron.students.models.Contact;
import com.cameron.students.models.Student;
import com.cameron.students.services.ContactService;
import com.cameron.students.services.StudentService;

@Controller
public class MainController {
	@Autowired
	private StudentService sService;
	@Autowired
	private ContactService cService;
	
	@GetMapping("/")										
	public String index(){											
		return "redirect:/students";									
	}
	@GetMapping("/students")										
	public String allStudents(Model viewModel){
		List<Student> allStudents = this.sService.getAll();
		viewModel.addAttribute("students", allStudents);
		return "index.jsp";									
	}
	@GetMapping("/students/new")										
	public String newStudent(@ModelAttribute("student") Student newStudent){											
		return "NewStudent.jsp";									
	}
	@PostMapping("/students/new")
	public String createStudent(@Valid @ModelAttribute("student") Student newStudent, BindingResult result) {
		if (result.hasErrors()) {
			return "NewStudent.jsp";
		}
		this.sService.create(newStudent);
		return "redirect:/students";
	}
	@GetMapping("/contacts/new")										
	public String newContact(@ModelAttribute("contact") Contact newContact, Model viewModel){
		List<Student> allStudents = this.sService.getAll();
		viewModel.addAttribute("students", allStudents);
		return "NewContact.jsp";									
	}
	@PostMapping("/contacts/new")
	public String createContact(@Valid @ModelAttribute("contact") Contact newContact, BindingResult result, Model viewModel) {
		if (result.hasErrors()) {
			List<Student> allStudents = this.sService.getAll();
			viewModel.addAttribute("students", allStudents);
			return "NewContact.jsp";
		}
		this.cService.create(newContact);
		return "redirect:/students";
	}
}
