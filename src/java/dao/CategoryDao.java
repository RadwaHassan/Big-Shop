package dao;

import bean.Category;
import java.util.ArrayList;

public class CategoryDao {

    private static CategoryDao INSTANCE = new CategoryDao();

    private CategoryDao() {

    }

    /**
     *
     * @param id
     */
    public boolean deleteCategory(int id) {
        return false;
    }

    /**
     *
     * @param id
     */
    public Category findCategory(int id) {
        return null;
    }

    public ArrayList<Category> getCategories() {
        return null;
    }

    public static CategoryDao getInstance() {
        return INSTANCE;
    }

    /**
     *
     * @param name
     */
    public boolean insertCategory(String name) {
        return false;
    }

}
