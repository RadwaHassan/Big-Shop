package doa;

import bean.Product;
import java.util.ArrayList;

public class ProductDao {

	private static ProductDao INSTANCE = new ProductDao();
	



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
		return INSTANCE;
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