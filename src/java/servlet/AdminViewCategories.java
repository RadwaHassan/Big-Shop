/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import bean.Category;
import controller.ProductInformationController;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utility.MyFilter;
/**
 *
 * @author Mohamed
 */
public class AdminViewCategories extends HttpServlet {

    private ProductInformationController productInfoController;
    
    public AdminViewCategories() {
        productInfoController = ProductInformationController.getInstance();
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //check admin
        if(MyFilter.adminFilter(request, response))
            return;
        
        
        // get ArrayList of Categories
        ArrayList<Category> categories = productInfoController.getCategories();
        
        // attach list of categories on request
        request.setAttribute("categories", categories);
        
        // forward request to AdminViewCategories.jsp
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin/AdminViewCategories.jsp");
        dispatcher.forward(request, response);
    }

   
   
}
