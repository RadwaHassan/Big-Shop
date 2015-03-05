/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import controller.ProductManagmentController;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utility.MyFilter;

/**
 *
 * @author Mohamed
 */
public class DeleteCategory extends HttpServlet {
 
    private ProductManagmentController productManagmentController;

    public DeleteCategory() {
        productManagmentController = ProductManagmentController.getInstance();
    }
    
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //check admin
        if(MyFilter.adminFilter(request, response))
            return;
        
        
        // get category id parameter
        String categoryIdString = request.getParameter("categoryId");
    
        // parse category id string to int
        int categoryId = Integer.parseInt(categoryIdString);
        
        // delete category from db
        productManagmentController.deleteCategory(categoryId);
        
        // send redirect to AdminViewCategories
        response.sendRedirect("/E_Commerce/admin/AdminViewCategories");
    }

 
}
