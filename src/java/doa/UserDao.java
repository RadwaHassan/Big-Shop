

/**
 * @author Mohamed
 * @version 1.0
 * @created 28-Feb-2015 11:17:32 AM
 */
public class UserDao {

	private static UserDao instance;



	public void finalize() throws Throwable {

	}

	private UserDao(){

	}

	/**
	 * 
	 * @param email
	 * @param status
	 */
	public boolean changeStatus(String email, int status){
		return false;
	}

	/**
	 * 
	 * @param email
	 */
	public User findUser(String email){
		return null;
	}

	public static UserDao getInstance(){
		return null;
	}

	/**
	 * 
	 * @param user
	 */
	public boolean insertUser(User user){
		return false;
	}

	/**
	 * 
	 * @param user
	 */
	public boolean updateUser(User user){
		return false;
	}

}