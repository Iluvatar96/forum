package com.Alpaca.forum.dao;

import java.util.List;


import com.Alpaca.forum.entities.Tag;

public interface TagDAO {
	
	
public  List<Tag>findAll();
	
	public Tag findById(int theID);

	public void updateTag(Tag theTag);
	public void addTag(Tag theTag);
	public void deleteByID(int theID);
	public Tag findByUsername(String username);
	public Tag findByEmail(String email);
}
