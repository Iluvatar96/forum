package com.Alpaca.forum.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.context.request.WebRequest;

import com.Alpaca.forum.entities.User;
import com.Alpaca.forum.service.SecurityService;
import com.Alpaca.forum.service.UserService;
import com.Alpaca.forum.validator.UserValidator;





@Controller
@RequestMapping("/api")
public class UserController {
	
	
	
	@Autowired
	private UserService userService;
	
	
	@Autowired
	private SecurityService securityService;
	
	
	@Autowired
	private UserValidator userValidator;
	
//	@Autowired
//	public UserController(UserService userService) {
//		this.userService = userService;
//	}
	
	@GetMapping("/signUp")
	public String signUp(Model model) {
		
		model.addAttribute("userForm", new User());
		return "signUp";
		
	}
	
	@PostMapping("/signUp")
	public String signUp(@ModelAttribute("userForm") User userForm, BindingResult bindingResult ) {
		
		userValidator.validate(userForm, bindingResult);
		
		if(bindingResult.hasErrors()) {
			return "signUp";
		}
		
		userService.save(userForm);
		
		securityService.autoLogin(userForm.getUsername(), userForm.getConfirmPassword());
		
		return "redirect:/";
		
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
	@GetMapping("/user/sign_up")
	public String showRegistrationForm(WebRequest request, Model model) {
	    User theUser = new User();
	    model.addAttribute("user", theUser);
	    return "sign_up";
	
}
}
