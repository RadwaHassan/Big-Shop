package controller;

import bean.Product;
import dao.ProductDao;

public class ProductManagmentController {

	private static ProductManagmentController INSTANCE = new ProductManagmentController();
	private ProductDao productDao;
	
	private ProductManagmentController(){
            
            productDao = ProductDao.getInstance();
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

}