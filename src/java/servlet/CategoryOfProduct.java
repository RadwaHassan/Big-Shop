/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import bean.Category;
import bean.Product;
import controller.ProductInformationController;
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
    int categoryname;
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // object from product info controller
         prodInfocontroller= ProductInformationController.getInstance();
         //define aaraylist of product for specific category
         ArrayList<Product> products = prodInfocontroller.getProductsForCategory(categoryname);
         request.setAttribute("products","products");
         
              
     RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/HomePage.jsp");
     dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
    }

   
    

}
