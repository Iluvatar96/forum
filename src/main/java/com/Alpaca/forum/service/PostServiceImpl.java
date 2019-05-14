package com.Alpaca.forum.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Alpaca.forum.entities.Post;
import com.Alpaca.forum.repository.PostRepository;


@Service
public class PostServiceImpl implements PostService {

	
	@Autowired
	PostRepository postRepository;
	
	@Override
	public List<Post> findAll() {
		// TODO Auto-generated method stub
		return postRepository.findAll();
	}

	@Override
	public Post findById(int theId) {
		Optional<Post> result = postRepository.findById(theId);
		
		Post thePost = null;
		
		if (result.isPresent()) {
			thePost = result.get();
		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find post id - " + theId);
		}
		
		return thePost;
	}

	@Override
	public void save(Post thePost) {
		
		postRepository.save(thePost);
	}

	@Override
	public void deleteById(int theId) {
		postRepository.deleteById(theId);
		
	}

}
