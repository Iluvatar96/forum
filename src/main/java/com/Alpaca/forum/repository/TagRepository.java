package com.Alpaca.forum.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Alpaca.forum.entities.Tag;

@Repository
public interface TagRepository extends JpaRepository<Tag, Integer>{
	
	



}
