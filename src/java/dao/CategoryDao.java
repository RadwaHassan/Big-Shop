package dao;

import bean.Category;
import bean.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CategoryDao {

    private static CategoryDao INSTANCE = new CategoryDao();

    private CategoryDao() {

    }

    /**
     *
     * @param id
     */
    public boolean deleteCategory(int id) {
        Connection connection = null;
        int rowaffected = 0;
        boolean isDeleted = false;
        try {

            connection = new DBConnection().getConnection();
            Statement statement = connection.createStatement();
            rowaffected = statement.executeUpdate("DELETE FROM category WHERE cat_id = " + id);
            if (rowaffected > 0) {
                isDeleted = true;
            } else {
                isDeleted = false;
            }

            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }

        return isDeleted;
    }

    /**
     *
     * @param id
     */
    public Category findCategory(int id) {
        Connection connection = null;
        Category category = new Category();;
        try {

            connection = new DBConnection().getConnection();
            String searchSQL = "SELECT * FROM category WHERE cat_id= ?";
            PreparedStatement preparedStatement = connection.prepareStatement(searchSQL);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                category.setId(resultSet.getInt(1));
                category.setName(resultSet.getString(2));
            }
            resultSet.close();
            preparedStatement.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
        return category;
    }

    public ArrayList<Category> getCategories() {

        Connection connection = null;
        Category[] arr = null;
        ArrayList<Category> list = null;
        try {
            connection = new DBConnection().getConnection();
            list = new ArrayList<Category>();
            Category item;
            Statement stmnt = connection.createStatement();
            ResultSet rs = stmnt.executeQuery("SELECT * FROM category");
            while (rs.next()) {
                item = new Category();
                item.setId(rs.getInt(1));
                item.setName(rs.getString(2));

                list.add(item);
            }

            arr = new Category[list.size()];
            list.toArray(arr);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return list;
        }

    }

    public int[] getCategoriesIds() {

        Connection connection = null;
        Category[] arr = null;
        int[] cat_ids = null;
        try {
            connection = new DBConnection().getConnection();

            Category item;
            Statement stmnt = connection.createStatement();
            ResultSet rs = stmnt.executeQuery("SELECT cat_id FROM category");
            int i = 0;
            while (rs.next()) {
                cat_ids[i] = rs.getInt(1);
                i++;
            }

        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return cat_ids;
        }

    }

    public static CategoryDao getInstance() {
        return INSTANCE;
    }

    /**
     *
     * @param name
     */
    public boolean insertCategory(String name) {
        Connection connection = null;
        boolean isInserted = false;
        int rowaffected = 0;
        try {

            connection = new DBConnection().getConnection();

            PreparedStatement stmnt = connection.prepareStatement("INSERT INTO category (name) VALUES (?)");
            stmnt.setString(1, name);
            rowaffected = stmnt.executeUpdate();

            if (rowaffected > 0) {
                isInserted = true;
            } else {
                isInserted = false;
            }
            stmnt.close();

        } catch (SQLException ex) {
            Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

        return isInserted;
    }
    
    // added by eman
    public  int getNumberOfRows(){
           String myquery="";
           int count=0;
            
            try {
               Connection connection=null;
               connection=new DBConnection().getConnection();
               Statement statement=connection.createStatement();
               myquery="select * from category";
              // System.out.println("before while");
               ResultSet resultSet=statement.executeQuery(myquery);
                while (resultSet.next()) {
                      //System.out.println("inside while");
                    count ++;
                    
                    
                }
              
           } catch (SQLException ex) {
               Logger.getLogger(TestClass.class.getName()).log(Level.SEVERE, null, ex);
           }
           
           // System.out.println("inside method "+count);
            return count;
        }
}
