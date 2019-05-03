package com.Alpaca.forum.dao;

import java.util.List;


import com.Alpaca.forum.entities.Notification;

public interface NotificationDAO {
	
public  List<Notification>findAll();
	
	public Notification findById(int theID);

	public void updateNotification(Notification theNotification);
	public void addNotification(Notification theNotification);
	public void deleteByID(int theID);
	public Notification findByUsername(String username);
	public Notification findByEmail(String email);
}
