package nvb.dev.bookmanagementjsp.repository;

import nvb.dev.bookmanagementjsp.entity.User;

import java.util.List;

public interface UserRepository {

    void registerUser(User user);

    List<User> getAllUsers();

    User getUserByUsernameAndPassword(String username, String password);

}
