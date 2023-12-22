<%@ page import="nvb.dev.bookmanagementjsp.repository.BookRepository" %>
<%@ page import="nvb.dev.bookmanagementjsp.repository.impl.BookRepositoryImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="nvb.dev.bookmanagementjsp.entity.Book" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/style.css">
    <title>Book List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>

<%
    PrintWriter writer = response.getWriter();
    BookRepository bookRepository = new BookRepositoryImpl();
    List<Book> bookList = bookRepository.getAllBooks();

    if (!bookList.isEmpty()) {
        writer.println("<body>");
        writer.println("<div class='container border border-2 w-50 mt-3 p-3'>");
        writer.println("<h2 class='text-center'>Book List</h2>");
        writer.println("<div class='table-responsive'>");
        writer.println("<table class='table table-bordered table-striped'>");
        writer.println("<tr>");
        writer.println("<th>Book Id</th>");
        writer.println("<th>Book Name</th>");
        writer.println("<th>Book Edition</th>");
        writer.println("<th>Book Price</th>");
        writer.println("<th>Edit Book</th>");
        writer.println("<th>Delete Book</th>");
        writer.println("</tr>");

        for (Book book : bookList) {
            writer.println("<tr>");
            writer.println("<td>" + book.getId() + "</td>");
            writer.println("<td>" + book.getBookName() + "</td>");
            writer.println("<td>" + book.getBookEdition() + "</td>");
            writer.println("<td>" + book.getBookPrice() + "</td>");
            writer.println("<td style='text-align: center;'><a href='editBook.jsp?id="
                    + book.getId() + "'>Edit</a></td>");
            writer.println("<td style='text-align: center;'><a href='delete?id="
                    + book.getId() + "'>Delete</a></td>");
            writer.println("</tr>");
        }

        writer.println("</table>");
        writer.println("</div>");
        writer.println("</div>");

        writer.println("<div class='text-center mt-3'>");
        writer.println("<button id='backBtn' type='reset' class='btn btn-danger'>Back</button>");
        writer.println("</div>");
        writer.println("</body>");
    } else {
        writer.println("<h2 style='color: crimson;'>There is no book in the list !!!</h2>");
    }
%>

<script>
    document.getElementById("backBtn").addEventListener("click", () => {
        window.location.href = '/mainMenu.jsp';
    })
</script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
</body>
</html>
