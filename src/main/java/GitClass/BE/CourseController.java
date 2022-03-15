package GitClass.BE;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import GitClass.BE.BEANS.Course;


@RestController
@RequestMapping("/course")

public class CourseController {
	
	@Autowired
	private CourseRepository cr;
	
	
	 @CrossOrigin
	@GetMapping
	public List<Course> findAllCourse() {
	    return (List<Course>) cr.findAll();
	}
	

	@CrossOrigin
	@PostMapping ("/addCourse")
	ResponseEntity<String> saveCourse(@Validated @RequestBody Course course) {
		cr.save(course);
		return null;
	}

	
}
