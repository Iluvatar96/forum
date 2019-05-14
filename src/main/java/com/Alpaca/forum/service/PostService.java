package com.Alpaca.forum.service;

import java.util.List;

import com.Alpaca.forum.entities.Post;

public interface PostService {
	
	
	public List<Post> findAll();
	
	public Post findById(int theId);
	
	public void save(Post thePost);
	
	public void deleteById(int theId);

}
