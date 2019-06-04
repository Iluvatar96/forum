package com.Alpaca.forum.service;

import java.util.List;



import com.Alpaca.forum.entities.User;


public interface UserService {
	
	
	List<User> findAll();
	
	User registerNewUserAccount(User user);

    User findOne(int id);

    User findByUsername(String username);

    User findByEmail(String email);

    User save(User user);

    void create(User user);

    void remove(int id);

    void remove(User user);

    void remove(User user,
        String password);
}
