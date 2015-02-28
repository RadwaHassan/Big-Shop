

/**
 * @author Mohamed
 * @version 1.0
 * @created 28-Feb-2015 11:17:48 AM
 */
public class OrderDao {

	private static OrderDao Instance;



	public void finalize() throws Throwable {

	}

	private OrderDao(){

	}

	public static OrderDao getInstance(){
		return null;
	}

	public int getLastOrderId(){
		return 0;
	}

	/**
	 * 
	 * @param String
	 * @param order
	 */
	public boolean insertOrder(String email, Order order){
		return false;
	}

}