package nvb.dev.bookmanagementjsp.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import nvb.dev.bookmanagementjsp.entity.Book;
import nvb.dev.bookmanagementjsp.repository.BookRepository;
import nvb.dev.bookmanagementjsp.repository.impl.BookRepositoryImpl;

import java.io.IOException;
import java.util.List;

@WebFilter(filterName = "AddBookFilter", servletNames = "AddBookServlet", urlPatterns = "/addBook")
public class AddBookFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        BookRepository bookRepository = new BookRepositoryImpl();
        List<Book> bookList = bookRepository.getAllBooks();

        String bookName = servletRequest.getParameter("bookName");
        String bookEdition = servletRequest.getParameter("bookEdition");
        String bookPrice = servletRequest.getParameter("bookPrice");

        StringBuilder error = new StringBuilder();

        for (Book book : bookList) {
            if (book.getBookName().equals(bookName)) {
                error.append("Book with this name already exists!");
                request.setAttribute("error", error);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/addBook.jsp");
                dispatcher.include(request, response);
            } else if (bookName == null || bookName.isBlank() || bookEdition == null || bookEdition.isBlank() ||
                    bookPrice == null || bookPrice.isBlank()) {
                error.append("Fill in all the fields.");
                request.setAttribute("error", error);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/addBook.jsp");
                dispatcher.include(request, response);
            } else {
                filterChain.doFilter(request, response);
            }
        }

    }
}
