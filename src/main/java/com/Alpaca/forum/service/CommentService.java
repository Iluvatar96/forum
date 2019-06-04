package com.Alpaca.forum.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Alpaca.forum.entities.Comment;




@Service
public interface CommentService {
	
	public List<Comment> findAll();

	public Comment findById(int theId);

	public void save(Comment theComment);

	public void deleteById(int theId);

}
