package com.spring.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "StudentRESTAPI")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	int id;
	String name;
	String email;
	String degree;
	String university;
}
