package com.Alpaca.forum.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Alpaca.forum.entities.DiscussionGroup;
import com.Alpaca.forum.entities.User;
import com.Alpaca.forum.repository.DiscussionGroupRepository;

@Service
public class DiscussionGroupServiceImpl implements DiscussionGroupService{

	
	@Autowired
	private DiscussionGroupRepository discussionGroupRepository;
	

	
	
	@Override
	public List<DiscussionGroup> findByUser(User user) {
		// TODO Auto-generated method stub
		return discussionGroupRepository.findByUser(user);
	}

	@Override
	public List<DiscussionGroup> findByGroupName(String groupName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DiscussionGroup> findAll() {
		// TODO Auto-generated method stub
		return discussionGroupRepository.findAll();
	}

	@Override
	public  DiscussionGroup findById(int theId) {
		Optional<DiscussionGroup> result = discussionGroupRepository.findById(theId);
		
		DiscussionGroup theGroup = null;
		
		if (result.isPresent()) {
			theGroup = result.get();
		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find discussionGroup id - " + theId);
		}
		
		return theGroup;
	}

	@Override
	public void save(DiscussionGroup theGroup) {
		
		discussionGroupRepository.save(theGroup);
		
	}

	@Override
	public void deleteById(int theId) {
		
		discussionGroupRepository.deleteById(theId);
		
	}

	@Override
	public void delete(DiscussionGroup disccussionGroup) {
		
		discussionGroupRepository.delete(disccussionGroup);
		
	}

	

}
