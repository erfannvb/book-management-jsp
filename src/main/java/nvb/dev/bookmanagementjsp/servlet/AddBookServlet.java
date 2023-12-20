package nvb.dev.bookmanagementjsp.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import nvb.dev.bookmanagementjsp.entity.Book;
import nvb.dev.bookmanagementjsp.repository.BookRepository;
import nvb.dev.bookmanagementjsp.repository.impl.BookRepositoryImpl;

import java.io.IOException;

@WebServlet(name = "AddBookServlet", urlPatterns = "/addBook")
public class AddBookServlet extends HttpServlet {

    private BookRepository bookRepository;
    private ObjectMapper objectMapper;

    @Override
    public void init() throws ServletException {
        bookRepository = new BookRepositoryImpl();
        objectMapper = new ObjectMapper();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {

            String bookName = req.getParameter("bookName");
            String bookEdition = req.getParameter("bookEdition");
            String bookPrice = req.getParameter("bookPrice");

            Book book = new Book();
            book.setBookName(bookName);
            book.setBookEdition(bookEdition);
            book.setBookPrice(Double.parseDouble(bookPrice));

            bookRepository.addBook(book);

            String successMsg = bookName + " added successfully!";
            req.setAttribute("success", successMsg);

            String bookJson = objectMapper.writeValueAsString(book);
            req.setAttribute("jsonBody", bookJson);

            getServletContext().getRequestDispatcher("/addBook.jsp").forward(req, resp);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
