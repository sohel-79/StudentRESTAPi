package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.StudentRepo;
import com.spring.entity.Student;

@Service
public class StudentService {

	@Autowired
	StudentRepo repo;
	
	public List<Student>getAllStudents(){
		List<Student> allStudents = (List<Student>) this.repo.findAll();
		return allStudents;
	}
	
	public Student addStudent(Student s) {
		Student student = this.repo.save(s);
		return student;
	}
	
	public void deleteStudent(int id) {
		this.repo.deleteById(id);
	}
	
	public void updateStudent(Student std ,int std_id) {
		std.setId(std_id);
		this.repo.save(std);
	}
}
