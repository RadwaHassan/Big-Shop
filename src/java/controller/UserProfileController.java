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
            
            boolean flage=userDao.insertUser(user);
           
           
            System.out.println("flage is" + flage);
		return  flage;
           
	}

	/**
	 * 
	 * @param user
	 */
	public boolean updateProfile(User user){
            userDao.updateUser(user);
		return userDao.updateUser(user);
	}
       

}