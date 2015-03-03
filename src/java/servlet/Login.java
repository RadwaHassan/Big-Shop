
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
        
////            RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
////            dispatcher.forward(request, response);   
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        HttpSession session;
        AuthenticationController controller = new AuthenticationController();
        User user = controller.signIn(request.getParameter("email"));
        
        if (request.getParameter("email").equals("") || request.getParameter("password").equals("")) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/HomePage");
            dispatcher.forward(request, response);
        } else if (user != null) {
            session = request.getSession();
            session.setAttribute("user", user);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/HomePage");
            dispatcher.forward(request, response);
            
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/Registration.jsp");
            dispatcher.forward(request, response);
        }

    }

}
