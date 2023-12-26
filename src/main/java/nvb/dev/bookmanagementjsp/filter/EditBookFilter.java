package nvb.dev.bookmanagementjsp.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter(filterName = "EditBookFilter", servletNames = "EditBookServlet", urlPatterns = "/edit")
public class EditBookFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String bookName = request.getParameter("bookName");
        String bookEdition = request.getParameter("bookEdition");
        String bookPrice = request.getParameter("bookPrice");

        StringBuilder error = new StringBuilder();
        if (bookName == null || bookName.isBlank() || bookEdition == null || bookEdition.isBlank() ||
                bookPrice == null || bookPrice.isBlank()) {
            error.append("Fill in all the fields.");
            request.setAttribute("error", error);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/editBook.jsp");
            dispatcher.include(request, response);
        } else {
            filterChain.doFilter(request, response);
        }

    }
}
