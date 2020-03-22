package com.people23.academy.dao;

import org.springframework.data.repository.CrudRepository;

import com.people23.academy.entity.Course;

public interface ICourseDao extends CrudRepository<Course, String> {
	
	public Course findByCode (String code);
	
	public void deleteByCode(String code);
}
