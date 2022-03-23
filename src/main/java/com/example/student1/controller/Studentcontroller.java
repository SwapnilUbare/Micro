package com.example.student1.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.student1.Entity.Student;
import com.example.student1.service.Studentservice;



@Controller
public class Studentcontroller {
	
	private Studentservice studservice;

	public Studentcontroller(Studentservice studservice) {
		super();
		this.studservice = studservice;
	}
	
	@GetMapping("/students")
	public String listStudents(Model model)
	{
		model.addAttribute("students",studservice.getAllStudents());
		
		return "students";
	}
	
	@GetMapping("/students/new")
	public String createStudentForm(Model model)
	{
		Student student=new Student();
		model.addAttribute("Student", student);
		
		return "create_student";
	}
	
	@PostMapping("/students")
	
	public String saveStudent(@ModelAttribute("student") Student student)
	{
		
		studservice.saveStudent(student);
		
		return "redirect:/students";
		
	}
	
	@GetMapping("/students/edit/{id}")
	//@RequestMapping("/students/edit/{id}(id=${student.id})")
	public String editStudentForm(@PathVariable Long id,Model model)
	{
		model.addAttribute("student", studservice.getStudentById(id));
		
		return "edit_student";
	}
	
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student, Model model)
	{
		
		Student existingStudent=studservice.getStudentById(id);
		existingStudent.setId(id);
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());
		
		
		studservice.updateStudent(existingStudent);
		
		return "redirect:/students";
	}
	
	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable Long id)
	{
		studservice.deleteStudentById(id);
		return "redirect:/students";
		
	}
	

}
