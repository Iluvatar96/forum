package com.Alpaca.forum.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.Alpaca.forum.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	   User findByUsername(String username);
	    
	    User findByEmail(String email);
//	public  List<User>findAll();
//	
//	public User findById(int theID);
//
//	public void updateUser(User theUser);
//	public void addUser(User theUser);
//	public void deleteByID(int theID);
//	public User findByUsername(String username);
//	public User findByEmail(String email);

}
