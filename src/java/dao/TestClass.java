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
    
     public User[] selectAll() throws SQLException {
        Connection connection = null;
        User[] arr = null;
        try {
            connection = new DBConnection().getConnection();
            ArrayList<User> list = new ArrayList<User>();
            User item;
            Statement stmnt = connection.createStatement();
            ResultSet rs = stmnt.executeQuery("SELECT * FROM user");
            while (rs.next()) {
                item = new User();
                item.setEmail(rs.getString(1));
                item.setName(rs.getString(3));
                item.setAddress(rs.getString(4));
                item.setJob(rs.getString(5));
                item.setRole(rs.getInt(6));
                
                list.add(item);
            }

            arr = new User[list.size()];
            list.toArray(arr);
        } finally {
            if (connection != null) {
                connection.close();
            }
            return arr;
        }

    }
     
     
      public boolean insertOrder( Order order ,String email) throws SQLException {
        Connection connection = null;
        boolean isInserted = false;
        int orderid=order.getId();
        String orderdate=order.getDate();
        int rowaffected = 0;
        try {

            connection = new DBConnection().getConnection();

            
             PreparedStatement stmnt = connection.prepareStatement("INSERT INTO ecommerce.order (id,orderdate,email) VALUES (?,?,?)");
            stmnt.setInt(1,orderid);
             stmnt.setString(2, orderdate);
            stmnt.setString(3, email);
            
            
             rowaffected=stmnt.executeUpdate();
                  
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

     

      
      

     
     public boolean insertCategory(String name) throws SQLException {
        Connection connection = null;
        boolean isInserted = false;
        int rowaffected = 0;
        try {

            connection = new DBConnection().getConnection();
            
            PreparedStatement stmnt=connection.prepareStatement("INSERT INTO category (name) VALUES (?)");
            stmnt.setString(1,name);
            rowaffected=stmnt.executeUpdate();
            
            
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
     
         public boolean changeStatus(String email, int status) throws SQLException {
        Connection connection=null;
        boolean isChanged=false;
        try {
            
            connection=new DBConnection().getConnection();
            Statement statement=connection.createStatement();
                      //  String updateQuery = "update contact set pending=0 where contactId=" + item.getContactId() + " and userId=" + item.getUserId() + "";

            String updateQuery="UPDATE ecommerce.user  SET ecommerce.user.status= "+status+ "where ecommerce.user.email="+email+"";
            int rowaffected=statement.executeUpdate(updateQuery);
            if (rowaffected >0) {
                isChanged=true;
                
            }else{
            isChanged=false;
            }
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if (connection != null) {
                connection.close();
                
            }
        }
        return isChanged;
    }

             public User findUser(String email) throws SQLException {
         Connection connection = null;
        User user = new User();;
        try {

            connection = new DBConnection().getConnection();
            String searchSQL = "SELECT * FROM ecommerce.user WHERE email= ?";
            PreparedStatement preparedStatement = connection.prepareStatement(searchSQL);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
               
                user.setBirthDate(resultSet.getString(2));
                user.setName(resultSet.getString(3));
                user .setAddress(resultSet.getString(4));
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
                connection.close();

            }
        }
        return user;
    }

        
             public boolean updateUser(User user) throws SQLException {
        Connection connection = null;
        int rowaffected = 0;
        boolean isUpdated = false;
        try {

            connection = new DBConnection().getConnection();
            String updatequery = "update ecommerce.user set name = " + user.getName() + "where email= " + user.getEmail() + "";
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
        }
        finally{
            if (connection !=null) {
                connection.close();
            }
        }
        return isUpdated ;

    }
             
             public boolean insertProduct(Product product) throws SQLException{
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
	
             
             public ArrayList<Product> getProductsByCategory(int categoryid) throws SQLException{
		   Connection connection = null;
        Product[] arr = null;
           ArrayList<Product> list=null;
        try {
            connection = new DBConnection().getConnection();
          list = new ArrayList<Product>();
            Product item;
            Statement stmnt = connection.createStatement();
            ResultSet rs = stmnt.executeQuery("SELECT * FROM product where cat_id = "+categoryid+"");
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
                connection.close();
            }
            return list;
        }

	}
             
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
             
             public boolean insertOrderProduct(OrderProduct orderProduct) throws SQLException {
        Connection connection = null;
        boolean isInserted = false;
        int rowaffected = 0;
        
        try {

            connection = new DBConnection().getConnection();

            PreparedStatement stmnt = connection.prepareStatement("INSERT INTO order_product (quantity,id,code) VALUES (?,?,?)");
            stmnt.setInt(1, orderProduct.getQuantity());
            stmnt.setInt(2, orderProduct.getOrder());
            stmnt.setInt(3, orderProduct.getProductCode());
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



    public int getLastOrderId() throws SQLException {
        Connection connection = null;
        int lastOrderId=0;
        try {
            
            connection=new DBConnection().getConnection();
            Statement statement=connection.createStatement();
            String sqlQuery="select max(id) from ecommerce.order ";
            ResultSet resultSet=statement.executeQuery(sqlQuery);
            if(resultSet.next()){
            lastOrderId=resultSet.getInt(1);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(OrderDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
        if(connection !=null){
        connection.close();
        }
        }
        return lastOrderId;

    }   
    public static void main(String[] args) {

         try {
             Product product =new Product();
             TestClass testClass=new TestClass();
             product.setCode(2);
             product.setName("laptop");
             product.setPrice(3000);
             product.setQty(3);
             product.setImagePath("kj");
             product.setDescription("ghjk");
             product.setCatId(1);
            // System.out.println(""+testClass.deleteProduct(1));
             OrderProduct orderProduct=new OrderProduct();
             orderProduct.setOrder(1);
             orderProduct.setProductCode(2);
             orderProduct.setQuantity(90);
             System.out.println(""+testClass.getLastOrderId());
         } catch (SQLException ex) {
             Logger.getLogger(TestClass.class.getName()).log(Level.SEVERE, null, ex);
         }
             
        
    }
}
