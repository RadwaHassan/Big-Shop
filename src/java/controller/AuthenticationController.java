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
        
	public boolean signIn(String email,String password){
	   UserDao userdao=UserDao .getInstance();
           boolean isFound=userdao.isUserFound(email,password);
           return isFound;
           
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
