package controller;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String redirect = request.getParameter("redirect");
		Cookie ck = new Cookie("user", "");
		ck.setMaxAge(0);
		response.addCookie(ck);
		request.getSession().removeAttribute("user");
		if(redirect == null){
			response.sendRedirect("login");
		} else {
			response.sendRedirect(redirect);
		}
  }
}
