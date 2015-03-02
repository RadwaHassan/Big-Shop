package dao;

import bean.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrderDao {

    private static OrderDao INSTANCE = new OrderDao();

    private OrderDao() {

    }

    public static OrderDao getInstance() {
        return INSTANCE;
    }

    public int getLastOrderId(){
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
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(OrderDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        }
        return lastOrderId;
    }

    /**
     *
     * @param String
     * @param order
     */
    public boolean insertOrder( Order order ,String email){
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
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(OrderDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

        return isInserted;
    }

}
