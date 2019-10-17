package services;

import models.User;

public interface UsersService {

	public boolean updateUsername(String currentUsername, String newUsername);
	public boolean updatePassword(String currentUsername, String newPassword);
	public User getUser(String username);
	
}
