
package servlet;

import bean.Category;
import bean.Product;
import controller.ProductInformationController;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author edumk_240
 */
public class HomePage extends HttpServlet {

    ProductInformationController prodInfocontroller;
    String categoryname=null;
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
     prodInfocontroller= ProductInformationController.getInstance();
     ArrayList<Category> categories = prodInfocontroller.getCategories();
      ArrayList<Product> products = prodInfocontroller.getProductsForCategory(categoryname);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }


}
