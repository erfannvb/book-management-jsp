package nvb.dev.bookmanagementjsp.repository;

public class JdbcQueries {

    private JdbcQueries() {
    }

    public static final String INSERT_BOOK = "insert into book(book_name, book_edition, book_price) values(?,?,?)";
    public static final String UPDATE_BOOK = "update book set book_name=?, book_edition=?, book_price=? where id=?";
    public static final String GET_ALL_BOOKS = "select * from book";
    public static final String GET_BOOK_BY_ID = "select * from book where id=?";
    public static final String DELETE_BOOK_BY_ID = "delete from book where id=?";

}
