package com.Alpaca.forum.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.Alpaca.forum.entities.User_Ban;

public interface User_BanRepository extends JpaRepository<User_Ban, Integer> {

//public  List<User_Ban>findAll();
	
//	public User_Ban findById(int theID);
//
//	public void updateTag(User_Ban theUserBan);
//	public void addTag(User_Ban theUserBan);
//	public void deleteByID(int theID);
//	public User_Ban findByUsername(String username);
//	public User_Ban findByEmail(String email);
}
