package io.abhi.ctrlr;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.abhi.data.CustomResponse;
import io.abhi.data.User;

@RestController
public class UserRegistrationController {

	//private static final String URL_CROSS = "http://localhost:6060";

	//@CrossOrigin(origins=URL_CROSS)
	@GetMapping("/users")
	public List<User> getAllUsers() {
		return Arrays.asList(new User("abhi", "userabhi", "userpss", "abhi@test.com", 2323454),
				new User("ihba", "abhiuser", "pssuser", "test@abhi.com", 2323478));
	}

	@PostMapping("/user")
	public CustomResponse saveUserData(@RequestBody User newUser) {

		System.out.println("New user name:" + newUser.getName());
		return new CustomResponse("Successfully Registered");
	}

	@DeleteMapping("/user/{username}")
	public CustomResponse deleteUserData(@PathVariable String username) {
		System.out.println("Deleted :" + username);
		return new CustomResponse("Successfully deleted");
	}

	@PutMapping("/user")
	public CustomResponse updateUserData(@RequestBody User user) {
		System.out.println("Updated :" + user.getUsername());
		return new CustomResponse("Successfully updated");
	}
}