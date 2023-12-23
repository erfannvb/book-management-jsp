package nvb.dev.bookmanagementjsp.repository;

import nvb.dev.bookmanagementjsp.entity.User;

import java.util.List;

public interface UserRepository {

    void registerUser(User user);

    void updateUser(User user);

    List<User> getAllUsers();

    User getUserById(Long id);

    User getUserByUsernameAndPassword(String username, String password);

    void deleteUserById(Long id);

}
