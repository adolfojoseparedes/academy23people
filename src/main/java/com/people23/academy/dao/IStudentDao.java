package com.people23.academy.dao;

import org.springframework.data.repository.CrudRepository;
import com.people23.academy.entity.Student;

/**
 * Interface DAO with database operations not defined in jpa's CRUD for students
 * 
 * @author 23 People Company
 *
 */
public interface IStudentDao extends CrudRepository<Student, String> {
	
	public Student findByRut(String rut);
	
	public void deleteByRut(String rut);

}
