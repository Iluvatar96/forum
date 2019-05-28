package com.Alpaca.forum.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Alpaca.forum.entities.DiscussionGroup;


import com.Alpaca.forum.entities.User;

@Repository
public interface DiscussionGroupRepository extends JpaRepository<DiscussionGroup, Integer> {
	

	public List<DiscussionGroup> findByUser(User user);

	

	public List<DiscussionGroup> findByGroupName(String groupName);
	
	



	
	

}
