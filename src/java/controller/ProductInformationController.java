package controller;

import bean.Category;
import bean.Product;
import doa.CategoryDao;
import doa.ProductDao;
import java.util.ArrayList;

public class ProductInformationController {

    private CategoryDao categoryDao;
    private static ProductInformationController INSTANCE = new ProductInformationController();
    private ProductDao productDao;

    private ProductInformationController() {

        categoryDao = CategoryDao.getInstance();
        productDao = ProductDao.getInstance();
    }

    public ArrayList<Category> getCategoriesWithProducts() {
        return null;
    }

    /**
     *
     * @param id
     */
    public Category getCategoryWithProducts(int id) {
        return null;
    }

    public static ProductInformationController getInstance() {
        return INSTANCE;
    }

    /**
     *
     * @param code
     */
    public Product getProductDetails(int code) {
        return null;
    }

}
