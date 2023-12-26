package nvb.dev.bookmanagementjsp.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter(filterName = "LoginUserFilter", servletNames = "LoginUserServlet", urlPatterns = "/login")
public class LoginUserFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String username = request.getParameter("username");
        String password = request.getParameter("pwd");

        StringBuilder error = new StringBuilder();
        if (username == null || username.isBlank() || password == null || password.isBlank()) {
            error.append("Username / Password is incorrect!");
            request.setAttribute("error", error);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
            dispatcher.include(request, response);
        } else {
            filterChain.doFilter(request, response);
        }

    }
}
