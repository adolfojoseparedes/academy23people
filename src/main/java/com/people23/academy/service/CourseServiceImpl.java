package com.people23.academy.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.people23.academy.dao.ICourseDao;
import com.people23.academy.entity.Course;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class CourseServiceImpl implements ICourseService {
	
	@Autowired
	private ICourseDao courseDao;

	@Override
	@Transactional(readOnly=true)
	public List<Course> findAll() {
		log.info("service CourseServiceImpl - calling findAll method");
		return (List<Course>) courseDao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Course findCourse(Course course) {
		log.info("service CourseServiceImpl - calling findCourse method");
		return (Course) courseDao.findByCode(course.getCode());
	}

	@Override
	@Transactional(readOnly=true)
	public Course findByCode(String code) {
		log.info("service CourseServiceImpl - calling findByCode method");
		return (Course) courseDao.findByCode(code);
	}

	@Override
	@Transactional
	public void save(Course course) {
		log.info("service CourseServiceImpl - calling save method");
		courseDao.save(course);
	}

	@Override
	@Transactional
	public void deleteCourse(String code) {
		log.info("service CourseServiceImpl - calling deleteCourse method");
		courseDao.deleteByCode(code);
	}

	@Override
	@Transactional
	public Course updateCourse(Course course) {
		log.info("service CourseServiceImpl - calling updateCourse method");
		return (Course) courseDao.save(course);
	}
}
