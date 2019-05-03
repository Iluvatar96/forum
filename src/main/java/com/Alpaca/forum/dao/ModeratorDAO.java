package com.Alpaca.forum.dao;

import java.util.List;


import com.Alpaca.forum.entities.Moderator;

public interface ModeratorDAO {

	public  List<Moderator>findAll();
	
	public Moderator findById(int theID);

	public void updateGroup_Tag(Moderator theModerator);
	public void addGroup_Tag(Moderator theModerator);
	public void deleteByID(int theID);
	public Moderator findByUsername(String username);
	public Moderator findByEmail(String email);
}
