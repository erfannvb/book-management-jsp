package nvb.dev.bookmanagementjsp.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

@WebFilter(filterName = "RegisterFilter", servletNames = "RegisterServlet", urlPatterns = "/register")
public class RegisterFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        String bookName = servletRequest.getParameter("bookName");
        String bookEdition = servletRequest.getParameter("bookEdition");
        String bookPrice = servletRequest.getParameter("bookPrice");

        StringBuilder error = new StringBuilder();
        if (bookName == null || bookName.isBlank() || bookEdition == null || bookEdition.isBlank() ||
                bookPrice == null || bookPrice.isBlank()) {
            error.append("Fill in all the fields.");
            servletRequest.setAttribute("error", error);
            RequestDispatcher dispatcher = servletRequest.getRequestDispatcher("/home.jsp");
            dispatcher.include(servletRequest, servletResponse);
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }

    }
}
