package com.Alpaca.forum.controllers;

import java.util.ArrayList;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;

import com.Alpaca.forum.entities.Tag;

import com.Alpaca.forum.service.TagService;


@Controller
@RequestMapping("/tagsOptions")
public class TagController {
	
	@Autowired
	private TagService tagService;
	
	
	
	@GetMapping("/tagList")
	public String listTags(Model theModel) {
		List<Tag> theTags = new ArrayList<Tag>();
		 theTags = tagService.findAll();
		
		
		theModel.addAttribute("tags",theTags);
		return "tagList";
		
	}
	
	@GetMapping("/newTag")
	public String newTag(Model theModel) {
		
		Tag tag = new Tag();
		theModel.addAttribute("tagForm", tag);
		
		return "createTag";
		
	}
	
	@PostMapping("/save")
	public String saveTag(@ModelAttribute("tagForm") Tag tag) {
		
		tagService.save(tag);
		
		return "redirect:/tagsOptions/tagList";
	}
	
	


	
}
