package controller;

import model.Event;
import repository.EventRepository;
import repository.interfaces.IEventRepository;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EventController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final IEventRepository eventRepository = new EventRepository();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String route = request.getPathInfo().replaceAll("\\/$", "").replaceAll("^\\/", "");
		switch(route){
			case "read":
				int id1 = Integer.parseInt(request.getParameter("id"));
				eventRepository.read(id1);

				break;
			case "create":
				try {
					String title = request.getParameter("title");
					String text = request.getParameter("");
					String sdate = request.getParameter("date");
					Date date = new SimpleDateFormat("dd/MM/yyyy").parse(sdate);

					Event event = new Event();
					event.setTitle(title);
					event.setText(text);
					event.setDate((java.sql.Date) date);

					eventRepository.create(event);

				} catch (ParseException e) {
					e.printStackTrace();
				}

				break;
			case "edit":
				try {
					String title1 = request.getParameter("title");
					String text1 = request.getParameter("");
					String sdate = request.getParameter("date");
					Date date = new SimpleDateFormat("dd/MM/yyyy").parse(sdate);

					Event event = new Event();
					event.setTitle(title1);
					event.setText(text1);
					event.setDate((java.sql.Date) date);

					eventRepository.edit(event);

				} catch (ParseException e) {
					e.printStackTrace();
				}
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
		String route = request.getPathInfo().replaceAll("\\/$", "").replaceAll("^\\/", "");
		switch(route){
			case "read":

				break;
			case "create":
				request.getRequestDispatcher("pages/event/create.jsp").forward(request, response);
				break;
			case "edit":
				request.getRequestDispatcher("pages/event/edit.jsp").forward(request, response);
				break;
			case "delete":

				break;
			default:
				break;
		}
		doGet(request, response);

		request.getRequestDispatcher("pages/news.jsp").forward(request, response);
	}
}
