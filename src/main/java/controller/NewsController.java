package controller;

import model.News;
import repository.NewsRepository;
import repository.interfaces.INewsRepository;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NewsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final INewsRepository newsRepository = new NewsRepository();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String route = request.getPathInfo().replaceAll("\\/$", "").replaceAll("^\\/", "");
		switch(route){
			case "read":
				int id1 = Integer.parseInt(request.getParameter("id"));
				newsRepository.read(id1);

				break;
			case "create":
				try {
					String title = request.getParameter("title");
					String text = request.getParameter("");
					String sdate = request.getParameter("date");
					Date date = new SimpleDateFormat("dd/MM/yyyy").parse(sdate);

					News news = new News();
					news.setTitle(title);
					news.setText(text);
					news.setDate((java.sql.Date) date);

					newsRepository.create(news);

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

					News news = new News();
					news.setTitle(title1);
					news.setText(text1);
					news.setDate((java.sql.Date) date);

					newsRepository.edit(news);

				} catch (ParseException e) {
					e.printStackTrace();
				}
				break;

			case "delete":
				int id = Integer.parseInt(request.getParameter("id"));
				newsRepository.delete(id);
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
				request.getRequestDispatcher("pages/news/create.jsp").forward(request, response);
				break;
			case "edit":
				request.getRequestDispatcher("pages/news/edit.jsp").forward(request, response);
				break;
			default:
				break;
			case "delete":

				break;
		}
		doGet(request, response);

		request.getRequestDispatcher("pages/news.jsp").forward(request, response);
	}
}
