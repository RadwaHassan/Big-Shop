
import java.util.ArrayList;



/**
 * @author Mohamed
 * @version 1.0
 * @created 28-Feb-2015 11:29:04 AM
 */
public class ProductInformationController {

	private CategoryDao categoryDao;
	private static ProductInformationController instance;
	private ProductDao productDao;
	public CategoryDao m_CategoryDao;
	public ProductDao m_ProductDao;



	public void finalize() throws Throwable {

	}

	private ProductInformationController(){

	}

	public ArrayList<Category> getCategoriesWithProducts(){
		return null;
	}

	/**
	 * 
	 * @param id
	 */
	public Category getCategoryWithProducts(int id){
		return null;
	}

	public static ProductInformationController getInstance(){
		return null;
	}

	/**
	 * 
	 * @param code
	 */
	public Product getProductDetails(int code){
		return null;
	}

}