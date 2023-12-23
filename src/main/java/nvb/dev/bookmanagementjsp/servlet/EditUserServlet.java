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

@WebServlet(name = "EditUserServlet", urlPatterns = "/editUser")
public class EditUserServlet extends HttpServlet {

    private UserRepository userRepository;

    @Override
    public void init() throws ServletException {
        userRepository = new UserRepositoryImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            long id = Long.parseLong(req.getParameter("id"));
            String username = req.getParameter("username");
            String firstName = req.getParameter("firstName");
            String lastName = req.getParameter("lastName");
            int age = Integer.parseInt(req.getParameter("age"));
            String password = req.getParameter("password");

            User user = new User(id, username, firstName, lastName, age, password);
            userRepository.updateUser(user);

            String successMsg = "User Updated Successfully!!!";
            req.setAttribute("success", successMsg);

            getServletContext().getRequestDispatcher("/editUser.jsp").forward(req, resp);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
