package nvb.dev.bookmanagementjsp.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import nvb.dev.bookmanagementjsp.entity.User;
import nvb.dev.bookmanagementjsp.repository.UserRepository;
import nvb.dev.bookmanagementjsp.repository.impl.UserRepositoryImpl;

import java.io.IOException;

@WebServlet(name = "RegisterUserServlet", urlPatterns = "/register")
public class RegisterUserServlet extends HttpServlet {

    private UserRepository userRepository;
    private ObjectMapper objectMapper;

    @Override
    public void init() throws ServletException {
        userRepository = new UserRepositoryImpl();
        objectMapper = new ObjectMapper();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {

            String username = req.getParameter("username");
            String firstName = req.getParameter("firstName");
            String lastName = req.getParameter("lastName");
            String age = req.getParameter("age");
            String password = req.getParameter("pwd");

            User user = new User();
            user.setUsername(username);
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setAge(Integer.parseInt(age));
            user.setPassword(password);

            String successMsg = username + " registered successfully!";
            req.setAttribute("success", successMsg);

            String userJson = objectMapper.writeValueAsString(user);
            req.setAttribute("jsonBody", userJson);

            getServletContext().getRequestDispatcher("/register.jsp").forward(req, resp);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
