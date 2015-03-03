/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlet;

import bean.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author yomna
 */
@WebServlet(name = "Test2", urlPatterns = {"/Test2"})
public class Test2 extends HttpServlet {

  
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        RequestDispatcher req = request.getRequestDispatcher("test2.html");
        req.include(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setAddress("maadi");
        user.setBirthDate("1/1");
        user.setCredit(150);
        user.setJob("student");
        user.setName("youmna");
        user.setRole(0);
        user.setStatus(0);
        HttpSession session = request.getSession(true);
        session.setAttribute("userEmail", user.getEmail());
        response.sendRedirect("Test");
//        RequestDispatcher req = request.getRequestDispatcher("/ShoppingCartDetailsServlet");
//        req.include(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
