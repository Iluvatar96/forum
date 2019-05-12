package com.Alpaca.forum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Alpaca.forum.entities.Subscription;

public interface SubscriptionRepository  extends JpaRepository<Subscription, Integer>{
	
//public  List<Subscription>findAll();
//	
//	public Subscription findById(int theID);
//
//	public void updateSubscryption(Subscription theSubscryption);
//	public void addSubscryption(Subscription theSubscryption);
//	public void deleteByID(int theID);
//	public Subscription findByUsername(String username);
//	public Subscription findByEmail(String email);
//
	}
