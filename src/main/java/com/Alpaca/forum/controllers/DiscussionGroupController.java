package com.Alpaca.forum.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.Alpaca.forum.entities.DiscussionGroup;
import com.Alpaca.forum.service.DiscussionGroupService;
import com.Alpaca.forum.service.PostService;

@Controller
public class DiscussionGroupController {

	@Autowired
	private DiscussionGroupService discussionGroupService;
	
	
	@Autowired
	private PostService postService;
	
	
	@GetMapping("/groups")
	public String listGroups(Model model) {
		
		List<DiscussionGroup> theGroups = discussionGroupService.findAll();
		model.addAttribute("listOfGroups", theGroups);
		
		return "listOfGroups";
		
	}
	
}
