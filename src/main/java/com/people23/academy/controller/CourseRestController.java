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
import com.people23.academy.service.ICourseService;
import lombok.extern.log4j.Log4j2;

/**
 * Class controller of MVC model for the API management courses
 * 
 * @author 23 People Company
 *
 */
@RestController
@RequestMapping("/api")
@Log4j2
public class CourseRestController {
	
	@Autowired
	private ICourseService courseService;
	
	/**
    * Method exposed by the API to get course listings. It communicates with the service layer
    * @return List<Course> list of courses
    */
	@GetMapping("/courses")
	@ResponseStatus(HttpStatus.OK)
	public List<Course> getCourse() {
		log.info("controller CourseRestController - calling getCourse method");
		return courseService.findAll();
	}
	
	/**
    * Method exposed by the API to get a course for code. It communicates with the service layer
    * @param String @PathVariable course code
    * @return ResponseEntity<?> response entity of the course and a HTTP default message
    */
	@GetMapping("/courses/{code}")
	public ResponseEntity<?> findCourse(@PathVariable(value="code")String code) {
		log.info("controller CourseRestController - calling findCourse method");
		Course courseDb = courseService.findByCode(code);
		if (courseDb!=null) {
			return new ResponseEntity<>(courseDb, HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	/**
    * Method exposed by the API to save a course. It communicates with the service layer
    * @param Course @RequestBody entity Course
    * @return ResponseEntity<Void> response entity that contain a HTTP default message
    */
	@PostMapping("/courses")
	public ResponseEntity<Void> addCourse(@RequestBody Course course) {
		log.info("controller CourseRestController - calling addCourse method");
		if (courseService.findCourse(course)==null) {
			courseService.save(course);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
	}
	
	/**
    * Method exposed by the API to update a course. It communicates with the service layer
    * @param String @PathVariable code of course
    * @param Course @RequestBody entity course
    * @return ResponseEntity<?> response entity that contain a HTTP default message
    */
	@PutMapping("/courses/{code}")
	public ResponseEntity<?> updateCourse(@PathVariable(value="code")String code, @RequestBody Course course) {
		log.info("controller CourseRestController - calling updateCourse method");
		Course courseDb = null;
		courseDb = courseService.findByCode(code);
		if (courseDb != null) {
			courseDb.setName(course.getName());
			courseService.updateCourse(courseDb);
			return new ResponseEntity<>(courseDb, HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	/**
    * Method exposed by the API to delete a course. It communicates with the service layer
    * @param String @PathVariable code of course
    * @return ResponseEntity<Void> response entity that contain a HTTP default message
    */
	@DeleteMapping("/courses/{code}")
	public ResponseEntity<Void> deleteCourse(@PathVariable(value="code")String code) {
		log.info("controller CourseRestController - calling deleteCourse method");
		if (courseService.findByCode(code)!=null) {
			courseService.deleteCourse(code);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
}
