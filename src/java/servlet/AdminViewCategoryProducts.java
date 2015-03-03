/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import bean.Product;
import controller.ProductInformationController;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mohamed
 */
public class AdminViewCategoryProducts extends HttpServlet {

    private ProductInformationController productInformationController;
    
    public AdminViewCategoryProducts() {
        productInformationController = ProductInformationController.getInstance();
    }
   
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // get category id parameter
        String categoryIdString = request.getParameter("categoryId");
        
        // get category name parameter
        String categoryName = request.getParameter("categoryName");
        
        // parse category id string to int
        int categoryId = Integer.parseInt(categoryIdString);
        
        // get list of product for category
        List<Product> products = productInformationController.getProductsForCategory(categoryId);
        
        // attach products list on request
        request.setAttribute("products", products);
        
          // attach category name on request
        request.setAttribute("categoryName", categoryName+"  ");
        
        // attach category id
        request.setAttribute("categoryId", categoryId);
        
        // forward request to AdminCategoryProducts.jsp
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin/AdminCategoryProducts.jsp");
        dispatcher.forward(request, response);
    }

}
