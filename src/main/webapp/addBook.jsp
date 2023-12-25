<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Add Book Page</title>
    <link rel="stylesheet" href="css/style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-md-6 offset-md-3 mt-3">
            <div class="card">
                <div class="card-header text-center fs-3">Add New Book</div>
                <div class="card-body">
                    <form action="addBook" method="post">
                        <div class="mb-3">
                            <label for="bookName" class="form-label">Book Name</label>
                            <input type="text" class="form-control" id="bookName" name="bookName">
                        </div>
                        <div class="mb-3">
                            <label for="bookEdition" class="form-label">Book Edition</label>
                            <input type="text" class="form-control" id="bookEdition" name="bookEdition">
                        </div>
                        <div class="mb-3">
                            <label for="bookPrice" class="form-label">Book Price</label>
                            <input type="text" class="form-control" id="bookPrice" name="bookPrice">
                        </div>
                        <div class="text-center">
                            <button type="submit" class="btn btn-primary">Add Book</button>
                            <button id="backBtn" type="reset" class="btn btn-danger">Back</button>
                        </div>
                        <div class="mt-3 text-center">
                            <p class="text-success" style="font-size: 17px">${success}</p>
                            <p class="text-warning" style="font-size: 17px">${jsonBody}</p>
                            <p class="text-danger" style="font-size: 17px">${error}</p>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

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
