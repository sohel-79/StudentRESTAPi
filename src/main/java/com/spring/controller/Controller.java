package com.spring.controller;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.entity.Student;
import com.spring.service.StudentService;



@RestController
public class Controller {

	@Autowired
	StudentService service;
	
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getStudents(){
		List<Student> allStudents = this.service.getAllStudents();
		if (allStudents.size()<=0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(allStudents));
	}
	
	@PostMapping("/students")
	public ResponseEntity<Student> addBoook(@RequestBody Student s) {
		try {
		Student addStudent= this.service.addStudent(s);
		System.out.println(s);
		return ResponseEntity.status(HttpStatus.CREATED).body(addStudent);
		}
		catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	
	@DeleteMapping("/students/{id}")
	public ResponseEntity<Void> deleteStudent(@PathVariable("id") int id) {
		try {
		System.out.println("Student deleted with id " + id);
		this.service.deleteStudent(id);
		return ResponseEntity.noContent().build();
		
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.internalServerError().build();
		}
	}
	
	@PutMapping("/students/{id}")
	public ResponseEntity<Student> updateBook(@RequestBody Student std ,@PathVariable("id") int id) {
		try {
		this.service.updateStudent(std, id);
		return ResponseEntity.ok().body(std);
		
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
}
