package dao;

import bean.Category;
import bean.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDao {

    private static UserDao INSTANCE = new UserDao();

    private UserDao() {

    }

    /**
     *
     * @param email
     * @param status
     */
   public boolean changeStatus(String email, int status){
        Connection connection=null;
        boolean isChanged=false;
        try {
            
            connection=new DBConnection().getConnection();
            Statement statement=connection.createStatement();
                      //  String updateQuery = "update contact set pending=0 where contactId=" + item.getContactId() + " and userId=" + item.getUserId() + "";
            
            String updateQuery="update ecommerce.user set ecommerce.user.status="+status+" where ecommerce.user.email='"+email+"';";
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
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
        return isChanged;
    }

    /**
     *
     * @param email
     * @return
     */
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

    public static UserDao getInstance() {
        return INSTANCE;
    }

    /**
     *
     * @param user
     */
    public boolean insertUser(User user) {
        Connection connection = null;
        boolean isInserted = false;
        int rowaffected = 0;
        try {

            connection = new DBConnection().getConnection();

            PreparedStatement stmnt = connection.prepareStatement("INSERT INTO ecommerce.user (email,userbirthdate,name,address,job,role,user_password,status) VALUES (?,?,?,?,?,?,?,?)");
            stmnt.setString(1, user.getEmail());
            stmnt.setString(2, user.getBirthDate());
            stmnt.setString(3, user.getName());
            stmnt.setString(4, user.getAddress());
            stmnt.setString(5, user.getJob());
            stmnt.setInt(6, user.getRole());
            stmnt.setString(7, user.getPassword());
            stmnt.setInt(8, user.getStatus());
          //  stmnt.setDouble(9,user.getCredit());

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
                    Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

        return isInserted;
    }

    /**
     *
     * @param user
     */
             public boolean updateUser(User user) {
        Connection connection = null;
        int rowaffected = 0;
        boolean isUpdated = false;
        try {

            connection = new DBConnection().getConnection();
            String updatequery =" update ecommerce.user set name ='"+user.getName()+"' where email='"+user.getEmail()+"';";
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
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return isUpdated ;

    }
    
    
    

}
