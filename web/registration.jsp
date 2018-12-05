
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
        <form class="form" action="registrationhero" method="post">
            <label for="name">Name</label>
            <input id="name" name="name" type="text">


            <label for="uni">Universal</label>
            <input id="uni" name="uni" type="text">



            <label for="power">Power</label>
            <input id="power" name="power" type="text">



            <label for="description">Description</label>
            <input id="description" name="description" type="text">
            <input class="button" type="submit">
        </form>

        <p>${error}</p>

    </div>
</div>


</body>
</html>