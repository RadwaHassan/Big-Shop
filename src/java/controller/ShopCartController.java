package controller;

import bean.OrderProduct;
import doa.OrderDao;
import doa.OrderProductDao;
import java.util.ArrayList;

public class ShopCartController {

    private static ShopCartController INSTANCE = new ShopCartController();
    private OrderDao orderDao;
    private OrderProductDao orderProductDao;

    private ShopCartController() {
        
        orderDao = OrderDao.getInstance();
        orderProductDao = OrderProductDao.getInstance();
    }

    /**
     *
     * @param orderProducts
     */
    public boolean buyOrder(ArrayList<OrderProduct> orderProducts) {
        return false;
    }

    public static ShopCartController getInstance() {
        return INSTANCE;
    }

}
