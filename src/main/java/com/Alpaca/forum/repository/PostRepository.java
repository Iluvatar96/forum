package com.Alpaca.forum.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.Alpaca.forum.entities.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {
		

}
