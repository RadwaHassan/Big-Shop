

/**
 * @author Mohamed
 * @version 1.0
 * @created 28-Feb-2015 11:29:39 AM
 */
public class AuthenticationController {

	private static AuthenticationController instance;
	private UserDao UserDao;
	public UserDao m_UserDao;



	public void finalize() throws Throwable {

	}

	private AuthenticationController(){

	}

	public static AuthenticationController getInstance(){
		return null;
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