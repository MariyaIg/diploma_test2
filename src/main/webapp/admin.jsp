<%@ page import="com.ignateva.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: Мария
  Date: 09.05.2024
  Time: 18:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin page</title>
    <style>
        <%@include file="views/admin_style.css"%>
    </style>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="http://code.jquery.com/jquery-2.2.4.js"
            type="text/javascript">
        <%@include file="progress.js"%></script>
    <script src="progress.js" type="text/javascript"></script>
</head>
<body >
<nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">

        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div class="navbar-nav">

                <a class="nav-link" href="views/user/enter_page.html">Выход</a>

            </div>
        </div>
    </div>
</nav>



<div class="container text-center">
    <div class="row align-items-center">
        <div class="col">
            <div class="bg-img1">
                <h1>Действия с пользователями</h1>

                <div class="options1">
                    <a href="views/user/registration.html"><p>Регистрация</p></a>
                    <p>Смена пароля</p>
                    <form th:method = POST action="updateUser-servlet">
                        <div class="mb-3">
                            <label>Имя пользователя(login)</label><br>
                               <input type="text" id="login1" name ="login1"><br>
                            <label >Новый Пароль</label><br>
                            <div class="mb-3">
                                <input type="password" id="inputPassword" name="pass">
                            </div>
                            <button type="submit" class="btn btn-primary">Выполнить</button>
                        </div>

                    </form>
                    <p>Удаление пользователя</p>
                    <form th:method = POST action="deleteUser-servlet">
                        <div class="mb-3">
                            <label>Имя пользователя(login)</label><br>
                            <input type="text" id="login2" name ="login2">
                            <button type="submit" class="btn btn-primary">Выполнить</button>
                        </div>
                    </form>
                    <%--<p>Показать пользователя</p>
                    <form th:method = POST action="findUser-servlet">
                        <div class="mb-3">
                            <label>Имя пользователя(login)</label><br>
                            <input type="text" id="login3" name ="login3">
                            <button type="submit" class="btn btn-primary">Submit</button>
                        </div>
                    </form>
                    <% if (request.getAttribute("res")!=null)%>
                    <%=request.getAttribute("res")%>
                                --%>
                </div>

            </div>

        </div>
        <div class="col">
            <div class="bg-img2">
            <h1>Действия с базой</h1>

                <div class="options2">
                    <p>Удалить компанию из Базы (удаляется вместе с отчетностью и рейтингами)</p>
                    <form th:method = POST action="deleteCompany-servlet">
                        <div class="mb-3">
                            <label >ИНН</label><br>
                            <div class="mb-3">
                                <input type="number" required id="tax2" name="taxId">
                                <button type="submit" class="btn btn-primary">Выполнить</button>
                            </div>
                        </div>

                    </form>
                    <p>Удалить отчетность из Базы</p>
                    <form th:method = POST action="deleteAccounts-servlet">
                        <div class="mb-3">
                            <label >ИНН</label><br>
                            <div class="mb-3">
                                <input type="number" required id="tax" name="taxId">
                            </div>
                        </div>
                        <div class="mb-3">
                            <label >Отчетный период</label><br>
                            <div class="mb-3">
                                <input type="date" required id=date name="date">
                            </div>
                            <button type="submit" class="btn btn-primary">Выполнить</button>

                        </div>

                    </form>
                    <a href="form.jsp"><p>Внести данные/заполнить форму</p></a>

                    <p>загрузить ПЕРВОНАЧАЛЬНО список ОКВЭД и риски из файла excel через путь к файлу/путь указать через двойной\\и наименование файла с расширением</p>
                    <form th:method = POST action = "InitLoad-servlet" >

                        <input type="text"    name="filePath">
                        <button type="submit" class="btn btn-primary">Отправить</button>

                    </form>
                    <p>актуализировать риски отраслей excel через путь к файлу/путь указать через двойной\\и наименование файла с расширением</p>
                    <form th:method = POST action = "loadFilePath-servlet" onload="myFunction()">

                        <input type="text"    name="filePath">
                        <button type="submit" class="btn btn-primary">Отправить</button>

                    </form>


                    <p>актуализировать список ОКВЭД и риски из файла excel </p>
                    <form th:method = POST action = "industry-servlet" enctype="multipart/form-data" >
                        <input type="file" content ="multipart/form-data" accept=".xls,.xlsx"  class="form-control" id="inputGroupFile04" aria-describedby="inputGroupFileAddon04" aria-label="Upload">
                        <button type="submit" class="btn btn-primary">Отправить</button>

                    </form>


            </div>
            </div>

        </div>
        <div class="col">
            <div class="bg-img3">
                <h1>Статистика</h1>
                <div class="options3">
                   <a href="show-servlet"> <p>Показать все компании и их рейтинги</p></a>
                    <p>Показать компании с хорошим фП</p>
                    <p>Показать информацию о компании по ИНН</p>
                    <form th:method = POST action="showCompany-servlet">
                        <div class="mb-3">
                            <label >ИНН</label><br>
                            <div class="mb-3">
                                <input type="number" required id="taxId" name="taxId">
                            </div>
                            <button type="submit" class="btn btn-primary">Выполнить</button>
                        </div>
                    </form>
                    <p>Показать рейтинги, сделанные Пользователем</p>

                </div>
            </div>

        </div>
    </div>

</div>

<%--анимация загрузки javascript--%>
<div style="display:none;" id="loader"></div>

<div style="display:none;" id="myDiv" class="animate-bottom">
    <h2>Ура!</h2>
    <p>Информация загружена</p>
</div>

</body>
</html>
