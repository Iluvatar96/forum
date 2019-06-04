package com.Alpaca.forum.service;



public interface SecurityService {
	String findLoggedInUsername();
	
	
	void autoLogin(String username, String password);
}
