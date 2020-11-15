package controller;

import model.Club;
import repository.ClubRepository;
import repository.interfaces.IClubRepository;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ClubController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private final IClubRepository clubRepository = new ClubRepository();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  String route = request.getPathInfo();
		if(route != null) route = route.replaceAll("\\/$", "").replaceAll("^\\/", "");
		else route = "";
		switch(route){
			case "read":
				int id1 = Integer.parseInt(request.getParameter("id"));
				clubRepository.read(id1);
				break;

			case "create":
				Club club = new Club();
				club.setTitle(request.getParameter("title"));
				club.setDescription(request.getParameter("description"));

				clubRepository.create(club);
				break;

			case "edit":
				Club clubedit = new Club();
				clubedit.setTitle(request.getParameter("title"));
				clubedit.setDescription(request.getParameter("description"));

				clubRepository.edit(clubedit);
				break;

			case "delete":
				int id = Integer.parseInt(request.getParameter("id"));
				clubRepository.delete(id);
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
			case "read":
				break;

			case "create":
				request.getRequestDispatcher("/pages/club/create.jsp").forward(request, response);
				break;
			case "edit":
				request.getRequestDispatcher("/pages/club/edit.jsp").forward(request, response);
				break;

			case "delete":

				break;
			default:
				break;
		}
		// request.getRequestDispatcher("pages/club.jsp").forward(request, response);
	}
}
