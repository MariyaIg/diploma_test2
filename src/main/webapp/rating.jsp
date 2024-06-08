<%@ page import="com.ignateva.entity.Rating" %><%--
  Created by IntelliJ IDEA.
  User: Мария
  Date: 11.05.2024
  Time: 18:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Результат</title>
    <link href = "${pageContext.request.contextPath}/views/rating_style.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <style>
        <%@include file="views/rating_style.css"%>
    </style>

</head>
<body>
<nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">

        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="views/user/enter_page.html">EXIT</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="form.jsp">К форме</a>
                </li>



            </div>
        </div>
    </div>
</nav>



<div class="container">

            <div class="row row-cols-2">
                <div class="col">Баллы по финансам </div>
                <div class="col">
                    <% Rating rating = (Rating)(request.getAttribute("rating"));%>
                    <p><%=rating.getFinancial_score()%> финансовое состояние:
                    <%=request.getAttribute("position1")%></p>
                </div>
                <div class="col">Риск отрасли</div>
                <div class="col">

                    <p><%=request.getAttribute("IndustryRisk")%>
                    </p>
                </div>
                <div class="col">Итоговый рейтинг</div>
                <div class="col">

                    <p><%=rating.getTotal_score()%> балл с учетом отрасли:
                        <%=request.getAttribute("position2")%></p>

                    </div>
            </div>

    </div>

   <div class="box2">

                <div class="row row-cols-1">

                    <div class="col">
                        <% if (request.getAttribute("title")!=null)%>
                        <p>
                            <%=request.getAttribute("title")%></p>
                    </div>

                    <div class="col">
                        <% if (request.getAttribute("taxId")!=null)%>
                        <p> ИНН <%=request.getAttribute("taxId")%></p>
                    </div>
                    <div class="col">
                        <% if (request.getAttribute("date")!=null)%>
                        <p> отчетная дата <%=request.getAttribute("date")%></p>
                    </div>
                </div>

   </div>

<div class ="container">

        <% if (request.getAttribute("mess")!=null)%>
        <p><%=request.getAttribute("mess")%></p>

</div>



</body>
</html>
