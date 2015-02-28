
import java.util.ArrayList;



/**
 * @author Mohamed
 * @version 1.0
 * @created 28-Feb-2015 11:17:21 AM
 */
public class CategoryDao {

	private static CategoryDao instance;



	public void finalize() throws Throwable {

	}

	private CategoryDao(){

	}

	/**
	 * 
	 * @param id
	 */
	public boolean deleteCategory(int id){
		return false;
	}

	/**
	 * 
	 * @param id
	 */
	public Category findCategory(int id){
		return null;
	}

	public ArrayList<Category> getCategories(){
		return null;
	}

	public static CategoryDao getInstance(){
		return null;
	}

	/**
	 * 
	 * @param name
	 */
	public boolean insertCategory(String name){
		return false;
	}

}