
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


<div class="all">
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

  <table class="table" cols="5">
    <tbody class="table">



      <%
        ArrayList<Hero> list = (ArrayList<Hero>) request.getAttribute("listHeros");

        for (int i = 0; i <list.size() ; i++) {


      %>

        <tr class="row">
        <td><img class="hero-img" src=<%=list.get(i).logo%> alt=""></td>
        <td><%=list.get(i).name%></td>
        <td><%=list.get(i).universe%></td>
        <td><%=list.get(i).power%></td>
        <td><%=list.get(i).description%></td>

      </tr>


      <%
        }
      %>






    </tbody>
  </table>
  </div>
  <button id="button" class="button-create">Create hero</button>
  <script>
    var button = document.getElementById("button");
    button.onclick=function () {
        document.location.href="/prCreaker_war_exploded/registration"
    }
  </script>
</div>
</div>
</body>
</html>