<%@ page import="dao.Database" %><%--
  Created by IntelliJ IDEA.
  User: Rick
  Date: 26.11.2018
  Time: 23:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Heros</title>

  <link rel="stylesheet" href="css/style.css">
</head>
<body>


<div class="div-gen">
  <table class="table">
    <tbody class="table">
      <tr class="row">
        <td class="hero">
          <img class="hero-img" src="img/default.png" alt="">
          <p>name</p>
        </td>
      </tr>
      <tr class="row">
        <td class="hero">
          <img class="hero-img" src="img/default.png" alt="">
          <p>name</p>
        </td>
      </tr>
      <tr class="row">
        <td class="hero">
          <img class="hero-img" src="img/default.png" alt="">
          <p>name</p>
        </td>
      </tr>
    </tbody>
  </table>
  <button class="button-create">Create hero</button>
</div>

</body>
</html>