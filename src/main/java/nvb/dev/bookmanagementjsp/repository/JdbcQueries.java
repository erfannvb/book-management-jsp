package nvb.dev.bookmanagementjsp.repository;

public class JdbcQueries {

    private JdbcQueries() {
    }

    // Book
    public static final String INSERT_BOOK = "insert into book(book_name, book_edition, book_price) values(?,?,?)";
    public static final String UPDATE_BOOK = "update book set book_name=?, book_edition=?, book_price=? where id=?";
    public static final String GET_ALL_BOOKS = "select * from book order by id asc";
    public static final String GET_BOOK_BY_ID = "select * from book where id=?";
    public static final String DELETE_BOOK_BY_ID = "delete from book where id=?";

    // User
    public static final String INSERT_USER = "insert into users(username, first_name, last_name," +
            " age, password) " +
            "values (?,?,?,?,?)";
    public static final String UPDATE_USER = "update users set username=?, first_name=?, last_name=?," +
            "age=?, password=? where id=?";
    public static final String GET_ALL_USERS = "select * from users order by id asc";
    public static final String GET_USER_BY_ID = "select * from users where id=?";
    public static final String GET_USERNAME_AND_PASSWORD = "select * from users where username=? and password=?";
    public static final String DELETE_USER_BY_ID = "delete from users where id=?";

}
