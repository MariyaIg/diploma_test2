<%@ page import="com.ignateva.entity.CompanyResult" %>
<%@ page import="java.util.List" %>
<%@ page import="com.ignateva.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: Мария
  Date: 28.05.2024
  Time: 17:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        <%@include file="views/admin_style.css"%>
    </style>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <title>Компании и рейтинги</title>
</head>
<body>
<nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">

        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div class="navbar-nav">

                <a class="nav-link" href="views/user/enter_page.html">Выход</a>
                <a class="nav-link" href="admin.html">Назад</a>
                <a class="nav-link" href="form.jsp">К форме</a>
            </div>
        </div>
    </div>
</nav>
<div class ="res">
<table class="table1">
    <thead>
    <h1>Список пользователей</h1>
    <tr>
        <th scope="col">Имя</th>
        <th scope="col">Логин</th>

    </tr>
    </thead>
    <tbody>

    <%List<User> lc = (List)request.getAttribute("users");%>
    <p>
            <%for (User c: lc) {%>
            <tr>
                <td><%=c.getName()%></td>
                <td><%=c.getLogin()%></td>

            </tr>
            <%}%>

    </p>

    </tbody>
</table>
</div>
</body>

</html>
