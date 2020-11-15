package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.News;
import repository.NewsRepository;
import service.NewsService;
import service.interfaces.INewsService;


@WebServlet(urlPatterns = "/news/*")
public class NewsController extends HttpServlet {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private static final INewsService newsService = new NewsService();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  String route = request.getPathInfo();
		if(route != null) route = route.replaceAll("\\/$", "").replaceAll("^\\/", "");
		else route = "";

		switch(route){
			case "create":
				createNewsAction(request);
				break;
			case "edit":
				editNewsAction(request);
				break;
			case "delete":
				int id = 0;
				if(request.getParameter("id") != null) id = Integer.parseInt(request.getParameter("id"));
				newsService.delete(id);
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
			case "create":
				request.getRequestDispatcher("/pages/news/create.jsp").forward(request, response);
				break;
			case "edit":
				if(request.getParameter("id") != null) id = Integer.parseInt(request.getParameter("id"));
				else id = 0;
				request.setAttribute("user", newsService.read(id));
				request.getRequestDispatcher("/pages/news/edit.jsp").forward(request, response);
				break;
			case "delete":
				if(request.getParameter("id") != null) id = Integer.parseInt(request.getParameter("id"));
				else id = 0;
				newsService.delete(id);
				request.getRequestDispatcher("/pages/index.jsp").forward(request, response);
				break;
			default:
				request.getRequestDispatcher("/pages/news/index.jsp").forward(request, response);
				break;
		}
	}

	private void createNewsAction(HttpServletRequest request){
		News news = new News();
		String title = request.getParameter("title");	
		String text = request.getParameter("text");
		news.setTitle(title);
		news.setText(text);
		newsService.create(news);
	}

	private void editNewsAction(HttpServletRequest request){
		News news = new News();
		long id = Long.parseLong(request.getParameter("id"));
		String title = request.getParameter("title");	
		String text = request.getParameter("text");
		news.setId(id);
		news.setTitle(title);
		news.setText(text);
		newsService.edit(news);
	}
}
