/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Category;
import bean.Order;
import bean.OrderProduct;
import bean.Product;
import bean.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AmoOOOnA
 */
public class TestClass {

    public boolean updateUser(User user) throws SQLException {
        Connection connection = null;
        int rowaffected = 0;
        boolean isUpdated = false;
        try {

            connection = new DBConnection().getConnection();
            String updatequery = " update ecommerce.user set name ='" + user.getName() + "' where email='" + user.getEmail() + "';";
            Statement statement = connection.createStatement();
            rowaffected = statement.executeUpdate(updatequery);
            if (rowaffected > 0) {
                isUpdated = true;

            } else {
                isUpdated = false;
            }
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return isUpdated;

    }

    public User findUser(String email) {
        Connection connection = null;
        User user = new User();
        try {

            connection = new DBConnection().getConnection();
            String searchSQL = "SELECT * FROM ecommerce.user WHERE email= ?";
            PreparedStatement preparedStatement = connection.prepareStatement(searchSQL);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user.setEmail(resultSet.getString(1));
                user.setBirthDate(resultSet.getString(2));
                user.setName(resultSet.getString(3));
                user.setAddress(resultSet.getString(4));
                user.setJob(resultSet.getString(5));
                user.setRole(resultSet.getInt(6));
                user.setStatus(resultSet.getInt(7));

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
                    Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
        return user;
    }

    public boolean update(Product product) {
        Connection connection = null;
        int rowaffected = 0;
        boolean isUpdated = false;
        try {

            connection = new DBConnection().getConnection();
            String updatequery = " update product set name='" + product.getName() + "'  , price=" + product.getPrice() + ",quantity=" + product.getQty() + ", image='" + product.getImagePath() + "' ,description='" + product.getDescription() + "'  where code=" + product.getCode() + ";";
            Statement statement = connection.createStatement();
            rowaffected = statement.executeUpdate(updatequery);
            if (rowaffected > 0) {
                isUpdated = true;

            } else {
                isUpdated = false;
            }
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return isUpdated;

    }

    public static void main(String[] args) {

        Product product = new Product();
        TestClass testClass = new TestClass();
        product.setCode(2);
        product.setName("laptop");
        product.setPrice(3000);
        product.setQty(3);
        product.setCatId(4);
        product.setImagePath("kj");
        product.setDescription("ghjk");
        OrderProduct orderProduct = new OrderProduct();
        orderProduct.setOrder(1);
        orderProduct.setProductCode(2);
        orderProduct.setQuantity(90);
        User u = new User();
        u.setName("ahmed");
        u.setEmail("eman@yahoo");
        System.out.println("" + testClass.findUser("eman@yahoo"));

    }
}
