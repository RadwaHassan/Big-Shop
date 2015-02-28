
package servlet;

import bean.Category;
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
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
     prodInfocontroller= ProductInformationController.getInstance();
     ArrayList<Category> categories = prodInfocontroller.getCategories();
         HttpSession session  = request.getSession(true);
              session.setAttribute("category","categories");
        
       
     RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/HomePage.jsp");
     dispatcher.forward(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }


}
