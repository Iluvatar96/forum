package com.Alpaca.forum.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.Alpaca.forum.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	   User findByUsername(String username);
	    
	    User findByEmail(String email);





}
