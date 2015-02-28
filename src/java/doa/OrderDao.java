package doa;

import bean.Order;

public class OrderDao {

    private static OrderDao INSTANCE = new OrderDao();

    private OrderDao() {

    }

    public static OrderDao getInstance() {
        return INSTANCE;
    }

    public int getLastOrderId() {
        return 0;
    }

    /**
     *
     * @param String
     * @param order
     */
    public boolean insertOrder(String email, Order order) {
        return false;
    }

}
