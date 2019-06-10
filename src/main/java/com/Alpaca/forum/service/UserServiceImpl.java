package com.Alpaca.forum.service;


import java.util.HashSet;
import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import com.Alpaca.forum.entities.User;
import com.Alpaca.forum.repository.RoleRepository;
import com.Alpaca.forum.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
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
       
        return user;
	}

	@Override
	public User findByEmail(String email) {
		
		return userRepository.findByEmail(email);
	}

	@Override
	public User save(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRoles(new HashSet<>(roleRepository.findAll()));
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

	
