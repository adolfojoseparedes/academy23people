package com.people23.academy.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.people23.academy.dao.IStudentDao;
import com.people23.academy.entity.Student;
import lombok.extern.log4j.Log4j2;

/**
 * Class service of MVC model for the API management students
 * 
 * @author 23 People Company
 *
 */
@Service
@Log4j2
public class StudentServiceImpl implements IStudentService {


	@Autowired
	private IStudentDao studentDao;

	/**
    * Method intermediate for interaction between API controller get all students and its DAO
    * @return List<Student> list of students
    */
	@Override
	@Transactional(readOnly=true)
	public List<Student> findAll() {
		log.info("service StudentImpl - calling findAll method");
		return (List<Student>) studentDao.findAll();
	}
	
	/**
    * Method intermediate for interaction between API controller find student and its DAO
    * @param Student entity student
    * @return Student entity with the student searched
    */
	@Override
	@Transactional(readOnly=true)
	public Student findStudent(Student student) {
		log.info("service StudentImpl - calling findStudent method");
		return (Student) studentDao.findByRut(student.getRut());
	}
	
	/**
    * Method intermediate for interaction between API controller find student by rut and its DAO
    * @param String rut of student
    * @return Student entity with the student searched
    */
	@Override
	@Transactional(readOnly=true)
	public Student findByRut(String rut) {
		log.info("service StudentImpl - calling findByRut method");
		return (Student) studentDao.findByRut(rut);
	}
	
	/**
    * Method intermediate for interaction between API controller save student and its DAO
    * @param Student student entity
    * @return void not return value
    */
	@Override
	@Transactional
	public void save(Student student) {
		log.info("service StudentImpl - calling save method");
		studentDao.save(student);
	}

	/**
    * Method intermediate for interaction between API controller delete student and its DAO
    * @param String rut student
    * @return void not return value
    */
	@Override
	@Transactional
	public void deleteStudent(String rut) {
		log.info("service StudentImpl - calling deleteStudent method");
		studentDao.deleteByRut(rut);
		
	}

	/**
    * Method intermediate for interaction between API controller update student and its DAO
    * @param Student object student
    * @return void not return value
    */
	@Override
	@Transactional
	public Student updateStudent(Student student) {
		log.info("service StudentImpl - calling updateStudent method");
		return (Student) studentDao.save(student);
	}
}
