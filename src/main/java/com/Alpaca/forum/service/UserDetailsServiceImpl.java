package com.Alpaca.forum.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.Alpaca.forum.entities.User;

public class UserDetailsServiceImpl<GrantedAuthority> implements UserDetailsService {

	
	//  @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {        
//        return new HashSet<GrantedAuthority>();
//    }
		
	@Autowired 
	UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userService.findByUsername(username);
		
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		
		 for (Role role : user.getRoles()) {
	            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
	        }
	        org.springframework.security.core.userdetails.User userDetails = new org.springframework.security.core.userdetails.User(
	            user.getUsername(),
	            user.getPassword(),
	            user.isActive(),
	            true, true, true,
	            grantedAuthorities);

	        return userDetails;
	}

}
