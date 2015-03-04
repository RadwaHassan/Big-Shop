
package servlet;

import bean.Category;
import bean.Product;
import bean.User;
import controller.ProductInformationController;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author edumk_240
 */
public class HomePage extends HttpServlet {

    ProductInformationController prodInfocontroller;
    String categoryname=null;

    public HomePage() {
        // get object from controller
         prodInfocontroller= ProductInformationController.getInstance();
    }
 
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
      //  System.out.println("home page doGET method"+ ((User)session.getAttribute("user")).getEmail());
       // get arraylist of gategory
       ArrayList<Category> categories = prodInfocontroller.getCategoryWithProduct();
       
       // set gategorylist on session scope      
        // HttpSession session  = request.getSession(true);
        // session.setAttribute("categories",categories);
        request.setAttribute("categories",categories);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/HomePage.jsp");
        dispatcher.forward(request, response);
  
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
             this.doGet(request, response);
     
    }

   
  

}
