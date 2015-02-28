package controller;

import bean.*;
import dao.OrderDao;
import dao.OrderProductDao;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ShopCartController {

    private static ShopCartController INSTANCE = new ShopCartController();
    private OrderDao orderDao;
    private OrderProductDao orderProductDao;
    private Order order;
    private OrderProduct orderProduct;
    private int orderId;
    private ArrayList<OrderProduct> orderProductsArray;
    private Map<Product, Integer> productQuantityMap;

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

    public int createOrder(Product product, User user) {
        //first product in the order
        if (order == null || order.getId() == 0) {
            orderId = orderDao.getLastOrderId();
            orderId++;
            order = new Order();
            orderProduct = new OrderProduct();
            orderProduct.setOrder(orderId);
            orderProduct.setProductCode(product.getCode());
            orderProduct.setQuantity(1);
            order.setId(orderId);
            orderProductsArray = order.getProducts();
            orderProductsArray.add(orderProduct);
            order.setProducts(orderProductsArray);
            order.setDate(new Date());
            order.setEmail(user.getEmail());
            return orderId;
        } //order already exists and has products in it
        else {

            //check if same product exists in the order
            orderProductsArray = order.getProducts();
            for (int i = 0; i < orderProductsArray.size(); i++) {
                //product exists already in the order .. increment the quantity of specifed product
                if (product.getCode() == orderProductsArray.get(i).getProductCode()) {
                    int quantity = orderProductsArray.get(i).getQuantity();
                    quantity++;
                    orderProductsArray.get(i).setQuantity(quantity);
                } //product doesn't exists in order
                else {
                    orderProduct = new OrderProduct();
                    orderProduct.setOrder(orderId);
                    orderProduct.setProductCode(product.getCode());
                    orderProduct.setQuantity(1);
                    orderProductsArray.add(orderProduct);
                    order.setProducts(orderProductsArray);
                }
            }
        }
        return 0;
    }

    public Map<Product, Integer> showProductsList(int orderId) {

        orderProductsArray = order.getProducts();
        if (orderId == order.getId()) {
            productQuantityMap = new HashMap<Product, Integer>();
            for (int i = 0; i < orderProductsArray.size(); i++) {
                int productId = orderProductsArray.get(i).getProductCode();
                int productQuantity = orderProductsArray.get(i).getQuantity();
                ProductInformationController productInformationCont = ProductInformationController.getInstance();
                Product product = productInformationCont.getProductDetails(productId);
                productQuantityMap.put(product, productQuantity);

            }
            return productQuantityMap;
        }
        return null;
    }
}
