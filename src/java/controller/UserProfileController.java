

/**
 * @author Mohamed
 * @version 1.0
 * @created 28-Feb-2015 11:29:51 AM
 */
public class UserProfileController {

	private static UserProfileController instance;
	private UserDao userDao;
	public UserDao m_UserDao;



	public void finalize() throws Throwable {

	}

	private UserProfileController(){

	}

	public static UserProfileController getInstance(){
		return null;
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