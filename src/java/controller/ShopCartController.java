
import java.util.ArrayList;



/**
 * @author Mohamed
 * @version 1.0
 * @created 28-Feb-2015 11:29:30 AM
 */
public class ShopCartController {

	private static ShopCartController instance;
	private OrderDao orderDao;
	private OrderProductDao orderProductDao;
	public OrderDao m_OrderDao;
	public OrderProductDao m_OrderProductDao;



	public void finalize() throws Throwable {

	}

	private ShopCartController(){

	}

	/**
	 * 
	 * @param orderProducts
	 */
	public boolean buyOrder(ArrayList<OrderProduct> orderProducts){
		return false;
	}

	public static ShopCartController getInstance(){
		return null;
	}

	

}