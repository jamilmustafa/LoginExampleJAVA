package services.impl;

import data.Session;
import models.User;
import services.AuthenticationService;
import services.UsersService;

public class AuthenticationServiceImpl implements AuthenticationService {
	
	private UsersService usersService;
	
	public AuthenticationServiceImpl() {
		this.usersService = new UsersServiceImpl();
	}

	@Override
	public boolean login(String username, String password) {
		User user = usersService.getUser(username);
		if(user != null && user.getPassword().equals(password)) {
			Session.setSession(true);
			return true;
		}
		return false;
	}
	
	@Override
	public void logout() {
		Session.setSession(false);
	}
	
	@Override
	public boolean isOpenSession() {
		return Session.isOpenSession();
	}
	
}
