package nvb.dev.bookmanagementjsp.repository;

import nvb.dev.bookmanagementjsp.entity.Book;

import java.util.List;

public interface JdbcRepository {

    void addBook(Book book);

    void updateBook(Book book);

    List<Book> getAllBooks();

    Book getBookById(Long id);

    void deleteBookById(Long id);

}
