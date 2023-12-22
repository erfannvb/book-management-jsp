<%@ page import="nvb.dev.bookmanagementjsp.repository.BookRepository" %>
<%@ page import="nvb.dev.bookmanagementjsp.repository.impl.BookRepositoryImpl" %>
<%@ page import="nvb.dev.bookmanagementjsp.entity.Book" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/style.css">
    <title>View Book</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>

<%
    long id = Long.parseLong(request.getParameter("id"));
    BookRepository bookRepository = new BookRepositoryImpl();
    Book currentBook = bookRepository.getBookById(id);
%>

<div class="container border border-2 w-50 mt-3 p-3">
    <h2 class="text-center">Edit Book</h2>
    <form action='edit?id=<%= id %>' method="post">
        <div class="mb-3">
            <label for="bookName" class="form-label">Book Name</label>
            <input type="text" class="form-control" id="bookName" name="bookName"
                   value="<%= currentBook.getBookName() %>" readonly>
        </div>
        <div class="mb-3">
            <label for="bookEdition" class="form-label">Book Edition</label>
            <input type="text" class="form-control" id="bookEdition" name="bookEdition"
                   value="<%= currentBook.getBookEdition() %>" readonly>
        </div>
        <div class="mb-3">
            <label for="bookPrice" class="form-label">Book Price</label>
            <input type="text" class="form-control" id="bookPrice" name="bookPrice"
                   value="<%= currentBook.getBookPrice() %>" readonly>
        </div>
        <div class="text-center">
            <button id="backBtn" type="reset" class="btn btn-danger">Back</button>
        </div>
    </form>
</div>

<script>
    document.getElementById("backBtn").addEventListener("click", () => {
        window.location.href = '/bookList.jsp';
    })
</script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
</body>
</html>
