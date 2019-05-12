package com.Alpaca.forum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Alpaca.forum.entities.Comment;


public interface CommentRepository extends JpaRepository<Comment, Integer> {
	
//	
//	public  List<Comment>findAll();
//	
//	public Comment findById(int theID);
//
//	public void updateComment(Comment theComment);
//	public void addComment(Comment theComment);
//	public void deleteByID(int theID);
//	public Comment findByUsername(String username);
//	public Comment findByEmail(String email);

	
}
