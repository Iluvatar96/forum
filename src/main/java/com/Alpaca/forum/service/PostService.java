package com.Alpaca.forum.service;

import java.util.List;



import com.Alpaca.forum.entities.DiscussionGroup;
import com.Alpaca.forum.entities.Post;
import com.Alpaca.forum.entities.User;


public interface PostService {

	public List<Post> findAll();

	public Post findById(int theId);

	public void save(Post thePost);

	public void deleteById(int theId);
	
	public	List<Post> findByDiscussionGroup(DiscussionGroup discussionGroup);
	
	public	List<Post>findAllByOrderByCreatedAtDesc();
	
	public	List<Post>findByUser(User user);

}
