package com.Alpaca.forum.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.Alpaca.forum.entities.Tag;
import com.Alpaca.forum.repository.TagRepository;

@Service
public class TagServieceImpl implements TagService{

	@Autowired
	private TagRepository tagRepository;
	
	@Override
	public List<Tag> findAll() {
		
		return tagRepository.findAll();
	}

	@Override
	public Tag findById(int theId) {
		
		Optional<Tag> result = tagRepository.findById(theId);
		
		Tag theTag = null;
		
		if (result.isPresent()) {
			theTag = result.get();
		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find post id - " + theId);
		}
		
		return theTag;
	}
	

	@Override
	public void save(Tag theTag) {
		
		tagRepository.save(theTag);
		
	}

	@Override
	public void deleteById(int theId) {
		
		tagRepository.deleteById(theId);
		
	}

}	
