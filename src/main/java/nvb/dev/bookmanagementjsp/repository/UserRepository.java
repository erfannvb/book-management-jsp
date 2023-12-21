package nvb.dev.bookmanagementjsp.repository;

import nvb.dev.bookmanagementjsp.entity.User;

public interface UserRepository {

    void registerUser(User user);

    User getUserByUsernameAndPassword(String username, String password);

}
