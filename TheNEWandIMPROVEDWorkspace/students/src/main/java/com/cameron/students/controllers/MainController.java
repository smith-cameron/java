package com.cameron.students.controllers;

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
import org.springframework.web.bind.annotation.RequestParam;

import com.cameron.students.models.Contact;
import com.cameron.students.models.Dorm;
import com.cameron.students.models.Stack;
import com.cameron.students.models.Student;
import com.cameron.students.services.ContactService;
import com.cameron.students.services.DormService;
import com.cameron.students.services.StackService;
import com.cameron.students.services.StudentService;

@Controller
public class MainController {
	@Autowired
	private StudentService sService;
	@Autowired
	private ContactService cService;
	@Autowired
	private DormService dService;
	@Autowired
	private StackService stService;
	
	@GetMapping("/")										
	public String index(){											
		return "redirect:/students";
	}
	@GetMapping("/students")										
	public String allStudents(Model viewModel){
		List<Student> allStudents = this.sService.getAll();
		viewModel.addAttribute("students", allStudents);
		List<Dorm> allDorms = this.dService.getAll();
		viewModel.addAttribute("allDorms", allDorms);
		return "index.jsp";									
	}
	@GetMapping("/students/new")										
	public String newStudent(@ModelAttribute("cookies") Student newStudent){											
		return "NewStudent.jsp";									
	}
	@PostMapping("/students/new")
	public String createStudent(@Valid @ModelAttribute("cookies") Student newStudent, BindingResult result) {
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
	@GetMapping("/dorms")
	public String allDorms(@ModelAttribute("dorm")Dorm newDorm, Model viewModel) {
		List<Dorm> allDorms = this.dService.getAll();
		viewModel.addAttribute("dorms", allDorms);
		return "Dorms.jsp";
	}
	@PostMapping("/dorms/new")
	public String newDorm(@Valid @ModelAttribute("dorm")Dorm newDorm, BindingResult result, Model viewModel) {
		if (result.hasErrors()) {
			List<Dorm> allDorms = this.dService.getAll();
			viewModel.addAttribute("dorms", allDorms);
			return "Dorms.jsp";
		}
		this.dService.create(newDorm);
		return "redirect:/dorms";
	}
	@GetMapping("/dorms/{id}")
	public String showDorm(@ModelAttribute("student") Student newStudent, Model viewModel, @PathVariable("id") Long dormId) {
		Dorm thisDorm = this.dService.getById(dormId);
		List<Student> allStudents = this.sService.getAll();
		viewModel.addAttribute("students", allStudents);
		viewModel.addAttribute("dorm", thisDorm);
		return "ShowDorm.jsp";
	}
	@GetMapping("/students/{id}")
	public String showStudent(@PathVariable("id")Long studentId, Model viewModel) {
		Student thisStudent = this.sService.getById(studentId);
		List<Stack> allStacks = this.stService.getAll();
		List<Stack> enrolledStacks = thisStudent.getStacks();
		viewModel.addAttribute("student", thisStudent);
		viewModel.addAttribute("stacks", enrolledStacks);
		viewModel.addAttribute("allStacks", allStacks);
		return "ShowStudent.jsp";
	}
	@GetMapping("/student/{id}/edit")
	public String editStudent(@PathVariable("id")Long studentId) {
		
		return "EditStudent.jsp";
	}
	@PostMapping("/dorms/{id}/add")
	public String addDorm(@RequestParam("dorm")Long dormId, @PathVariable("id")Long studentId) {
		Dorm dormToAdd = this.dService.getById(dormId);
		this.sService.setDorm(studentId, dormToAdd);
		return "redirect:/students";
	}
	@GetMapping("/dorm/{id}")
	public String deleteDorm(@PathVariable("id")Long dormId) {
		this.dService.deleteById(dormId);
		return "redirect:/dorms";
	}
	@PostMapping("/dorms/{id}/remove")
	public String removeDorm(@PathVariable("id")Long studentId) {
		Student student = this.sService.getById(studentId);
		this.sService.removeDorm(student);
		
		return "redirect:/students";
	}
	@GetMapping("/stack/new")
	public String newStack(@ModelAttribute("stack") Stack newStack, Model viewModel) {
		List<Stack> allStack = this.stService.getAll();
		viewModel.addAttribute("stacks", allStack);
		return "NewStack.jsp";
	}
	@PostMapping("/stack/new")
	public String createStack(@Valid @ModelAttribute("stack")Stack newStack, BindingResult result, Model viewModel) {
		if (result.hasErrors()) {
			List<Stack> allStacks = this.stService.getAll();
			viewModel.addAttribute("stacks", allStacks);
			return "NewStack.jsp";
		}
		this.stService.create(newStack);
		return "redirect:/stack/new";
	}
	@GetMapping("/stack/{id}")
	public String stackInfo(@PathVariable("id")Long stackId, Model viewModel) {
		Stack thisStack = this.stService.getById(stackId);
		viewModel.addAttribute("stack", thisStack);
		return "ShowStack.jsp";
	}
//	@GetMapping("/logout")
//	public String logout(HttpSession session) {
//			session.invalidate();
//			return "redirect:/";
//	}
}
