package data;

import java.util.ArrayList;
import java.util.List;

import models.User;

public class Session {

	private static List<User> users;
	
	static {
		users = new ArrayList<User>();
		users.add(new User("admin", "admin"));
		users.add(new User("foo", "bar"));
	}
	
	private static boolean isOpenSession = false;
	
	public static List<User> getUsers() {
		return users;
	}
	
	public static boolean isOpenSession() {
		return isOpenSession;
	}
	
	public static void setSession(boolean session) {
		isOpenSession = session;
	}
	
}
