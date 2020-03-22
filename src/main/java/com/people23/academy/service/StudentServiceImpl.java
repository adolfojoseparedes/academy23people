package com.people23.academy.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.people23.academy.dao.IStudentDao;
import com.people23.academy.entity.Student;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class StudentServiceImpl implements IStudentService {


	@Autowired
	private IStudentDao studentDao;

	@Override
	@Transactional(readOnly=true)
	public List<Student> findAll() {
		log.info("service StudentImpl - calling findAll method");
		return (List<Student>) studentDao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Student findStudent(Student student) {
		log.info("service StudentImpl - calling findStudent method");
		return (Student) studentDao.findByRut(student.getRut());
	}
	
	@Override
	@Transactional(readOnly=true)
	public Student findByRut(String rut) {
		log.info("service StudentImpl - calling findByRut method");
		return (Student) studentDao.findByRut(rut);
	}
	
	@Override
	@Transactional
	public void save(Student student) {
		log.info("service StudentImpl - calling save method");
		studentDao.save(student);
	}

	@Override
	@Transactional
	public void deleteStudent(String rut) {
		log.info("service StudentImpl - calling deleteStudent method");
		studentDao.deleteByRut(rut);
		
	}

	@Override
	@Transactional
	public Student updateStudent(Student student) {
		log.info("service StudentImpl - calling updateStudent method");
		return (Student) studentDao.save(student);
	}
}
