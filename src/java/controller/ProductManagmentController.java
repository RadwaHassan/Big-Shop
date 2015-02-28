

/**
 * @author Mohamed
 * @version 1.0
 * @created 28-Feb-2015 11:30:21 AM
 */
public class ProductManagmentController {

	private static ProductManagmentController isntance ;
	private ProductDao productDao;
	public ProductDao m_ProductDao;



	public void finalize() throws Throwable {

	}

	private ProductManagmentController(){

	}

	/**
	 * 
	 * @param product
	 */
	public boolean addNewProduct(Product product){
		return false;
	}

	public static ProductManagmentController getInstance(){
		return null;
	}

}