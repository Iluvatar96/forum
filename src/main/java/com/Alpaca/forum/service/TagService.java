package com.Alpaca.forum.service;

import java.util.List;


import com.Alpaca.forum.entities.Tag;

public interface TagService {
	
	
	public List<Tag> findAll();

	public Tag findById(int theId);

	public void save(Tag theTag);

	public void deleteById(int theId);
}
