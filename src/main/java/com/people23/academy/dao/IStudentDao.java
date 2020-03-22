package com.people23.academy.dao;

import org.springframework.data.repository.CrudRepository;

import com.people23.academy.entity.Student;

/*
 * 
 */
public interface IStudentDao extends CrudRepository<Student, String> {
	
	public Student findByRut(String rut);
	
	public void deleteByRut(String rut);

}
