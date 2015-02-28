package doa;

import bean.OrderProduct;

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
    public boolean insertOrderProduct(OrderProduct orderProduct) {
        return false;
    }

}
