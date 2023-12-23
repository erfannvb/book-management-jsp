package nvb.dev.bookmanagementjsp.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import nvb.dev.bookmanagementjsp.entity.User;
import nvb.dev.bookmanagementjsp.repository.UserRepository;
import nvb.dev.bookmanagementjsp.repository.impl.UserRepositoryImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "UserListServlet", urlPatterns = "/userList")
public class UserListServlet extends HttpServlet {

    private UserRepository userRepository;

    @Override
    public void init() throws ServletException {
        userRepository = new UserRepositoryImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<User> userList = userRepository.getAllUsers();

            if (!userList.isEmpty()) {
                req.setAttribute("userList", userList);
            } else {
                StringBuilder error = new StringBuilder();
                error.append("There is no user in the list.");
                req.setAttribute("error", error);
            }

            getServletContext().getRequestDispatcher("/userList.jsp").forward(req, resp);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
