package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import repository.UserRepository;

public class UserController extends HttpServlet {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private static final UserRepository userRepository = new UserRepository();


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "/pages/user/", route = request.getPathInfo();
		if(route != null) route = route.replaceAll("\\/$", "").replaceAll("^\\/", "");
		else route = "";

		int id = 0;
		switch(route){
			case "create":
				path += "create.jsp";
				break;
			case "delete":
				if(request.getParameter("id") != null) id = Integer.parseInt(request.getParameter("id"));
				else id = 0;
				userRepository.delete(id);
				path += "index.jsp";
				break;
				// commit
			case "edit":
				path += "edit.jsp";
				break;
			default:
				String group = request.getParameter("group");
				String major = request.getParameter("major");
				int year = 0;
				if(request.getParameter("year") != null && request.getParameter("year") != ""){
					year = Integer.parseInt(request.getParameter("year"));
				}

				System.out.println(group + major + year);
				//request.setAttribute("users", userRepository.search(group, major, year));
				path += "index.jsp";
		}

		request.getRequestDispatcher(path).forward(request, response);
	}


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  String route = request.getPathInfo();
		if(route != null) route = route.replaceAll("\\/$", "").replaceAll("^\\/", "");
		else route = "";

		String message;
		boolean resp = false;

		switch(route){
			case "create":
				resp = createAction(request);
				break;
			case "delete":
				System.out.println("delete user");
				break;
			case "edit":
				System.out.println("edit user");
				break;
			default:
		}

		if(resp){
			message = "Success";
		} else {
			message = "Fail";
		}
		request.getSession().setAttribute("message", message);
		doGet(request, response);
	}


	private final boolean createAction(HttpServletRequest request){
		return userRepository.create(new User.UserBuilder()
				.setName(request.getParameter("name"))
				.setSurname(request.getParameter("surname"))
				.setUsername(request.getParameter("username"))
				.setPassword(request.getParameter("password"))
				.build());
	}
}
