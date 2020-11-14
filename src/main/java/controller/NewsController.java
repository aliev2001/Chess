package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NewsController extends HttpServlet {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;



	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  String route = request.getPathInfo().replaceAll("\\/$", "").replaceAll("^\\/", "");
		switch(route){
			case "create":
				break;
			case "edit":
				break;
			case "delete":
				break;
			default:
				break;
		}
		doGet(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("pages/news.jsp").forward(request, response);
	}
}
