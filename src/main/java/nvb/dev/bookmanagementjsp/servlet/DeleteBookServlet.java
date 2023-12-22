package nvb.dev.bookmanagementjsp.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import nvb.dev.bookmanagementjsp.repository.BookRepository;
import nvb.dev.bookmanagementjsp.repository.impl.BookRepositoryImpl;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DeleteBookServlet", urlPatterns = "/delete")
public class DeleteBookServlet extends HttpServlet {

    private BookRepository bookRepository;

    @Override
    public void init() throws ServletException {
        bookRepository = new BookRepositoryImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            long id = Long.parseLong(req.getParameter("id"));
            bookRepository.deleteBookById(id);
            getServletContext().getRequestDispatcher("/deleteBook.jsp").forward(req, resp);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
