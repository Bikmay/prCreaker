
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Registration</title>

    <link rel="stylesheet" href="css/registration.css">
</head>
<body>

<div class="gen">
    <div class="card">

        <h1>Registration hero</h1>
        <form class="form" action="registrationhero"  method="post”>
        <div class="inputs">
            <div>
            <label for="name">Name</label>
            <input id="name" name="name" type="text">
        </div>
            <div>
                <label for="uni">Universe</label>
                <input id="uni" name="uni" type="text">
            </div>

            <div>
                <label for="power">Power</label>
                <input id="power" name="power" type="text">
            </div>

            <div>
                <label for="description">Description</label>
                <input id="description" name="description" type="text">
            </div>
        <input type="submit" class="button">
        <p>${error}</p>
        </div>

    </form>
    </div>
</div>


</body>
</html>