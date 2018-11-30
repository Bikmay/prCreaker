
<%@ page import="servlets.HeroServlet" %>
<%@ page import="dao.Database" %>
<%@ page import="java.sql.Array" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="models.Hero" %>
<%@ page import="java.sql.SQLException" %><%--
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
  <div>
    <table cellpadding="0" cellspacing="0" border="0">
      <thead>
      <tr>
        <th>logo</th>
        <th>Name</th>
        <th>Universe</th>
        <th>Power</th>
        <th>Description</th>
      </tr>
      </thead>
    </table>
  </div>
  <div class="tbl-content">
    <%

    %>
  <table class="table" cols="5">
    <tbody class="table">
      <!--<tr class="row" align="center" valign="middle">
        <td class="hero">
          <img class="hero-img" src="img/default.png" alt="">
        </td>
        <td>Andrey</td>
        <td>marvel</td>
        <td>12</td>
        <td>sadasdasdasdd</td>
      </tr>
      <tr class="row" align="center" valign="middle">
        <td class="hero">
          <img class="hero-img" src="img/default.png" alt="">
        </td>
        <td>Andrey</td>
        <td>marvel</td>
        <td>12</td>
        <td>sadasdasdasdd</td>
      </tr>
      <tr class="row" align="center" valign="middle">
        <td class="hero">
          <img class="hero-img" src="img/default.png" alt="">
        </td>
        <td>Andrey</td>
        <td>marvel</td>
        <td>12</td>
        <td>sadasdasdasdd</td>
      </tr>
      <tr class="row" align="center" valign="middle">
        <td class="hero">
          <img class="hero-img" src="img/default.png" alt="">
        </td>
        <td>Andrey</td>
        <td>marvel</td>
        <td>12</td>
        <td>sadasdasdasdd</td>
      </tr>

-->




      <%=Database.getA() %>
    <c:forEach var="row" items="$listHeros">

      <td class="hero">
        <img class="hero-img" src="" alt="">
      </td>
      <td><c:out value="${row.name}"/>;</td>
      <td><c:out value="${row.universe}"/>;</td>
      <td><c:out value="${row.power}"/>;</td>
      <td><c:out value="${row.description}"/>;</td>
      </tr>
    </c:forEach>

    </tbody>
  </table>
  </div>
  <button class="button-create">Create hero</button>
</div>

</body>
</html>