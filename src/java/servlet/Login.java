package servlet;

import bean.User;
import controller.AuthenticationController;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
            RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
            dispatcher.forward(request, response);   
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        HttpSession session;
        AuthenticationController controller = new AuthenticationController();
        User user = controller.signIn(request.getParameter("email"));
        
        if (request.getParameter("email").equals("") || request.getParameter("password").equals("")) {

            response.sendRedirect("/E_Commerce/login.jsp");

        } else if (user != null && user.getPassword().equals(request.getParameter("password"))) {
            
            user.setStatus(1);
            
            session = request.getSession(true);
            session.setAttribute("user", user);
            
            if (user.getRole() == 0) {
                response.sendRedirect("HomePage");
            } else if (user.getRole() == 1) {
                response.sendRedirect("/E_Commerce/admin/AdminViewCategories");
            }
        } else {
            response.sendRedirect("/E_Commerce/login.jsp");
        }

    }

}
