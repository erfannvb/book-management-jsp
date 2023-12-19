package nvb.dev.bookmanagementjsp.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import nvb.dev.bookmanagementjsp.entity.Book;
import nvb.dev.bookmanagementjsp.repository.BookRepository;
import nvb.dev.bookmanagementjsp.repository.impl.BookRepositoryImpl;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {

    private final BookRepository bookRepository = new BookRepositoryImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {

            String bookName = req.getParameter("bookName");
            String bookEdition = req.getParameter("bookEdition");
            String bookPrice = req.getParameter("bookPrice");

            StringBuilder error = new StringBuilder();
            if (bookName == null || bookName.isBlank() || bookEdition == null || bookEdition.isBlank() ||
                    bookPrice == null || bookPrice.isBlank()) {
                error.append("Fill in blank inputs.");
                req.setAttribute("error", error.toString());
                getServletContext().getRequestDispatcher("/home.jsp").forward(req, resp);
            } else {
                bookRepository.addBook(new Book(bookName, bookEdition, Float.parseFloat(bookPrice)));
                PrintWriter out = resp.getWriter();
                out.println("<h1>Book Added Successfully!!!</h1>");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
