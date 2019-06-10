package com.Alpaca.forum.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Alpaca.forum.entities.UserBan;


@Repository
public interface UserBanRepository extends JpaRepository<UserBan, Integer> {

//public  List<User_Ban>findAll();
	
//	public User_Ban findById(int theID);
//
//	public void updateTag(User_Ban theUserBan);
//	public void addTag(User_Ban theUserBan);
//	public void deleteByID(int theID);
//	public UserBan findByUsername(String username);
//	public UserBan findByEmail(String email);
}
