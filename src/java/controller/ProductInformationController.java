package controller;

import bean.Category;
import bean.Product;
import dao.CategoryDao;
import dao.ProductDao;
import java.util.ArrayList;

public class ProductInformationController {

    private CategoryDao categoryDao;
    private static ProductInformationController INSTANCE = new ProductInformationController();
    private ProductDao productDao;

    private ProductInformationController() {

        categoryDao = CategoryDao.getInstance();
        productDao = ProductDao.getInstance();
    }

    public static ProductInformationController getInstance() {
        return INSTANCE;
    }

    public ArrayList<Category> getCategories() {
        ArrayList<Category> categories = categoryDao.getCategories();
        return categories;
    }

    public ArrayList<Product> getProductsForCategory(String categoryname) {
        ArrayList<Product> products = productDao.getProductsByCategory(categoryname);
        return products;
    }

    /**
     *
     * @param code
     * @return Product Get product details from DB by it's code
     */
    public Product getProductDetails(int code) {

        // get froduct from DB by code
        Product product = productDao.findProduct(code);
        return product;
    }

}
