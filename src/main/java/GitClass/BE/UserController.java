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
	
	
	@GetMapping("/{id}")
	  public ResponseEntity<User> getUserById(@PathVariable("id") long id) {
	    Optional<User> userData = ur.findById(id);
	    if (userData.isPresent()) {
	      return new ResponseEntity<>(userData.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }


	@PostMapping("/addUser/{id}")
	public ResponseEntity<User> createUser(@RequestBody User user, @PathVariable Long id) {
		try {
			return new ResponseEntity<>(ur.save(user),HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@PutMapping("/updateUser/{id}")
	public ResponseEntity<User> updateCourse(@PathVariable("id") long id, @RequestBody User user) {
		Optional<User> userData = ur.findById(id);
		if (userData.isPresent()) {
			User _user = userData.get();
			_user.setName(user.getName());
			_user.setSurname(user.getSurname());
			_user.setRepos(user.getRepos());
			return new ResponseEntity<>(ur.save(_user), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable("id") long id) {
		try {
			ur.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
