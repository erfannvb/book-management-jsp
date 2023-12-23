package nvb.dev.bookmanagementjsp.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

@WebFilter(filterName = "EditUserFilter", servletNames = "EditUserServlet", urlPatterns = "/editUser")
public class EditUserFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        String username = servletRequest.getParameter("username");
        String firstName = servletRequest.getParameter("firstName");
        String lastName = servletRequest.getParameter("lastName");
        String age = servletRequest.getParameter("age");
        String password = servletRequest.getParameter("password");

        StringBuilder error = new StringBuilder();
        if (username == null || username.isBlank() || firstName == null || firstName.isBlank() ||
                lastName == null || lastName.isBlank() || age == null || age.isBlank() ||
                password == null || password.isBlank()) {
            error.append("Fill in all the fields.");
            servletRequest.setAttribute("error", error);
            RequestDispatcher dispatcher = servletRequest.getRequestDispatcher("/editUser.jsp");
            dispatcher.include(servletRequest, servletResponse);
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }

    }
}
