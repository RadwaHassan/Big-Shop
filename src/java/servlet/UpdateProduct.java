/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import bean.Product;
import controller.ProductInformationController;
import controller.ProductManagmentController;
import java.io.IOException;
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
public class UpdateProduct extends HttpServlet {

    
    private ProductManagmentController productManagmentController;
    private ProductInformationController productInformationController;
    
    public UpdateProduct() {
        productManagmentController = ProductManagmentController.getInstance();
        productInformationController = ProductInformationController.getInstance();
    }
    
    
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //check admin
        if(MyFilter.adminFilter(request, response))
            return;
        
        // get product code parameter
        String productCodeString = request.getParameter("productCode");
        
        // parse product code to int
        int productCode = Integer.parseInt(productCodeString);
        
        // get Product info
        Product product  = productInformationController.getProductDetails(productCode);
        
        System.out.println(product.getName());
        
        // set product attribure on request
        request.setAttribute("product", product);
        
        // forward request to UpdateProduct.jsp
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin/UpdateProduct.jsp");
        dispatcher.forward(request, response);
        
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        // get session
        HttpSession session = request.getSession();
        
        // get product attribute from session
        Product product =(Product)session.getAttribute("updateProduct");
        
        // add new product
        productManagmentController.updateProduct(product);
        
        // send redirect to Categories
        response.sendRedirect("/E_Commerce/admin/AdminViewCategories");
        
    }

  
}
