package nvb.dev.bookmanagementjsp.repository.impl;

import nvb.dev.bookmanagementjsp.connection.JdbcConnection;
import nvb.dev.bookmanagementjsp.entity.User;
import nvb.dev.bookmanagementjsp.repository.UserRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static nvb.dev.bookmanagementjsp.repository.JdbcQueries.GET_USERNAME_AND_PASSWORD;
import static nvb.dev.bookmanagementjsp.repository.JdbcQueries.INSERT_USER;

public class UserRepositoryImpl implements UserRepository {

    private static final String CONNECTION_ERROR = "Error getting the connection.";

    private static final String USER_ID = "id";
    private static final String USER_NAME = "username";
    private static final String FIRST_NAME = "first_name";
    private static final String LAST_NAME = "last_name";
    private static final String AGE = "age";
    private static final String PASSWORD = "password";

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    @Override
    public void registerUser(User user) {
        try {

            connection = JdbcConnection.getConnection();
            if (connection != null) {

                preparedStatement = connection.prepareStatement(INSERT_USER);

                preparedStatement.setString(1, user.getUsername());
                preparedStatement.setString(2, user.getFirstName());
                preparedStatement.setString(3, user.getLastName());
                preparedStatement.setInt(4, user.getAge());
                preparedStatement.setString(5, user.getPassword());

                preparedStatement.execute();

            } else {
                System.out.println(CONNECTION_ERROR);
            }

        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        } finally {
            closeConnection();
            closePreparedStatement();
        }
    }

    @Override
    public User getUserByUsernameAndPassword(String username, String password) {
        User user = new User();
        try {

            connection = JdbcConnection.getConnection();
            if (connection != null) {

                preparedStatement = connection.prepareStatement(GET_USERNAME_AND_PASSWORD);

                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);

                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    user.setId(resultSet.getLong(USER_ID));
                    user.setUsername(resultSet.getString(USER_NAME));
                    user.setFirstName(resultSet.getString(FIRST_NAME));
                    user.setLastName(resultSet.getString(LAST_NAME));
                    user.setAge(resultSet.getInt(AGE));
                    user.setPassword(resultSet.getString(PASSWORD));
                }

            } else {
                System.out.println(CONNECTION_ERROR);
            }

        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        } finally {
            closeConnection();
            closePreparedStatement();
            closeResultSet();
        }
        return user;
    }

    private void closeConnection() {
        try {
            JdbcConnection.closeConnection(connection);
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private void closePreparedStatement() {
        try {
            JdbcConnection.closePreparedStatement(preparedStatement);
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private void closeResultSet() {
        try {
            JdbcConnection.closeResultSet(resultSet);
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
