<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>User List</title>
    <link rel="stylesheet" href="css/style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>

<div class='container border border-2 w-75 mt-5 p-3'>
    <h2 class="text-center">User List</h2>
    <div class="table-responsive">
        <table class="table table-bordered table-striped table-hover">
            <caption>A table that shows all the registered users.</caption>
            <tr>
                <th style="text-align: center;">ID</th>
                <th style="text-align: center;">Username</th>
                <th style="text-align: center;">First Name</th>
                <th style="text-align: center;">Last Name</th>
                <th style="text-align: center;">Age</th>
                <th style="text-align: center;">View</th>
                <th style="text-align: center;">Edit</th>
                <th style="text-align: center;">Delete</th>
            </tr>
            <c:forEach items="${userList}" var="user">
                <tr>
                    <td style="text-align: center;"><c:out value="${user.id}"/></td>
                    <td style="text-align: center;"><c:out value="${user.username}"/></td>
                    <td style="text-align: center;"><c:out value="${user.firstName}"/></td>
                    <td style="text-align: center;"><c:out value="${user.lastName}"/></td>
                    <td style="text-align: center;"><c:out value="${user.age}"/></td>
                    <td style="text-align: center;"><a href="viewUser.jsp?id=${user.id}">View</a></td>
                    <td style="text-align: center;"><a href="editUser.jsp?id=${user.id}">Edit</a></td>
                    <td style="text-align: center;"><a href="deleteUser?id=${user.id}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>

<div class="text-center mt-3">
    <button id="backBtn" type="reset" class="btn btn-danger">Back</button>
</div>

<div class="container w-75 mt-5 p-3">
    <h4 class="text-center" style="color: crimson">${error}</h4>
</div>

<script>
    document.getElementById("backBtn").addEventListener("click", () => {
        window.location.href = '/register.jsp';
    })
</script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
</body>
</html>
