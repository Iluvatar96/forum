package com.Alpaca.forum.dao;

import java.util.List;


import com.Alpaca.forum.entities.Subscription;

public interface SubscriptionDAO {
	
public  List<Subscription>findAll();
	
	public Subscription findById(int theID);

	public void updateSubscryption(Subscription theSubscryption);
	public void addSubscryption(Subscription theSubscryption);
	public void deleteByID(int theID);
	public Subscription findByUsername(String username);
	public Subscription findByEmail(String email);
}
