package com.Alpaca.forum.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Alpaca.forum.entities.Comment;
import com.Alpaca.forum.entities.Post;
import com.Alpaca.forum.entities.User;


public interface CommentRepository extends JpaRepository<Comment, Integer> {
	
	List<Comment> findByUser(User user);
	List<Comment>findByOrderByCreated_atDESC(User user);
	List<Comment> findByPost(Post post);
	List<Comment>findByOrderByCreated_atDESC(Post post);

	

	
}
