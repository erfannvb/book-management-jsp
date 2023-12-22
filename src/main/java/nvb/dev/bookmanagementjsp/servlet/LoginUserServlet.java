package nvb.dev.bookmanagementjsp.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import nvb.dev.bookmanagementjsp.entity.User;
import nvb.dev.bookmanagementjsp.repository.UserRepository;
import nvb.dev.bookmanagementjsp.repository.impl.UserRepositoryImpl;

import java.io.IOException;

@WebServlet(name = "LoginUserServlet", urlPatterns = "/login")
public class LoginUserServlet extends HttpServlet {

    private UserRepository userRepository;

    @Override
    public void init() throws ServletException {
        userRepository = new UserRepositoryImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String username = req.getParameter("username");
            String password = req.getParameter("pwd");

            StringBuilder error = new StringBuilder();

            User userByUsernameAndPassword = userRepository.getUserByUsernameAndPassword(username, password);
            if (userByUsernameAndPassword.getUsername() != null && userByUsernameAndPassword.getPassword() != null) {
                HttpSession session = req.getSession();
                session.setAttribute("username", username);
                resp.sendRedirect("/mainMenu.jsp");
            } else {
                error.append("User does not exist!");
                req.setAttribute("error", error);
                getServletContext().getRequestDispatcher("/login.jsp").include(req, resp);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
