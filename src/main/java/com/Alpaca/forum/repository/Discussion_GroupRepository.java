package com.Alpaca.forum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Alpaca.forum.entities.Discussion_Group;
import com.Alpaca.forum.entities.Moderator;
import com.Alpaca.forum.entities.Tag;
import com.Alpaca.forum.entities.User;


public interface Discussion_GroupRepository extends JpaRepository<Discussion_Group, Integer> {
	
//	public  List<Discussion_Group>findAll();
//	public List<Discussion_Group> findByUser(User user);
//	public List<Discussion_Group> findRecent();
//	public List<Discussion_Group> findByTags(Tag tag);
//	
//	public Discussion_Group findById(int theID);
//	public Discussion_Group findByName(String theName);
//	public Discussion_Group findByModerator(Moderator theModerator);
//	
//	public void updateDiscussion_Group(Discussion_Group theGroup);
//	public void addDiscussion_Group(Discussion_Group theGroup);
//	public void deleteByID(int theID);
//	public void delete(Discussion_Group discussion_Group);
	
	

}
