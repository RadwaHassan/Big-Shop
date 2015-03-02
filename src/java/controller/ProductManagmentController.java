package controller;

import bean.Product;
import dao.CategoryDao;
import dao.ProductDao;

public class ProductManagmentController {

	private static ProductManagmentController INSTANCE = new ProductManagmentController();
	private ProductDao productDao;
        private CategoryDao categoryDao;
	
	private ProductManagmentController(){
            
            productDao = ProductDao.getInstance();
            categoryDao = CategoryDao.getInstance();
	}

	/**
	 * 
	 * @param product
	 */
	public boolean addNewProduct(Product product){
		return false;
	}

	public static ProductManagmentController getInstance(){
		return INSTANCE;
	}
        
        public boolean addNewCategory(String name){
            
            // insuert category in DB
            boolean inserted = categoryDao.insertCategory(name);
            
            return inserted;
        }
        
        public boolean deleteCategory(int id){
            
            // delete category
            boolean deleted = categoryDao.deleteCategory(id);
            
            return deleted;
        }

}