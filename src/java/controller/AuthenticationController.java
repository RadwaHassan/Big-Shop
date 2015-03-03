package controller;

import bean.User;
import dao.UserDao;

public class AuthenticationController {

	private static AuthenticationController INSTANCE = new AuthenticationController();
	private UserDao userDao;
	
	public AuthenticationController(){
            
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
	public User signIn(String email){
	   UserDao userdao=UserDao .getInstance();
           User user=userdao.findUser(email);
           return user;
           
	}

	/**
	 * 
	 * @param username
	 */
	public boolean signOut(String email,int status){
		UserDao userDao=UserDao.getInstance();
               boolean isSignedOut= userDao.changeStatus(email, status);
               return isSignedOut;
                
	}

}