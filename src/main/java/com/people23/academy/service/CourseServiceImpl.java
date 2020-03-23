package com.people23.academy.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.people23.academy.dao.ICourseDao;
import com.people23.academy.entity.Course;
import lombok.extern.log4j.Log4j2;

/**
 * Class service of MVC model for the API management courses
 * 
 * @author 23 People Company
 *
 */
@Service
@Log4j2
public class CourseServiceImpl implements ICourseService {
	
	@Autowired
	private ICourseDao courseDao;

	/**
    * Method intermediate for interaction between API controller get all courses and its DAO
    * @return List<Course> list of courses
    */
	@Override
	@Transactional(readOnly=true)
	public List<Course> findAll() {
		log.info("service CourseServiceImpl - calling findAll method");
		return (List<Course>) courseDao.findAll();
	}

	/**
    * Method intermediate for interaction between API controller find course and its DAO
    * @param Course entity course
    * @return Course entity with the course searched
    */
	@Override
	@Transactional(readOnly=true)
	public Course findCourse(Course course) {
		log.info("service CourseServiceImpl - calling findCourse method");
		return (Course) courseDao.findByCode(course.getCode());
	}
	
	/**
    * Method intermediate for interaction between API controller find course by code and its DAO
    * @param String course code
    * @return Course entity with the course searched by code
    */
	@Override
	@Transactional(readOnly=true)
	public Course findByCode(String code) {
		log.info("service CourseServiceImpl - calling findByCode method");
		return (Course) courseDao.findByCode(code);
	}
	
	/**
    * Method intermediate for interaction between API controller save course and its DAO
    * @param Course course entity
    * @return void not return value
    */
	@Override
	@Transactional
	public void save(Course course) {
		log.info("service CourseServiceImpl - calling save method");
		courseDao.save(course);
	}

	/**
    * Method intermediate for interaction between API controller delete course and its DAO
    * @param String course code
    * @return void not return value
    */
	@Override
	@Transactional
	public void deleteCourse(String code) {
		log.info("service CourseServiceImpl - calling deleteCourse method");
		courseDao.deleteByCode(code);
	}
	
	/**
    * Method intermediate for interaction between API controller update course and its DAO
    * @param String object course
    * @return void not return value
    */
	@Override
	@Transactional
	public Course updateCourse(Course course) {
		log.info("service CourseServiceImpl - calling updateCourse method");
		return (Course) courseDao.save(course);
	}
}
