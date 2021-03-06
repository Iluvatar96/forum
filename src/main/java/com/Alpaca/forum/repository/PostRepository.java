package com.Alpaca.forum.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Alpaca.forum.entities.DiscussionGroup;
import com.Alpaca.forum.entities.Post;
import com.Alpaca.forum.entities.User;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
	
	List<Post> findByDiscussionGroup(DiscussionGroup discussionGroup);
	List<Post>findAllByOrderByCreatedAtDesc();
	List<Post>findByUser(User user);

}
