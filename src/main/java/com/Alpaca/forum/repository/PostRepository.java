package com.Alpaca.forum.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Alpaca.forum.entities.Discussion_Group;
import com.Alpaca.forum.entities.Post;
import com.Alpaca.forum.entities.User;

public interface PostRepository extends JpaRepository<Post, Integer> {
	
		List<Post> findByDiscussion_Groups(Discussion_Group discussion_Group);
		List<Post>findByOrderByCreated_atDESC(Discussion_Group discussion_Group);
		List<Post>findByUser(User user);
		List<Post>findByOrderByCreated_atDESC(User user);
}
