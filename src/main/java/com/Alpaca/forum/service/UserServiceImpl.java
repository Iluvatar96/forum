package com.Alpaca.forum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Alpaca.forum.dao.UserDAO;
import com.Alpaca.forum.entities.User;


@Service
public class UserServiceImpl implements UserService{
	
	private UserDAO userDAO;
	
	@Autowired
	 public UserServiceImpl(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	

	@Override
	@Transactional
	public List<User> findAll() {
		
		return userDAO.findAll();
	}

	@Override
	@Transactional
	public User findById(int theID) {
		// TODO Auto-generated method stub
		return userDAO.findById(theID);
	}

	@Override
	@Transactional
	public void updateUser(User theUser) {
		
		userDAO.updateUser(theUser);
		
	}

	@Override
	@Transactional
	public void addUser(User theUser) {
		
		userDAO.addUser(theUser);
		
	}

	@Override
	@Transactional
	public void deleteByID(int theID) {
		
		userDAO.deleteByID(theID);
		
	}

	@Override
	@Transactional
	public User findByUsername(String username) {
		
		return userDAO.findByUsername(username);
	}

	@Override
	@Transactional
	public User findByEmail(String email) {
		
		return userDAO.findByEmail(email);
	}

}
