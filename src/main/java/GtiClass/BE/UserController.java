package GtiClass.BE;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")

public class UserController {
	
	@Autowired
	private UserRepository ur;
	
	
	 @CrossOrigin
	@GetMapping
	public List<User> findAllUsers() {
	    return (List<User>) ur.findAll();
	}
	

	@CrossOrigin
	@PostMapping ("/addStudent")
	ResponseEntity<String> saveUser(@Validated @RequestBody User user) {
		ur.save(user);
		return null;
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<User> findUserById(@PathVariable(value = "id") long id) {
	    Optional<User> user = ur.findById(id);

	    if(user.isPresent()) {
	        return ResponseEntity.ok().body(user.get());
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
	
	@GetMapping("/hello")
	ResponseEntity<String> hello() {
	    return ResponseEntity.ok("Hello World!");
	}
	

	


	 
	 
	 
	 
	 
	 
	 
	 
}
