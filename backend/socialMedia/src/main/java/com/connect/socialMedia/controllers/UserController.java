package com.connect.socialMedia.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.connect.socialMedia.daos.UserDao;
import com.connect.socialMedia.entities.User;
import com.connect.socialMedia.services.UserServiceImpl;
import com.connect.socialMedia.utility.Credentials;
import com.connect.socialMedia.utility.Response;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user/")
public class UserController {

	@Autowired
	private UserServiceImpl userService;

	
//	private User user;

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("/login")
	public ResponseEntity<?> signIn(@Valid @RequestBody Credentials cred) {
		User user = userService.findUserByEmailAndPassword(cred);
		if (user == null)
			return Response.error("user not found");

		System.out.println(user);
		return Response.success(user);
	}

	@PostMapping("/register")
	public ResponseEntity<?> signUp(@RequestBody User user) {

		System.out.println("hello Nisha");
		User result = userService.saveUser(user);
		if (result == null) {

			return Response.error("Email already exists try to enter different Email");

		} else {
			User user1 = userService.findUserFromdbById(result.getId());
			User user2 = user;

			System.out.println(user2);
			user2.setPassword(user.getPassword());
			this.updateUserv1(user.getId(), user1);
		}
		return Response.success(result);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<User> updateUserv1(@PathVariable int id, @RequestBody User UserDetails) {
		User user = userService.findUserFromdbById(id);
		if (user == null) {
			return (ResponseEntity<User>) Response.error("User not exist with id :" + id);
		}
//					.orElseThrow(() -> new ResourceNotFoundException("User not exist with id :" + id));

		user.setUserName(UserDetails.getUserName());
		user.setEmail(UserDetails.getEmail());
		user.setMobileNo(UserDetails.getMobileNo());
		user.setPassword(UserDetails.getPassword());
		User updatedUser = userService.saveUser(user);
		return ResponseEntity.ok(updatedUser);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable int id) {
		User user = userService.findUserFromdbById(id);
		if (user == null) {
			return (ResponseEntity<Map<String, Boolean>>) Response.error("User not exist with id :" + id);
		}
//					.orElseThrow(() -> new ResourceNotFoundException("User not exist with id :" + id));

		userDao.delete(user);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
	@GetMapping("/search")
	public ResponseEntity<?> findUser() {
		List<User> result = new ArrayList<>();
		result = userService.findAllUsers();
		return Response.success(result);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable int id) {
		User user = userService.findUserFromdbById(id);

		if (user == null) {
			return (ResponseEntity<User>) Response.error("User not exist with id :" + id);
		}
//				.orElseThrow(() -> new ResourceNotFoundException("User not exist with id :" + id));
		return ResponseEntity.ok(user);
	}

}
