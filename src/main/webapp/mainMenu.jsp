<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/style.css">
    <title>Main Menu</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>

<%
    String username = (String) session.getAttribute("username");
%>

<div class="container border border-2 w-50 mt-3 p-3">
    <h2 class="text-center">Main Menu</h2>
    <p class="text-center border border-1 rounded-2" style="color: blue">Welcome, <%= username %></p>
    <div class="text-center mt-3">
        <div class="mb-3">
            <button class="btn btn-success" id="addBookBtn">Add New Book</button>
        </div>
        <div class="mb-3">
            <button class="btn btn-success" id="showBookListBtn">Show Book List</button>
        </div>
    </div>
</div>

<div class="container border border-1 border-danger w-50 mt-3 p-3 text-center">
    <form action="logout" method="post">
        <button class="btn btn-danger" type="submit">Logout</button>
    </form>
</div>

<script>
    document.getElementById("addBookBtn").addEventListener("click", () => {
        window.location.href = '/addBook.jsp';
    })
    document.getElementById("showBookListBtn").addEventListener("click", () => {
        window.location.href = '/bookList.jsp';
    })
</script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
</body>
</html>
