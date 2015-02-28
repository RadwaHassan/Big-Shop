/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import bean.Product;
import controller.ProductInformationController;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mohamed
 */
public class ProductDetailsServlet extends HttpServlet {

    // Product Information Controller
    private ProductInformationController productInfoController;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // get instance object of product information controller
        productInfoController = ProductInformationController.getInstance();
        
        // get product code parameter from request
        String productCodeStr = request.getParameter("productCode");
        
        // parse code string to int
        int productCode = Integer.parseInt(productCodeStr);
        
        // get product details
        Product product = productInfoController.getProductDetails(productCode);
        
        // add product object on request
        request.setAttribute("product", product);
        
        // forward request to productDetails.jsp
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ProductDetails.jsp");
        dispatcher.forward(request, response);
    }

}
