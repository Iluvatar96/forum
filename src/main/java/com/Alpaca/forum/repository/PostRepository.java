package com.Alpaca.forum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Alpaca.forum.entities.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {
		
//public  List<Post>findAll();
//	
//	public Post findById(int theID);
//
//	public void updatePost(Post thePost);
//	public void addPost(Post thePost);
//	public void deleteByID(int theID);
//	public Post findByUsername(String username);
//	public Post findByEmail(String email);
}
