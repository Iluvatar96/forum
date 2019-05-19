package com.Alpaca.forum.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.Alpaca.forum.entities.Group_Tag;

public interface Group_TagRepository extends JpaRepository<Group_Tag, Integer> {
	

//	
//	public Group_Tag findById(int theID);
//
//	public void updateGroup_Tag(Group_Tag theGroupTag);
//	public void addGroup_Tag(Group_Tag theGroupTag);
//	public void deleteByID(int theID);
//	public Group_Tag findByUsername(String username);
//	public Group_Tag findByEmail(String email);
}
