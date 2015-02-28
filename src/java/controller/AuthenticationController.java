package controller;

import bean.User;
import dao.UserDao;

public class AuthenticationController {

	private static AuthenticationController INSTANCE = new AuthenticationController();
	private UserDao userDao;
	
	private AuthenticationController(){
            
            //get UserDao instance
            userDao = UserDao.getInstance();
	}

	public static AuthenticationController getInstance(){
		return INSTANCE;
	}

	/**
	 * 
	 * @param username
	 * @param Password
	 */
	public User signIn(String username, String Password){
		return null;
	}

	/**
	 * 
	 * @param username
	 */
	public boolean signOut(String username){
		return false;
	}

}