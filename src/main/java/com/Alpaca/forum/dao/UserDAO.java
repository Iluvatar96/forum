package com.Alpaca.forum.dao;

import java.util.List;

import com.Alpaca.forum.entities.User;

public interface UserDAO {
	
	
	public  List<User>findAll();
	
	public User findById(int theID);
	public void save(User theUser);
	public void deleteByID(int theID);

}
