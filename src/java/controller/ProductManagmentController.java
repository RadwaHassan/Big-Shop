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
		
            boolean inserted = productDao.insertProduct(product);
            
            return inserted;
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
        
        public boolean deleteProduct(int code){
            
            //delete product
            boolean deleted = productDao.deleteProduct(code);
            
            return deleted;
        }
        
        public boolean updateProduct(Product product){
            
            // update product
            boolean updated = productDao.updateProduct(product);
            
            return updated;
        }

}