package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = "/news/*")
public class NewsController extends HttpServlet {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  String route = request.getPathInfo();
		if(route != null) route = route.replaceAll("\\/$", "").replaceAll("^\\/", "");
		else route = "";

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
	  String route = request.getPathInfo();
		if(route != null) route = route.replaceAll("\\/$", "").replaceAll("^\\/", "");
		else route = "";

		switch(route){
			case "create":
				request.getRequestDispatcher("/pages/news/create.jsp").forward(request, response);
				break;
			case "edit":
				break;
			case "delete":
				break;
			default:
				request.getRequestDispatcher("/pages/news/index.jsp").forward(request, response);
				break;
		}
	}
}
