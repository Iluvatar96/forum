package com.Alpaca.forum.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Alpaca.forum.entities.User;
import com.Alpaca.forum.service.UserService;





@RestController
@RequestMapping("/api")
public class UserController {
	
	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/users")
	public List<User> findAll(){
		return userService.findAll();
		
	}
	@GetMapping("/users/{user_id}")
	public User getUser(@PathVariable int user_id){
		User theUser = userService.findOne(user_id);
		
		if(theUser == null) throw new RuntimeException("User id not found:  "  + user_id);
		
		return theUser;
		
	}
	
}
