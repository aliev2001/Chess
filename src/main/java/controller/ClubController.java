package controller;

import model.Club;
import service.ClubService;
import service.interfaces.IClubService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ClubController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private final IClubService clubService = new ClubService();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  String route = request.getPathInfo();
		if(route != null) route = route.replaceAll("\\/$", "").replaceAll("^\\/", "");
		else route = "";
		switch(route){
			case "read":
				int id1 = Integer.parseInt(request.getParameter("id"));
				clubService.read(id1);
				break;

			case "create":
				Club club = new Club();
				club.setTitle(request.getParameter("title"));
				club.setImage(request.getParameter("image"));
				club.setDescription(request.getParameter("description"));
				clubService.create(club);
				break;

			case "edit":
				Club clubedit = new Club();
				clubedit.setId(Long.parseLong(request.getParameter("id")));
				clubedit.setTitle(request.getParameter("title"));
				clubedit.setImage(request.getParameter("image"));
				clubedit.setDescription(request.getParameter("description"));

				clubService.edit(clubedit);
				break;

			case "delete":
				int id = Integer.parseInt(request.getParameter("id"));
				clubService.delete(id);
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
		int id = 0;
		switch(route){
			case "read":
				break;

			case "create":
				request.getRequestDispatcher("/pages/club/create.jsp").forward(request, response);
				break;
			case "edit":
				if(request.getParameter("id") != null) id = Integer.parseInt(request.getParameter("id"));
				else id = 0;
				request.setAttribute("club", clubService.read(id));
				request.getRequestDispatcher("/pages/club/edit.jsp").forward(request, response);
				break;
			case "delete":
				if(request.getParameter("id") != null) id = Integer.parseInt(request.getParameter("id"));
				else id = 0;
				clubService.delete(id);
				request.getRequestDispatcher("/pages/club/index.jsp").forward(request, response);
				break;
			default:
				request.setAttribute("clubs", clubService.getAll());

				request.getRequestDispatcher("/pages/club/index.jsp").forward(request, response);
				break;
		}
		// request.getRequestDispatcher("pages/club.jsp").forward(request, response);
	}
}
