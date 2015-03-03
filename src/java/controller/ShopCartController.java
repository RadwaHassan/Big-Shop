package controller;

import bean.*;
import dao.OrderDao;
import dao.OrderProductDao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ShopCartController {

    private static ShopCartController INSTANCE = new ShopCartController();
    private OrderDao orderDao;
    private OrderProductDao orderProductDao;
    private Order order;
    private User user;
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
    public static ShopCartController getInstance() {
        return INSTANCE;
    }

    public Order createOrder(Product product, User user) {
        //first product in the order
        int counter = 0;
        if (this.user == null || !user.getEmail().equals(this.user.getEmail())) {
            this.user = user;
            //create new order
            orderId = orderDao.getLastOrderId();
            orderId++;
            //           orderId = 1;
            order = new Order();
            orderProduct = new OrderProduct();
            orderProduct.setOrder(orderId);
            orderProduct.setProductCode(product.getCode());
            orderProduct.setQuantity(1);
            order.setId(orderId);
            orderProductsArray = order.getProducts();
            if (orderProductsArray == null) {
                orderProductsArray = new ArrayList<OrderProduct>();
            }
            orderProductsArray.add(orderProduct);
            order.setProducts(orderProductsArray);
            order.setDate((new Date()).toString());
            order.setEmail(user.getEmail());
            //return orderId;
        } else {
            if (order == null || order.getId() == 0) {
                orderId = orderDao.getLastOrderId();
                orderId++;
//            orderId = 1;

                order = new Order();
                orderProduct = new OrderProduct();
                orderProduct.setOrder(orderId);
                orderProduct.setProductCode(product.getCode());
                orderProduct.setQuantity(1);
                order.setId(orderId);
                orderProductsArray = order.getProducts();
                if (orderProductsArray == null) {
                    orderProductsArray = new ArrayList<OrderProduct>();
                }
                orderProductsArray.add(orderProduct);
                order.setProducts(orderProductsArray);
                order.setDate((new Date()).toString());
                order.setEmail(user.getEmail());

                //return orderId;
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
                    } else {
                        counter++;
                    }
                }
                //product doesn't exists in order
                if (counter == orderProductsArray.size()) {
                    orderProduct = new OrderProduct();
                    orderProduct.setOrder(orderId);
                    orderProduct.setProductCode(product.getCode());
                    orderProduct.setQuantity(1);
                    if (orderProductsArray == null) {
                        orderProductsArray = new ArrayList<OrderProduct>();
                    }
                    orderProductsArray.add(orderProduct);
                    order.setProducts(orderProductsArray);
                }

            }
        }
        return order;
    }

    public Map<Product, Integer> showProductsList(Order order) {

        orderProductsArray = order.getProducts();
        if (orderId == order.getId()) {
            productQuantityMap = new HashMap<Product, Integer>();
            for (int i = 0; i < orderProductsArray.size(); i++) {
                int productId = orderProductsArray.get(i).getProductCode();

                System.out.println("product id = " + productId);
                int productQuantity = orderProductsArray.get(i).getQuantity();
                ProductInformationController productInformationCont = ProductInformationController.getInstance();
                Product product = productInformationCont.getProductDetails(productId);
                productQuantityMap.put(product, productQuantity);
                
            }
            return productQuantityMap;
        }
        return null;
    }

    public String buyProducts(Order order, User user) {
        double total_price = 0;
        //find if there is an order made with this id
        //order exists
        if (order != null) {
            orderProductsArray = order.getProducts();
            //get total price of order
            for (int i = 0; i < orderProductsArray.size(); i++) {
                int productid = orderProductsArray.get(i).getProductCode();
                Product product = ProductInformationController.getInstance().getProductDetails(productid);
                total_price = total_price + product.getPrice();
            }

            //check for user credit is more or less than price
            if (user.getCredit() >= total_price) {
                try {
                    //insert order in database
                    boolean order_inserted = orderDao.insertOrder(order, user.getEmail());
                    System.out.println("insert in order table = " + order_inserted);
                    if (order_inserted) {

                        //loop for orderProducts and insert them in database
                        boolean order_products_inserted = false;
                        for (int i = 0; i < orderProductsArray.size(); i++) {
                            order_products_inserted = orderProductDao.insertOrderProduct(orderProductsArray.get(i));
                            System.out.println("insert in order_product table = " + order_products_inserted);
                        }
                        if (order_products_inserted){
                            if (productQuantityMap != null){
                                productQuantityMap.clear();
                            }
                            return total_price + "";
                        }

                    }

                } catch (SQLException ex) {
                    Logger.getLogger(ShopCartController.class.getName()).log(Level.SEVERE, null, ex);
                }

            } //credit not enought
            else {
                return 0+"";
            }
        } //order = null
        else {
            return null;
        }
        return null;
    }
}
