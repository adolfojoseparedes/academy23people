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
import com.people23.academy.entity.Course;
import com.people23.academy.entity.Student;
import com.people23.academy.service.ICourseService;
import com.people23.academy.service.IStudentService;
import com.people23.academy.utils.IBaseValidations;
import lombok.extern.log4j.Log4j2;


/**
 * Class controller of MVC model for the API management students
 * 
 * @author 23 People Company
 *
 */
@RestController
@RequestMapping("/api")
@Log4j2
public class StudentRestController {

	@Autowired
	private IStudentService studentService;
	
	@Autowired
	private ICourseService courseService;
	
	@Autowired
	private IBaseValidations baseValidations;
	
	/**
    * Method exposed by the API to get student listings. It communicates with the service layer
    * @return List<Student> list of students
    */
	@GetMapping("/students")
	@ResponseStatus(HttpStatus.OK)
	public List<Student> getStudent() {
		log.info("controller StudentRestController - calling getStudents method");
		return studentService.findAll();
	}
	
	/**
    * Method exposed by the API to get a student for rut. It communicates with the service layer
    * @param rut @PathVariable student rut
    * @return ResponseEntity<?> response entity of the student and a HTTP default message
    */
	@GetMapping("/students/{rut}")
	public ResponseEntity<?> findStudent(@PathVariable(value="rut")String rut) {
		log.info("controller StudentRestController - calling findStudent method");
		Student studentDb = studentService.findByRut(rut);
		if (studentDb!=null) {
			return new ResponseEntity<>(studentDb, HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	/**
    * Method exposed by the API to save a student. It communicates with the service layer
    * @param student @RequestBody entity Student
    * @return ResponseEntity<Void> response entity that contain a HTTP default message
    */
	@PostMapping("/students")
	public ResponseEntity<?>addStudent(@RequestBody Student student) {
		log.info("controller StudentRestController - calling addStudent method");
		if (studentService.findStudent(student) == null) {
			baseValidations.validateObjectRut(student.getRut(),"Rut");
			baseValidations.validateObjectAge(student.getAge(),"Age");
			Course courseDb = courseService.findByCode(student.getCodeCourse());
			if (courseDb == null) {
				 return new ResponseEntity<>("Course does not exist", HttpStatus.NOT_FOUND);
			}
			studentService.save(student);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
	}
	
	/**
    * Method exposed by the API to update a student. It communicates with the service layer
    * @param rut @PathVariable student rut
    * @param student @RequestBody entity Student
    * @return ResponseEntity<?> response entity that contain a HTTP default message
    */
	@PutMapping("/students/{rut}")
	public ResponseEntity<?> updateStudent(@PathVariable(value="rut")String rut, @RequestBody Student student) {
		log.info("controller StudentRestController - calling updateStudent method");
		Student studentDb = null;
		baseValidations.validateObjectRut(rut,"Rut");
		studentDb = studentService.findByRut(rut);
		if (studentDb != null) {
			baseValidations.validateObjectRut(student.getRut(),"Rut");
			baseValidations.validateObjectAge(student.getAge(),"Age");
			studentDb.setName(student.getName());
			studentDb.setLastName(student.getLastName());
			studentDb.setAge(student.getAge());
			studentDb.setCodeCourse(student.getCodeCourse());
			studentService.updateStudent(studentDb);
			return new ResponseEntity<>(studentDb, HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	/**
    * Method exposed by the API to delete a student. It communicates with the service layer
    * @param rut @PathVariable student rut
    * @return ResponseEntity<Void> response entity that contain a HTTP default message
    */
	@DeleteMapping("/students/{rut}")
	public ResponseEntity<Void> deleteStudent(@PathVariable(value="rut")String rut) {
		log.info("controller StudentRestController - calling deleteStudent method");
		studentService.deleteStudent(rut);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
