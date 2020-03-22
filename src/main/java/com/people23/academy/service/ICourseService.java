package com.people23.academy.service;

import java.util.List;

import com.people23.academy.entity.Course;

public interface ICourseService {
	
	public List<Course> findAll();
	
	public Course findCourse(Course course);
	
	public Course findByCode(String code);
	
	public void save(Course course);
	
	public void deleteCourse(String code);
	
	public Course updateCourse(Course course);

}
