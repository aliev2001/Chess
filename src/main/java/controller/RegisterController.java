package controller;

import model.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final UserService userService = new UserService();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("title", "Register page");
		request.getRequestDispatcher("/pages/register.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		int year = Integer.parseInt(request.getParameter("year"));
		String major = request.getParameter("major");
		String uGroup = request.getParameter("uGroup");

		String message = "";

		if(!name.isEmpty() && !surname.isEmpty() && !username.isEmpty() && !password.isEmpty()){
			User user = new User.UserBuilder()
				.setName(name)
				.setSurname(surname)
				.setUsername(username)
				.setPassword(password)
				.setYear(year)
				.setMajor(major)
				.setUGroup(uGroup)
				.build();
			if(userService.create(user)){
				message = "Account was created. Now you can login";
			} else {
				message = "Sorry, something went wrong.";
			}
		}
		request.getSession().setAttribute("message", message);
		doGet(request, response);
	}
}
