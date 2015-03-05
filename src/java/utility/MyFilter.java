/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import bean.User;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Mohamed
 */
public class MyFilter {
    
   public static boolean adminFilter(HttpServletRequest request, HttpServletResponse response){
        
        HttpSession session  = request.getSession();
        User user  = (User) session.getAttribute("user");
        
        if(session == null || user == null || user.getRole() != 1){
            try {
                response.sendRedirect("/E_Commerce/Login");
            } catch (IOException ex) {
                Logger.getLogger(MyFilter.class.getName()).log(Level.SEVERE, null, ex);
            }
            return true;
        }
        return false;
    }
    
}
