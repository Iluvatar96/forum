package com.Alpaca.forum.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Alpaca.forum.entities.Comment;
import com.Alpaca.forum.entities.Post;
import com.Alpaca.forum.entities.User;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
	
	List<Comment> findByUser(User user);
	List<Comment>findAllByOrderByCreatedAtDesc();
	List<Comment> findByPost(Post post);


	

	
}
