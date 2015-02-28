package controller;

import bean.User;
import dao.UserDao;

public class UserProfileController {

	private static UserProfileController INSTANCE = new UserProfileController();
	private UserDao userDao;

	private UserProfileController(){
            userDao = UserDao.getInstance();
	}

	public static UserProfileController getInstance(){
		return INSTANCE;
	}

	/**
	 * 
	 * @param user
	 */
	public boolean signUP(User user){
		return false;
	}

	/**
	 * 
	 * @param user
	 */
	public boolean updateProfile(User user){
		return false;
	}

}