package com.Alpaca.forum.dao;

import java.util.List;


import com.Alpaca.forum.entities.Group_Tag;

public interface Group_TagDAO {
	
public  List<Group_Tag>findAll();
	
	public Group_Tag findById(int theID);

	public void updateGroup_Tag(Group_Tag theGroupTag);
	public void addGroup_Tag(Group_Tag theGroupTag);
	public void deleteByID(int theID);
	public Group_Tag findByUsername(String username);
	public Group_Tag findByEmail(String email);
}
