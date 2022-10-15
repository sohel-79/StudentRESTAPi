package com.spring.dao;

import org.springframework.data.repository.CrudRepository;

import com.spring.entity.Student;

public interface StudentRepo extends CrudRepository<Student, Integer>{

}
