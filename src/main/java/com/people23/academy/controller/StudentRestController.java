package com.people23.academy.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.people23.academy.entity.Student;
import com.people23.academy.service.IStudentService;
import com.people23.academy.utils.IBaseValidations;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/api")
@Log4j2
public class StudentRestController {

	@Autowired
	private IStudentService studentService;
	
	@Autowired
	private IBaseValidations baseValidations;
	
	@GetMapping("/students")
	@ResponseStatus(HttpStatus.OK)
	public List<Student> getStudent() {
		log.info("controller CourseRestController - calling getStudent method");
		return studentService.findAll();
		
	}
	
	@GetMapping("/students/{rut}")
	public ResponseEntity<?> findCourse(@PathVariable(value="rut")String rut) {
		log.info("controller CourseRestController - calling findCourse method");
		Student studentDb = studentService.findByRut(rut);
		if(studentDb!=null) {
			return new ResponseEntity<>(studentDb, HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/students")
	public ResponseEntity<Void>addStudent(@RequestBody Student student) {
		log.info("controller CourseRestController - calling addStudent method");
		if(studentService.findStudent(student)==null) {
			baseValidations.validateObjectRut(student.getRut(),"Rut");
			studentService.save(student);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}else {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
	}
	
	@PutMapping("/students/{rut}")
	public ResponseEntity<?> updateStudent(@PathVariable(value="rut")String rut, @RequestBody Student student) {
		log.info("controller CourseRestController - calling updateStudent method");
		Student studentDb = null;
		studentDb = studentService.findByRut(rut);
		if(studentDb != null) {
			studentDb.setName(student.getName());
			studentDb.setLastName(student.getLastName());
			studentDb.setAge(student.getAge());
			student.setCodeCourse(student.getCodeCourse());
			studentService.updateStudent(studentDb);
			return new ResponseEntity<>(studentDb, HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/students/{rut}")
	public ResponseEntity<Void> deleteCourse(@PathVariable(value="code")String rut) {
		log.info("controller CourseRestController - calling deleteCourse method");
		studentService.deleteStudent(rut);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
