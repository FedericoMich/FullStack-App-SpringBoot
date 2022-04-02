package GitClass.BE;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import GitClass.BE.BEANS.User;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/user")

public class UserController {

	@Autowired
	private UserRepository ur;


	@GetMapping
	public ResponseEntity<List<User>> getAllUser(@RequestParam(required = false) String name) {
		try {
			List<User> user = new ArrayList<User>();
			if (name == null)
				ur.findAll().forEach(user::add);
			else
				ur.findByNameContaining(name).forEach(user::add);
			if (user.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
			return new ResponseEntity<>(user, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	@PostMapping("/addUser")
	public ResponseEntity<User> createCourse(@RequestBody User user) {
		try {
			ur.save(user);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}



}
