package services.impl;

import data.Session;
import models.User;
import services.UsersService;

public class UsersServiceImpl implements UsersService {

	@Override
	public boolean updateUsername(String currentUsername, String newUsername) {
		User user = getUser(currentUsername);
		if(user != null) {
			user.setUsername(newUsername);
			return true;
		}
		return false;
	}

	@Override
	public boolean updatePassword(String currentUsername, String newPassword) {
		User user = getUser(currentUsername);
		if(user != null) {
			user.setPassword(newPassword);
			return true;
		}
		return false;
	}
	
	@Override
	public User getUser(String username) {
		for(User user : Session.getUsers()) {
			if(user.getUsername().equals(username)) {
				return user;
			}
		}
		return null;
	}

}
