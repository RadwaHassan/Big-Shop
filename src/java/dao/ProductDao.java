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

public class ProductDao {

    private static ProductDao INSTANCE = new ProductDao();

    public void finalize() throws Throwable {

    }

    private ProductDao() {

    }

    /**
     *
     * @param code
     */
    public boolean deleteProduct(int code) throws SQLException {

        Connection connection = null;
        boolean isDeleted = false;
        try {

            connection = new DBConnection().getConnection();
            Statement stmnt = connection.createStatement();
            int rowsAffected = stmnt.executeUpdate("DELETE FROM product WHERE code = " + code + "");
            stmnt.close();
            if (rowsAffected > 0) {
                isDeleted = true;
            } else {
                isDeleted = false;
            }

        } finally {
            if (connection != null) {
                connection.close();
            }
        }

        return isDeleted;
    }

    /**
     *
     * @param code
     */
    public Product findProduct(int code){
        Connection connection = null;
        Product product = new Product();;
        try {

            connection = new DBConnection().getConnection();
            String searchSQL = "SELECT * FROM product WHERE code= ?";
            PreparedStatement preparedStatement = connection.prepareStatement(searchSQL);
            preparedStatement.setInt(1, code);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                product.setName(resultSet.getString(2));
                product.setPrice(resultSet.getDouble(3));

                product.setQty(resultSet.getInt(4));
                product.setImagePath(resultSet.getString(5));
                product.setDescription(resultSet.getString(6));
                product.setCatId(resultSet.getInt(7));

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
                    Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
        return product;
    }

    public static ProductDao getInstance() {
        return INSTANCE;
    }

    /**
     *
     * @param categoryName
     */
    public ArrayList<Product> getProductsByCategory(int categoryid){
        Connection connection = null;
        Product[] arr = null;
        ArrayList<Product> list = null;
        try {
            connection = new DBConnection().getConnection();
            list = new ArrayList<Product>();
            Product item;
            Statement stmnt = connection.createStatement();
            ResultSet rs = stmnt.executeQuery("SELECT * FROM product where cat_id = " + categoryid + "");
            while (rs.next()) {
                item = new Product();
                item.setCode(rs.getInt(1));
                item.setName(rs.getString(2));
                item.setPrice(rs.getDouble(3));
                item.setQty(rs.getInt(4));
                item.setImagePath(rs.getString(5));
                item.setDescription(rs.getString(6));
                item.setCatId(rs.getInt(7));

                list.add(item);
            }

        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return list;
        }

    }

    /**
     *
     * @param product
     */
    public boolean insertProduct(Product product) throws SQLException {
        Connection connection = null;
        boolean isInserted = false;
        int rowaffected = 0;
        try {

            connection = new DBConnection().getConnection();

            PreparedStatement stmnt = connection.prepareStatement("INSERT INTO product (code,name,price,quantity,image,description,cat_id) VALUES (?,?,?,?,?,?,?)");
            stmnt.setInt(1, product.getCode());
            stmnt.setString(2, product.getName());
            stmnt.setDouble(3, product.getPrice());
            stmnt.setInt(4, product.getQty());
            stmnt.setString(5, product.getImagePath());
            stmnt.setString(6, product.getDescription());
            stmnt.setInt(7, product.getCatId());

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
                connection.close();
            }

        }

        return isInserted;
    }

    /**
     *
     * @param product
     */
    public boolean update(Product product) {
        return false;
    }

}
