package com.people23.academy.dao;

import org.springframework.data.repository.CrudRepository;
import com.people23.academy.entity.Course;

/**
 * Interface DAO with database operations not defined in jpa's CRUD for courses
 * 
 * @author 23 People Company
 *
 */
public interface ICourseDao extends CrudRepository<Course, String> {
	
	public Course findByCode (String code);
	
	public void deleteByCode(String code);
}
