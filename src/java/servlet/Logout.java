/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import bean.User;
import controller.AuthenticationController;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Mohamed
 */
public class Logout extends HttpServlet {

    AuthenticationController auth;

    public Logout() {
        auth = AuthenticationController.getInstance();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // get session
        HttpSession session = request.getSession(false);
        
        if(session != null ){
            
            User user = (User) session.getAttribute("user");
            
            if(user != null){
                
                auth.signOut(user.getEmail(), 0);
            }
                
            session.invalidate();
            
            response.sendRedirect("/E_Commerce/HomePage");
        }
        
    }

}
