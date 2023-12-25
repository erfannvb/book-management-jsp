<%@ page import="nvb.dev.bookmanagementjsp.repository.UserRepository" %>
<%@ page import="nvb.dev.bookmanagementjsp.repository.impl.UserRepositoryImpl" %>
<%@ page import="nvb.dev.bookmanagementjsp.entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Edit User</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>

<%
    long id = Long.parseLong(request.getParameter("id"));
    UserRepository userRepository = new UserRepositoryImpl();
    User currentUser = userRepository.getUserById(id);
%>

<div class="container">
    <div class="row">
        <div class="col-md-6 offset-md-3 mt-3">
            <div class="card">
                <div class="card-header text-center fs-3">Edit User</div>
                <div class="card-body">
                    <form action='editUser?id=<%= currentUser.getId() %>' method="post">
                        <div class="mb-3">
                            <label for="username" class="form-label">Username</label>
                            <input type="text" class="form-control" id="username" name="username"
                                   value="<%= currentUser.getUsername() %>">
                        </div>
                        <div class="mb-3">
                            <label for="firstName" class="form-label">First Name</label>
                            <input type="text" class="form-control" id="firstName" name="firstName"
                                   value="<%= currentUser.getFirstName() %>">
                        </div>
                        <div class="mb-3">
                            <label for="lastName" class="form-label">Last Name</label>
                            <input type="text" class="form-control" id="lastName" name="lastName"
                                   value="<%= currentUser.getLastName() %>">
                        </div>
                        <div class="mb-3">
                            <label for="age" class="form-label">Age</label>
                            <input type="number" class="form-control" id="age" name="age"
                                   value="<%= currentUser.getAge() %>">
                        </div>
                        <div class="mb-3">
                            <label for="password" class="form-label">Password</label>
                            <input type="password" class="form-control" id="password" name="password"
                                   value="<%= currentUser.getPassword() %>">
                        </div>
                        <div class="text-center">
                            <button type="submit" class="btn btn-primary">Update User</button>
                        </div>
                        <div class="mt-3 text-center">
                            <p class="text-success" style="font-size: 17px">${success}</p>
                            <p class="text-danger" style="font-size: 17px">${error}</p>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
</body>
</html>
