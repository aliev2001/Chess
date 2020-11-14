package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserController extends HttpServlet {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  String route = request.getPathInfo().replaceAll("\\/$", "").replaceAll("^\\/", "");

		switch(route){
			case "create":
				System.out.println("create user");
				break;
			case "delete":
				System.out.println("delete user");
				break;
			case "edit":
				System.out.println("edit user");
				break;
			default:
		}
	}
}
