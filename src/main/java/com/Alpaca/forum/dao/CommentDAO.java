package com.Alpaca.forum.dao;

import java.util.List;

import com.Alpaca.forum.entities.Comment;


public interface CommentDAO {
	
	
	public  List<Comment>findAll();
	
	public Comment findById(int theID);

	public void updateComment(Comment theComment);
	public void addComment(Comment theComment);
	public void deleteByID(int theID);
	public Comment findByUsername(String username);
	public Comment findByEmail(String email);

	
}
