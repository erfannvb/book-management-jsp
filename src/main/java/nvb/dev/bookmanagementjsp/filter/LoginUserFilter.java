package nvb.dev.bookmanagementjsp.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

@WebFilter(filterName = "LoginUserFilter", servletNames = "LoginUserServlet", urlPatterns = "/login")
public class LoginUserFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        String username = servletRequest.getParameter("username");
        String password = servletRequest.getParameter("pwd");

        StringBuilder error = new StringBuilder();
        if (username == null || username.isBlank() || password == null || password.isBlank()) {
            error.append("Username / Password is incorrect!");
            servletRequest.setAttribute("error", error);
            RequestDispatcher dispatcher = servletRequest.getRequestDispatcher("/login.jsp");
            dispatcher.include(servletRequest, servletResponse);
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }

    }
}
