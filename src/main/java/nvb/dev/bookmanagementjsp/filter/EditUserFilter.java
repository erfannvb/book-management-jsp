package nvb.dev.bookmanagementjsp.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter(filterName = "EditUserFilter", servletNames = "EditUserServlet", urlPatterns = "/editUser")
public class EditUserFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String username = request.getParameter("username");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String age = request.getParameter("age");
        String password = request.getParameter("password");

        StringBuilder error = new StringBuilder();
        if (username == null || username.isBlank() || firstName == null || firstName.isBlank() ||
                lastName == null || lastName.isBlank() || age == null || age.isBlank() ||
                password == null || password.isBlank()) {
            error.append("Fill in all the fields.");
            request.setAttribute("error", error);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/editUser.jsp");
            dispatcher.include(request, response);
        } else {
            filterChain.doFilter(request, response);
        }

    }
}
