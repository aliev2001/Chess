package controller;

import model.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final UserService userService = new UserService();

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setAttribute("title", "Login page");
    request.getRequestDispatcher("/pages/login.jsp").forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    String message = "";

    if(!username.isEmpty() && !password.isEmpty()){
      User user = userService.login(username, password);
      if(user != null){
        HttpSession session = request.getSession();
				Cookie ck = new Cookie("user", user.getUsername());
        session.setAttribute("user", user);
				response.addCookie(ck);
        response.sendRedirect(request.getContextPath() + "/profile");
        return;
      } else {
        message = "Username or password is incorrect";
      }
    }
    request.getSession().setAttribute("message", message);
    doGet(request, response);
  }
}
