/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import bean.*;
import controller.ProductInformationController;
import controller.ShopCartController;
import dao.ProductDao;
import dao.UserDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author yomna
 */
public class ShoppingCartDetailsServlet extends HttpServlet {

    private Product product;
    private Order order;
    private User user;
    private ProductDao productDao;
    private int orderid;
    private HttpSession session;
    private ArrayList<OrderProduct> orderProductsArray;
    private Map<Product, Integer> productQuantityMap = null;
    private ShopCartController shopCartController;
    private boolean buy = false;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        shopCartController = ShopCartController.getInstance();
        productDao = ProductDao.getInstance();
        //check for id in url
        String productid = request.getParameter("productid");
        String showProducts = request.getParameter("showproducts");
        String buyProducts = request.getParameter("buyproducts");
        String deleteProduct = request.getParameter("deleteproduct");
        String checkBuy = "";
        double total = 0;
        order = new Order();
        //get user from session
        session = request.getSession(false);
        if (session != null) {

            String userEmail = (String) session.getAttribute("userEmail");
            user = UserDao.getInstance().findUser(userEmail);
            if (productid != null && order != null) {
                product = productDao.findProduct(Integer.parseInt(productid));
                order = shopCartController.createOrder(product, user);
                session.setAttribute("order", order);
                
                //get total price
                if (order != null) {
                    
                    
                    if (orderProductsArray == null) {
                        orderProductsArray = new ArrayList<OrderProduct>();
                    }
                    orderProductsArray = order.getProducts();
                    //get total price of order
                    for (int i = 0; i < orderProductsArray.size(); i++) {
                        int productid2 = orderProductsArray.get(i).getProductCode();
                        Product product = ProductInformationController.getInstance().getProductDetails(productid2);
                        int quantity = orderProductsArray.get(i).getQuantity();
                        double productPrice = product.getPrice();
                        if (quantity > 1) {
                            productPrice = productPrice * quantity;
                        }
                        total = total + productPrice;
                        session.setAttribute("total", total);
                    }
                }
            }
//            RequestDispatcher req = request.getRequestDispatcher("Test");
//            req.include(request, response);
            if (showProducts != null && showProducts.equals("true")) {
                if (buy == true) {
                    productQuantityMap.clear();
                } else {
                    productQuantityMap = new HashMap<Product, Integer>();
                    productQuantityMap = shopCartController.showProductsList(((Order) session.getAttribute("order")));
                }
                request.setAttribute("productQuantityMap", productQuantityMap);
                RequestDispatcher req2 = request.getRequestDispatcher("ShopCartDetails.jsp");
                req2.include(request, response);
            }
            if (buyProducts != null && buyProducts.equals("true")) {
                checkBuy = shopCartController.buyProducts(((Order) session.getAttribute("order")), user);
                if (checkBuy == null) {
                    System.out.println("order is empty");
                } else if (checkBuy == "0") {
                    System.out.println("credit not enough");
                } else {
                    System.out.println("Total price = " + checkBuy);
                    buy = true;
                    session.setAttribute("total", null);
                    session.setAttribute("order", null);
                    session.setAttribute("productQuantityMap", null);
                }
            }
            if (deleteProduct != null && order != null){
                Product product = productDao.findProduct(Integer.parseInt(deleteProduct));
                Order order = (Order) session.getAttribute("order");
                ArrayList<OrderProduct> orderProducts = order.getProducts();
                for (int i = 0; i < orderProducts.size(); i++){
                    if (Integer.parseInt(deleteProduct) == orderProducts.get(i).getProductCode()){
                        orderProducts.remove(i);
                        total = (double) session.getAttribute("total");
                        total = total - product.getPrice();
                        session.setAttribute("total", total);
                    }
                }
                session.setAttribute("order", order);
                
            }

        }
        else {
            System.out.println("User can't make order...");
            response.sendRedirect("/Test2");
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
