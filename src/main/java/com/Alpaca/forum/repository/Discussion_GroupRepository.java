package com.Alpaca.forum.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Alpaca.forum.entities.Discussion_Group;
import com.Alpaca.forum.entities.Moderator;
import com.Alpaca.forum.entities.Tag;
import com.Alpaca.forum.entities.User;


public interface Discussion_GroupRepository extends JpaRepository<Discussion_Group, Integer> {
	

	public List<Discussion_Group> findByUser(User user);
	public List<Discussion_Group> findRecent();
	public List<Discussion_Group> findByTags(Tag tag);
	

	public List<Discussion_Group> findByName(String theName);
	public Discussion_Group findByModerator(Moderator theModerator);
	



	
	

}
