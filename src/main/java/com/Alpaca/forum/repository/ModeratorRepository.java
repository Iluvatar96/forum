package com.Alpaca.forum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Alpaca.forum.entities.Moderator;

public interface ModeratorRepository extends JpaRepository<Moderator, Integer> {

//	public  List<Moderator>findAll();
//	
//	public Moderator findById(int theID);
//
//	public void updateGroup_Tag(Moderator theModerator);
//	public void addGroup_Tag(Moderator theModerator);
//	public void deleteByID(int theID);
//	public Moderator findByUsername(String username);
//	public Moderator findByEmail(String email);
}
