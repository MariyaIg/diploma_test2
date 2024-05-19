<%--
  Created by IntelliJ IDEA.
  User: Мария
  Date: 05.05.2024
  Time: 6:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ФОРМА заполнения</title>
    <link href = "${pageContext.request.contextPath}/views/form_style.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <style>
        <%@include file="views/form_style.css"%>
    </style>
</head>
<body>
<nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">

        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">

            <div class="navbar-nav">

                <a class="nav-link" href="views/user/enter_page.html">EXIT</a>

            </div>
        </div>
    </div>
</nav>

        <h1>
        Заполните
        </h1>
         <form method = POST action="form-servlet">
            <div class="mb-3">
                <label>Наименование компании</label><br>
                <input type="text" id="title" name ="title">
            </div>

            <div class="mb-3">
                <label >ИНН</label><br>
                <div class="mb-3">
                    <input type="number" required id="tax" name="taxId">
                </div>
            </div>
            <div class="mb-3">
                <label >ОКВЭД</label><br>
                <div class="mb-3">
                    <input type="text" id="industry" name="industryCode">
                </div>
            </div>


    <div class="mb-3">
        <label >Отчетный период</label><br>
        <div class="mb-3">
            <input type="date" required id=date name="date">
        </div>
    </div>
    <table class="accounts">
        <thead>
        <tr>
            <th>Данные</th>
            <th>Сумма, тыс руб</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>Текущие активы (РСБУ стр 1200 ф1)</td>
            <td><input type="number" id="1200" name="1200"></td>
        </tr>
        <tr>
            <td>Собственный капитал (РСБУ стр 1300 ф1)</td>
            <td><input type="number" id="1300" name="1300"></td>
        </tr>
        <tr>
            <td>Текущие обязательства (РСБУ стр 1500 ф1)</td>
            <td><input type="number" id="1500" name="1500"></td>
        </tr>
        <tr>
            <td>Долгосрочный долг (РСБУ стр 1410 ф1)</td>
            <td><input type="number" id="1410" name="1410"></td>
        </tr>
        <tr>
            <td>Краткосрочный долг (РСБУ стр 1510 ф1)</td>
            <td><input type="number" id="1510" name="1510"></td>
        </tr>
        <tr>
            <td>Валюта баланса (РСБУ стр 1700 ф1)</td>
            <td><input type="number" id="1700" name="1700"></td>
        </tr>
        <tr>
            <td>Выручка текущий период (РСБУ стр 2110 ф2)</td>
            <td><input type="number" id="2110" name="2110"></td>
        </tr>
        <tr>
            <td>Выручка прошлый период (РСБУ стр 2110 ф2)</td>
            <td><input type="number" id="2110_2" name="2110_2"></td>
        </tr>
        <tr>
            <td>Прибыль операционная/от продаж (РСБУ стр 2200 ф2)</td>
            <td><input type="number" id="2200" name="2200"></td>
        </tr>
        <tr>
            <td>Прибыль чистая (РСБУ стр 2400 ф2)</td>
            <td><input type="number" id="2400" name="2400"></td>
        </tr>
        </tbody>
    </table>

    <button type="submit" class="btn btn-primary">Submit</button>
</form>
<div class ="container">
    <form method = POST action="result-servlet">
        <input type="hidden" name ="title" value =${param.title}>
        <input type="hidden" name="taxId" value=${param.taxId}>
        <input type="hidden" name="date" value=${param.date}>
    <button type="submit" class="btn btn-success">Рассчитать</button>

    </form>
</div>
<div class="alert">
    <span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span>
    <% if (request.getAttribute("res")!=null)%>
    <p><%=request.getAttribute("res")%></p>
    <p><%request.getAttribute("accounts1");%></p>
    <form method = POST action="form-servlet">
        <div class="form-check">
            <input class="form-check-input" type="radio" name="check1" id="flexRadioDefault1" value = <%request.getAttribute("accounts1");%>>
            <label class="form-check-label" for="flexRadioDefault1">
                обновить данные за текущий период
            </label>
        </div>
        <div class="form-check">
            <input class="form-check-input" type="radio" name="check1" id="flexRadioDefault2" value = "old1" checked>
            <label class="form-check-label" for="flexRadioDefault2">
                использовать существующие
            </label>
        </div>

    <% if (request.getAttribute("res2")!=null)%>
    <p><%=request.getAttribute("res2")%></p>
    <p><%request.getAttribute("accounts2");%></p>
        <form method = POST action="form-servlet">
            <div class="form-check">
                <input class="form-check-input" type="radio" name="check2" id="flexRadioDefault3" value = <%request.getAttribute("accounts2");%>>
                <label class="form-check-label" for="flexRadioDefault1">
                    обновить данные по выручке за прошлый период
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="check2" id="flexRadioDefault4" value = "old2" checked>
                <label class="form-check-label" for="flexRadioDefault2">
                    использовать прежние
                </label>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
    </form>

</div>

</body>
</html>
