/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import bean.Product;
import controller.ProductManagmentController;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utility.MyFilter;

/**
 *
 * @author Mohamed
 */
public class AddNewProduct extends HttpServlet {

    
    private ProductManagmentController productManagmentController;

    public AddNewProduct() {
        productManagmentController = ProductManagmentController.getInstance();
    }
    
    
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        //check admin
        if(MyFilter.adminFilter(request, response))
            return;
        
        
        // set category id attribure on request
        request.setAttribute("categoryId", request.getParameter("categoryId"));
        
        // set category name attribure on request
        request.setAttribute("categoryName", request.getParameter("categoryName"));
        
        // forward request to AddNewProduct.jsp
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin/AddNewProduct.jsp");
        dispatcher.forward(request, response);
        
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //check admin
        if(MyFilter.adminFilter(request, response))
            return;
        
        
        // get session
        HttpSession session = request.getSession();
        
        // get product attribute from session
        Product product =(Product)session.getAttribute("product");
  
        product.setImagePath("images/"+product.getImagePath());
        
        // add new product
        productManagmentController.addNewProduct(product);
        
        session.removeAttribute("product");
        
        // send redirect to Categories
        response.sendRedirect("/E_Commerce/admin/AdminViewCategories");
        
    }

  
}
