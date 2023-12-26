package nvb.dev.bookmanagementjsp.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import nvb.dev.bookmanagementjsp.entity.User;
import nvb.dev.bookmanagementjsp.repository.UserRepository;
import nvb.dev.bookmanagementjsp.repository.impl.UserRepositoryImpl;

import java.io.IOException;
import java.util.List;

@WebFilter(filterName = "RegisterUserFilter", servletNames = "RegisterUserServlet", urlPatterns = "/register")
public class RegisterUserFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        UserRepository userRepository = new UserRepositoryImpl();
        List<User> userList = userRepository.getAllUsers();

        String username = request.getParameter("username");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String age = request.getParameter("age");
        String password = request.getParameter("pwd");

        StringBuilder error = new StringBuilder();

        for (User user : userList) {
            if (user.getUsername().equals(username)) {
                error.append("User with this username already exists!");
                servletRequest.setAttribute("error", error);
                RequestDispatcher dispatcher = servletRequest.getRequestDispatcher("/register.jsp");
                dispatcher.include(request, response);
            } else if (username == null || username.isBlank() || firstName == null || firstName.isBlank() ||
                    lastName == null || lastName.isBlank() || age == null || age.isBlank() ||
                    password == null || password.isBlank()) {
                error.append("Fill in all the fields.");
                servletRequest.setAttribute("error", error);
                RequestDispatcher dispatcher = servletRequest.getRequestDispatcher("/register.jsp");
                dispatcher.include(request, response);
            } else {
                filterChain.doFilter(request, response);
            }
        }

    }
}
