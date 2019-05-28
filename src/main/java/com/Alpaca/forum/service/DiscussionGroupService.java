package com.Alpaca.forum.service;

import java.util.List;


import com.Alpaca.forum.entities.DiscussionGroup;

import com.Alpaca.forum.entities.User;


public interface DiscussionGroupService {
	
	public List<DiscussionGroup> findByUser(User user);
	
	public List<DiscussionGroup> findByGroupName(String groupName);
	
	public List<DiscussionGroup> findAll();

	public DiscussionGroup findById(int theId);

	public void save(DiscussionGroup thePost);

	public void deleteById(int theId);
	
	public void delete(DiscussionGroup disccussionGroup);
	
}
