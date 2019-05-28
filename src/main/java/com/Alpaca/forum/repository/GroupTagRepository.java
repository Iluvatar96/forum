package com.Alpaca.forum.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Alpaca.forum.entities.GroupTag;


@Repository
public interface GroupTagRepository extends JpaRepository<GroupTag, Integer> {
	

//	
//	public Group_Tag findById(int theID);
//
//	public void updateGroup_Tag(Group_Tag theGroupTag);
//	public void addGroup_Tag(Group_Tag theGroupTag);
//	public void deleteByID(int theID);
//	public Group_Tag findByUsername(String username);
//	public Group_Tag findByEmail(String email);
}
