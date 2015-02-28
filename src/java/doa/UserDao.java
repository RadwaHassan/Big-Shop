package doa;

import bean.User;

public class UserDao {

    private static UserDao INSTANCE = new UserDao();

    private UserDao() {

    }

    /**
     *
     * @param email
     * @param status
     */
    public boolean changeStatus(String email, int status) {
        return false;
    }

    /**
     *
     * @param email
     */
    public User findUser(String email) {
        return null;
    }

    public static UserDao getInstance() {
        return INSTANCE;
    }

    /**
     *
     * @param user
     */
    public boolean insertUser(User user) {
        return false;
    }

    /**
     *
     * @param user
     */
    public boolean updateUser(User user) {
        return false;
    }

}
