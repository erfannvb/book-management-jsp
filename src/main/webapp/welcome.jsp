<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Welcome</title>
    <link rel="stylesheet" href="css/style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body onload="realTimeClock()">

<div class="container border border-2 w-50 mt-2 p-3">
    <div class="text-center">
        <marquee><h1 style="font-size: 22px">Book Management System</h1></marquee>
    </div>
    <div class="mt-3">
        <img src="images/book.jpg" alt="welcome image" class="img-fluid rounded rounded-2">
    </div>
    <hr>
    <div class="mt-3 text-center">
        <button id="register-btn" class="btn btn-primary" style="font-size: 17px">Register</button>
        <button id="login-btn" class="btn btn-success" style="font-size: 17px">Login</button>
    </div>
    <hr>
    <div class="mt-3">
        <div id="clock" class="text-center" style="font-size: 15px; font-weight: bold"></div>
    </div>
    <div class="mt-3">
        <div id="currentDate" class="text-center" style="font-size: 15px; font-weight: bold"></div>
    </div>
</div>

<script>
    let date = new Date();

    let year = date.getFullYear();
    let month = date.getMonth() + 1;
    let day = date.getDate();

    document.getElementById('currentDate').innerHTML = month + '/' + day + '/' + year;
</script>

<script src="js/clock.js"></script>
<script src="js/script.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
</body>
</html>
