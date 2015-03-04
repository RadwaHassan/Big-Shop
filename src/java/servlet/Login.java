package servlet;

import bean.User;
import controller.AuthenticationController;
import dao.UserDao;
import java.io.IOException;
import java.io.PrintWriter;
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

        RequestDispatcher req = request.getRequestDispatcher("/login.jsp");
        req.include(request, response);
////            RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
////            dispatcher.forward(request, response);   
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        response.setContentType("text/html");
        HttpSession session;
        AuthenticationController controller = new AuthenticationController();
        boolean isFound = controller.signIn(request.getParameter("email"),request.getParameter("password"));
        
                 if (request.getParameter("email").equals("") || request.getParameter("password").equals("")) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);
        }
        
         User user=null;
        if(isFound){
            UserDao dao=UserDao.getInstance();
          user =dao.findUser(request.getParameter("email"),request.getParameter("password"));
            
            System.out.println("user not null");
            if (user.getEmail().equals(request.getParameter("email")) && user.getPassword().equals(request.getParameter("password"))){
                System.out.println("in user sa7");
                session = request.getSession();
            session.setAttribute("user", user);
            RequestDispatcher dispatcher = request.getRequestDispatcher("HomePage");
            dispatcher.forward(request, response);
        }
        }else {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Registration.jsp");
            dispatcher.forward(request, response);
        }
//        System.out.println("in Servlet"+user.getEmail());
//       out.println(user.getName());
       
        
}

}
