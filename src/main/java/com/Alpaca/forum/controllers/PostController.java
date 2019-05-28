package com.Alpaca.forum.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Alpaca.forum.entities.Post;

import com.Alpaca.forum.service.PostService;



@Controller
@RequestMapping("/posts")
public class PostController {

	
@Autowired
private PostService postService;




@GetMapping("/list")
public String listPosts(Model theModel) {
	
	List<Post> thePosts = postService.findAll();
	
	theModel.addAttribute("posts", thePosts);
	return "list-posts";
	
}


	
}
