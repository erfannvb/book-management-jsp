package nvb.dev.bookmanagementjsp.repository.impl;

import nvb.dev.bookmanagementjsp.connection.JdbcConnection;
import nvb.dev.bookmanagementjsp.entity.Book;
import nvb.dev.bookmanagementjsp.repository.BookRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static nvb.dev.bookmanagementjsp.repository.JdbcQueries.*;

public class BookRepositoryImpl implements BookRepository {

    private static final String CONNECTION_ERROR = "Error getting the connection.";

    private static final String BOOK_ID = "id";
    private static final String BOOK_NAME = "book_name";
    private static final String BOOK_EDITION = "book_edition";
    private static final String BOOK_PRICE = "book_price";

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    @Override
    public void addBook(Book book) {
        try {

            connection = JdbcConnection.getConnection();
            if (connection != null) {

                preparedStatement = connection.prepareStatement(INSERT_BOOK);

                preparedStatement.setString(1, book.getBookName());
                preparedStatement.setString(2, book.getBookEdition());
                preparedStatement.setFloat(3, book.getBookPrice());

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
    public void updateBook(Book book) {
        try {

            connection = JdbcConnection.getConnection();
            if (connection != null) {

                preparedStatement = connection.prepareStatement(UPDATE_BOOK);

                preparedStatement.setString(1, book.getBookName());
                preparedStatement.setString(2, book.getBookEdition());
                preparedStatement.setFloat(3, book.getBookPrice());
                preparedStatement.setLong(4, book.getId());

                preparedStatement.executeUpdate();

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
    public List<Book> getAllBooks() {
        List<Book> bookList = new ArrayList<>();
        try {

            connection = JdbcConnection.getConnection();
            if (connection != null) {

                preparedStatement = connection.prepareStatement(GET_ALL_BOOKS);

                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    Book book = new Book();
                    book.setId(resultSet.getLong(BOOK_ID));
                    book.setBookName(resultSet.getString(BOOK_NAME));
                    book.setBookEdition(resultSet.getString(BOOK_EDITION));
                    book.setBookPrice(resultSet.getFloat(BOOK_PRICE));
                    bookList.add(book);
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
        return bookList;
    }

    @Override
    public Book getBookById(Long id) {
        Book book = new Book();
        try {

            connection = JdbcConnection.getConnection();
            if (connection != null) {

                preparedStatement = connection.prepareStatement(GET_BOOK_BY_ID);
                preparedStatement.setLong(1, id);

                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    book.setId(resultSet.getLong(BOOK_ID));
                    book.setBookName(resultSet.getString(BOOK_NAME));
                    book.setBookEdition(resultSet.getString(BOOK_EDITION));
                    book.setBookPrice(resultSet.getFloat(BOOK_PRICE));
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
        return book;
    }

    @Override
    public void deleteBookById(Long id) {
        try {

            connection = JdbcConnection.getConnection();
            if (connection != null) {

                preparedStatement = connection.prepareStatement(DELETE_BOOK_BY_ID);
                preparedStatement.setLong(1, id);
                preparedStatement.executeUpdate();

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
