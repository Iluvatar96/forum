package com.Alpaca.forum.dao;

import java.util.List;


import com.Alpaca.forum.entities.Post;

public interface PostDAO {
		
public  List<Post>findAll();
	
	public Post findById(int theID);

	public void updatePost(Post thePost);
	public void addPost(Post thePost);
	public void deleteByID(int theID);
	public Post findByUsername(String username);
	public Post findByEmail(String email);
}
