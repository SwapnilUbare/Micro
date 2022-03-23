package com.example.student1.service;

import java.util.List;

import com.example.student1.Entity.Student;



public interface Studentservice {
	
	List<Student> getAllStudents();
	
	Student saveStudent(Student student);

	
	Student getStudentById(Long Id);
	
	Student updateStudent(Student student);
	
	void deleteStudentById(Long Id);

}
