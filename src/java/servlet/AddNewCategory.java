/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import controller.ProductManagmentController;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mohamed
 */
public class AddNewCategory extends HttpServlet {

    private ProductManagmentController productManagmentController;
    
    public AddNewCategory() {
        productManagmentController = ProductManagmentController.getInstance();
    }

    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // forward request to AddNewCategory.jsp
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/AddNewCategory.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // get category name parameter
        String catName = request.getParameter("name");
        
        // add category
        productManagmentController.addNewCategory(catName);
        
        // send redirect to AdminViewCategories
        response.sendRedirect("/E_Commerce/AdminViewCategories");
        
    }

}
