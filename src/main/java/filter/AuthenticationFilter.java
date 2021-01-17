package filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import service.UserService;
import service.interfaces.IUserService;

import javax.servlet.http.Cookie;

import java.io.IOException;

public class AuthenticationFilter implements Filter {
	private static final IUserService userService = new UserService();

	private String homeURI;
	private String profileURI;
	private String clubURI;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// Filter.super.init(filterConfig);
		homeURI = filterConfig.getServletContext().getContextPath() + "/";
		profileURI = homeURI + "home";
	}

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    HttpServletRequest request = (HttpServletRequest) servletRequest;
    HttpServletResponse response = (HttpServletResponse) servletResponse;

    String path = request.getRequestURI();

		Cookie[] cookies = request.getCookies();
		for(int i = 0; i < cookies.length; i++){
			if(cookies[i].getName() == "user"){
				User user = userService.read(cookies[i].getValue());	
				if(user != null){
					request.getSession().setAttribute("user", user);
				}
				break;
			}
		}

		if(request.getSession().getAttribute("user") != null){
			User user = (User) request.getSession().getAttribute("user");
				if(!path.contains(profileURI) && !path.contains(homeURI) && !path.contains(clubURI)){
					response.sendError(401);
					return;
				}

		} //else if (request.getSession().getAttribute("user") == null) {
		//	request.getRequestDispatcher("/register").forward(request, response);
		//}else {
		//	request.getRequestDispatcher("/login").forward(request, response);
		//	return;
		//}

    if(path.endsWith(".jsp")){
      response.sendError(404);
      return;
    }

    filterChain.doFilter(request, response);
  }
}
