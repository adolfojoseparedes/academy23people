package com.people23.academy.service;

import java.util.List;

import com.people23.academy.entity.Student;

/*
 * 
 */
public interface IStudentService {

	public List<Student> findAll();
	
	public Student findStudent(Student student);
	
	public Student findByRut(String rut);
	
	public void save(Student student);
	
	public void deleteStudent(String rut);
	
	public Student updateStudent(Student student);
	

}
