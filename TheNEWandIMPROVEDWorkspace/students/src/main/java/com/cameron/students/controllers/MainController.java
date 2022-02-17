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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cameron.students.models.Contact;
import com.cameron.students.models.Dorm;
import com.cameron.students.models.Stack;
import com.cameron.students.models.Student;
import com.cameron.students.services.ContactService;
import com.cameron.students.services.DormService;
import com.cameron.students.services.StudentService;

@Controller
public class MainController {
	@Autowired
	private StudentService sService;
	@Autowired
	private ContactService cService;
	@Autowired
	private DormService dService;
	
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
	@GetMapping("/additions")										
	public String additions(@ModelAttribute("student") Student newStudent, @ModelAttribute("stack") Stack newStack,  @ModelAttribute("dorm") Dorm newDorm){											
		return "Additions.jsp";									
	}
	@PostMapping("/student/new")
	public String createStudent(@Valid @ModelAttribute("student") Student newStudent, BindingResult result) {
		if (result.hasErrors()) {
			return "Additions.jsp";
		}
		this.sService.create(newStudent);
		return "redirect:/students";
	}
//	postmapping for new stack
	@PostMapping("/dorms/new")
	public String newDorm(@Valid @ModelAttribute("dorm")Dorm newDorm, BindingResult result, Model viewModel) {
		if (result.hasErrors()) {
			viewModel.addAttribute("dorms", this.dService.getAll());
			return "Dorms.jsp";
		}
		this.dService.create(newDorm);
		return "redirect:/dorms";
	}
	@PostMapping("/contact/{id}/new")
	public String createContact(@Valid @ModelAttribute("newContact") Contact newContact, BindingResult result,@PathVariable("id")Long studentId, Model viewModel) {
		if (result.hasErrors()) {
			viewModel.addAttribute("dorms", this.dService.getAll());
			viewModel.addAttribute("student", this.sService.getById(studentId));
			viewModel.addAttribute("myContact", this.cService.getByStudent(this.sService.getById(studentId)));
			return "ShowStudent.jsp";
		}
		this.cService.create(newContact);
		return "redirect:/students";
	}
	@PostMapping("/contact/{id}/edit")
	public String editStudentContactInfo(@Valid @ModelAttribute("myContact")Contact contactInput, BindingResult result, @PathVariable("id")Long studentId, Model viewModel) {
		if (result.hasErrors()) {
			viewModel.addAttribute("dorms", this.dService.getAll());
			viewModel.addAttribute("student", this.sService.getById(studentId));
			viewModel.addAttribute("myContact", this.cService.getByStudent(this.sService.getById(studentId)));
			return "ShowStudent.jsp";
		}
		this.cService.create(contactInput);
		return "redirect:/students/"+studentId;
	}
	@GetMapping("/dorms")
	public String allDorms(@ModelAttribute("dorm")Dorm newDorm, Model viewModel) {
		viewModel.addAttribute("dorms", this.dService.getAll());
		return "Dorms.jsp";
	}
	@GetMapping("/dorm/{id}")
	public String deleteDorm(@PathVariable("id")Long dormId) {
		this.dService.deleteById(dormId);
		return "redirect:/dorms";
	}
	@GetMapping("/dorms/{id}")
	public String showDorm(@ModelAttribute("student") Student newStudent, Model viewModel, @PathVariable("id") Long dormId) {
		viewModel.addAttribute("students", this.sService.getAll());
		viewModel.addAttribute("dorm", this.dService.getById(dormId));
		return "ShowDorm.jsp";
	}
	@GetMapping("/students/{id}")
	public String showStudent(@ModelAttribute("newContact")Contact newContact, @PathVariable("id")Long studentId, Model viewModel) {
		viewModel.addAttribute("dorms", this.dService.getAll());
		viewModel.addAttribute("student", this.sService.getById(studentId));
		viewModel.addAttribute("myContact", this.cService.getByStudent(this.sService.getById(studentId)));
		return "ShowStudent.jsp";
	}
	@GetMapping("/student/{id}/edit")
	public String editStudent(@ModelAttribute("studentform")Student st, @PathVariable("id")Long studentId, Model viewModel) {
		viewModel.addAttribute("student", this.sService.getById(studentId));
		return "EditStudent.jsp";
	}
	@PostMapping("/student/{id}/edit")
	public String postEditStudent(@Valid @ModelAttribute("studentform")Student updatedStudent, BindingResult result, @PathVariable("id")Long studentId, Model viewModel) {
		if (result.hasErrors()) {
			viewModel.addAttribute("student", this.sService.getById(studentId));
			return "EditStudent.jsp";
		}
		this.sService.create(updatedStudent);
		return "redirect:/students";
	}
	@PostMapping("/dorms/{id}/add")
	public String addDorm(@RequestParam("dorm")Long dormId, @PathVariable("id")Long studentId, RedirectAttributes redirectAtters) {
		Dorm dormToAdd = this.dService.getById(dormId);
		this.sService.setDorm(studentId, dormToAdd);
		redirectAtters.addAttribute("sId", studentId);
		return String.format("redirect:/students/%d", studentId);
	}
	@PostMapping("/dorms/{id}/remove")
	public String removeDormViaForm(@PathVariable("id")Long studentId) {
		Student student = this.sService.getById(studentId);
		this.sService.removeDorm(student);
		return "redirect:/students/{id}";
	}
	@GetMapping("/{dormId}/{studentId}/remove")
	public String removeDormViaLink(@PathVariable("studentId")Long studentId,@PathVariable("dormId")Long dormId) {
		Student student = this.sService.getById(studentId);
		this.sService.removeDorm(student);
		return "redirect:/dorms/"+dormId;
	}
	
}
