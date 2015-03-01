/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AmoOOOnA
 */
public class DBConnection {
    
static String driver = "com.mysql.jdbc.Driver";
    static String url = "jdbc:mysql://localhost:3306/ecommerce";
    static String username = "root";
    static String password = "root";
    private Connection connection;

    public DBConnection() {
        try {
            Class.forName(driver).newInstance();
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception ex) {
			System.out.println("eman");
            ex.printStackTrace();
        }

    }

    public Connection getConnection() {
        return connection;
    }

    public void finalize() {
        try {
            if (connection != null) {
                this.connection.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
