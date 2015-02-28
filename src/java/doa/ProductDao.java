
import java.util.ArrayList;



/**
 * @author Mohamed
 * @version 1.0
 * @created 28-Feb-2015 11:17:02 AM
 */
public class ProductDao {

	private static ProductDao instance;
	public Product m_Product;



	public void finalize() throws Throwable {

	}

	private ProductDao(){

	}

	/**
	 * 
	 * @param code
	 */
	public boolean deleteProduct(int code){
		return false;
	}

	/**
	 * 
	 * @param code
	 */
	public Product findProduct(int code){
		return null;
	}

	public static ProductDao getInstance(){
		return null;
	}

	/**
	 * 
	 * @param categoryName
	 */
	public ArrayList<Product> getProductsByCategory(String categoryName){
		return null;
	}

	/**
	 * 
	 * @param product
	 */
	public boolean insertProduct(Product product){
		return false;
	}

	/**
	 * 
	 * @param product
	 */
	public boolean update(Product product){
		return false;
	}

}