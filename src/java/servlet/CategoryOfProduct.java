/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import bean.Category;
import bean.Product;
import controller.ProductInformationController;
import controller.ProductManagmentController;
import dao.CategoryDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CategoryOfProduct extends HttpServlet {

    ProductInformationController prodInfocontroller;

    public CategoryOfProduct() {
        prodInfocontroller = ProductInformationController.getInstance();
    }
    
    
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // get category id parameter
        String categoryIdString = request.getParameter("categoryId");
        
        // parse id string to int
        int categoryId = Integer.parseInt(categoryIdString);
        
        // get products for that category
        ArrayList<Product> products = prodInfocontroller.getProductsForCategory(categoryId);
        
        // add attribute on request
        request.setAttribute("products", products);
        
        ArrayList<Category> categories = prodInfocontroller.getCategories();
       
        request.setAttribute("categories",categories);
        
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/CategoryProducts.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
