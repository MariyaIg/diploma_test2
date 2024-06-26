<%@ page import="com.ignateva.entity.CompanyResult" %><%--
  Created by IntelliJ IDEA.
  User: Мария
  Date: 28.05.2024
  Time: 19:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        <%@include file="views/admin_style.css"%>
    </style>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <title>Информация о Компании</title>
</head>
<body>
<nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">

        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div class="navbar-nav">

                <a class="nav-link" href="views/user/enter_page.html">EXIT</a>
                <a class="nav-link" href="admin.jsp">Admin page</a>
            </div>
        </div>
    </div>
</nav>
<div class ="res">
    <table class="table1">
        <thead>
        <h1>Информация о компании</h1>
        <tr>
            <th scope="col">ИНН</th>
            <th scope="col">Наименование</th>
            <th scope="col">Риск отрасли </th>
            <th scope="col">Итоговый балл/актуальный </th>
            <th scope="col">Отчетная дата/последняя актуальная </th>
        </tr>
        </thead>
        <tbody>

        <%CompanyResult c = (CompanyResult) request.getAttribute("companyResult");%>

        <p>

            <tr>
                <td><%=c.getTaxId()%></td>
                <td><%=c.getTitle()%></td>
                <td><%=c.getIndustry_risk()%></td>
                <td><%=c.getFinal_score()%></td>
                <td><%=c.getAccounts_date()%></td>
            </tr>


        </p>

        </tbody>
    </table>
</div>
</body>

</html>
