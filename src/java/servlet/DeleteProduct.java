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
public class DeleteProduct extends HttpServlet {

     private ProductManagmentController productManagmentController;

    public DeleteProduct() {
        productManagmentController = ProductManagmentController.getInstance();
    }
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //check admin
        if(MyFilter.adminFilter(request, response))
            return;
        
   
        // get product id parameter
        String productIdString = request.getParameter("productId");
    
        // parse product id string to int
        int productId = Integer.parseInt(productIdString);
        
        // delete category from db
        productManagmentController.deleteProduct(productId);
        
        // send redirect to AdminViewCategories
        response.sendRedirect("/E_Commerce/admin/AdminViewCategories");
    }

}
