package controller;

import model.Event;
import repository.EventRepository;
import repository.interfaces.IEventRepository;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class EventController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final IEventRepository eventRepository = new EventRepository();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String route = request.getPathInfo();
		if(route != null) route = route.replaceAll("\\/$", "").replaceAll("^\\/", "");
		switch(route){
			case "read":
				int id1 = Integer.parseInt(request.getParameter("id"));
				eventRepository.read(id1);
				break;
			case "create":
					String title = request.getParameter("title");
					String text = request.getParameter("text");
					String sdate = request.getParameter("date");
					Event event = new Event();
					event.setTitle(title);
					event.setText(text);
					event.setDate(Date.valueOf(sdate));
					eventRepository.create(event);
				break;
			case "edit":
					long i = Long.parseLong(request.getParameter("id"));
					String title1 = request.getParameter("title");
					String text1 = request.getParameter("text");
					String sdate1 = request.getParameter("date");

					Event e = new Event();
					e.setId(i);
					e.setTitle(title1);
					e.setText(text1);
					e.setDate(Date.valueOf(sdate1));
					eventRepository.edit(e);
				break;

			case "delete":
				int id = Integer.parseInt(request.getParameter("id"));
				eventRepository.delete(id);
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
		int id = 0;
		switch(route){
			case "read":
				break;
			case "create":
				request.getRequestDispatcher("/pages/event/create.jsp").forward(request, response);
				break;
			case "edit":
				if(request.getParameter("id") != null) id = Integer.parseInt(request.getParameter("id"));
				else id = 0;
				request.setAttribute("event", eventRepository.read(id));
				request.getRequestDispatcher("/pages/event/edit.jsp").forward(request, response);
				break;
			case "delete":
				id = Integer.parseInt(request.getParameter("id"));
				System.out.println("DELET "  + id);
				eventRepository.delete(id);
				break;
			default:
				break;
		}
	}
}
