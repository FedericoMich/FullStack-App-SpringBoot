package GitClass.BE;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import GitClass.BE.BEANS.Course;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/course")

public class CourseController {
	
	@Autowired
	CourseRepository cr;


	@GetMapping
	public ResponseEntity<List<Course>> getAllCourse(@RequestParam(required = false) String name) {
		try {
			List<Course> course = new ArrayList<Course>();
			if (name == null)
				cr.findAll().forEach(course::add);
			else
				cr.findByNameContaining(name).forEach(course::add);
			if (course.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
			return new ResponseEntity<>(course, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping("/{id}")
	  public ResponseEntity<Course> getCourseById(@PathVariable("id") long id) {
	    Optional<Course> courseData = cr.findById(id);
	    if (courseData.isPresent()) {
	      return new ResponseEntity<>(courseData.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	

	@PostMapping("/addCourse")
	public ResponseEntity<Course> createCourse(@RequestBody Course course) {
		try {
			cr.save(course);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PutMapping("/updateCourse/{id}")
	public ResponseEntity<Course> updateCourse(@PathVariable("id") long id, @RequestBody Course course) {
		Optional<Course> courseData = cr.findById(id);
		if (courseData.isPresent()) {
			Course _course = courseData.get();
			_course.setName(course.getName());
			_course.setYear(course.getYear());
			return new ResponseEntity<>(cr.save(_course), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/deleteCourse/{id}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable("id") long id) {
		try {
			cr.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}





}
