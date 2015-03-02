package dao;

import bean.OrderProduct;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrderProductDao {

    private static OrderProductDao INSTANCE = new OrderProductDao();

    private OrderProductDao() {

    }

    public static OrderProductDao getInstance() {
        return INSTANCE;
    }

    /**
     *
     * @param orderProduct
     */
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
    }


