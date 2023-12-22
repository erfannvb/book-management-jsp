package nvb.dev.bookmanagementjsp.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import nvb.dev.bookmanagementjsp.entity.Book;
import nvb.dev.bookmanagementjsp.repository.BookRepository;
import nvb.dev.bookmanagementjsp.repository.impl.BookRepositoryImpl;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "EditBookServlet", urlPatterns = "/edit")
public class EditBookServlet extends HttpServlet {

    private BookRepository bookRepository;

    @Override
    public void init() throws ServletException {
        bookRepository = new BookRepositoryImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            long id = Long.parseLong(req.getParameter("id"));
            String bookName = req.getParameter("bookName");
            String bookEdition = req.getParameter("bookEdition");
            double bookPrice = Double.parseDouble(req.getParameter("bookPrice"));

            Book book = new Book(id, bookName, bookEdition, bookPrice);
            bookRepository.updateBook(book);

            String successMsg = "Book Updated Successfully!!!";
            req.setAttribute("success", successMsg);

            getServletContext().getRequestDispatcher("/editBook.jsp").forward(req, resp);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
