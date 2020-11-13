package filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthenticationFilter implements Filter {
  private String loginURI;
  private String registerURI;
  private String profileURI;

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    loginURI = filterConfig.getServletContext().getContextPath() + "/login";
    registerURI = filterConfig.getServletContext().getContextPath() + "/register";
    profileURI = filterConfig.getServletContext().getContextPath() + "/profile";
  }

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    HttpServletRequest request = (HttpServletRequest) servletRequest;
    HttpServletResponse response = (HttpServletResponse) servletResponse;

    String path = request.getRequestURI();

    if(request.getSession().getAttribute("user") != null){
      if(path.equals(loginURI) || path.equals(registerURI)){
        response.sendRedirect("profile");
        return;
      }
    } else {
      if(path.equals(profileURI)){
        response.sendError(401);
        return;
      }
    }

    if(path.endsWith(".jsp")){
      response.sendError(404);
      return;
    }

    filterChain.doFilter(request, response);
  }

  @Override
  public void destroy() {
  }
}
