package com.Alpaca.forum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Alpaca.forum.entities.Tag;


public interface TagRepository extends JpaRepository<Tag, Integer>{
	
	
//public  List<Tag>findAll();
//	
//	public Tag findById(int theID);
//
//	public void updateTag(Tag theTag);
//	public void addTag(Tag theTag);
//	public void deleteByID(int theID);
//	public Tag findByUsername(String username);
//	public Tag findByEmail(String email);
}
