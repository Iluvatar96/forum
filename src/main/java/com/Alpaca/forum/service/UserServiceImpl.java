package com.Alpaca.forum.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import com.Alpaca.forum.entities.User;
import com.Alpaca.forum.exception.UserNotFoundException;
import com.Alpaca.forum.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> findAll() {
	
		return userRepository.findAll();
	}

	@Override
	public User findOne(int id) {
	
		return userRepository.getOne(id);
	}

	@Override
	public User findByUsername(String username) {
		User user = userRepository.findByUsername(username);
        if (user == null) {
            throw  new UserNotFoundException();
        }
        return user;
	}

	@Override
	public User findByEmail(String email) {
		
		return userRepository.findByEmail(email);
	}

	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public void create(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(int id) {
		
		remove(findOne(id));
		
	}

	@Override
	public void remove(User user) {
		
		userRepository.delete(user);
		
	}

	@Override
	public void remove(User user, String password) {
		
		
		
	}
	

}

	
