<%@ page import="java.util.List" %>
<%@ page import="com.ignateva.entity.CompanyResult" %><%--
  Created by IntelliJ IDEA.
  User: Мария
  Date: 25.05.2024
  Time: 10:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="ctg" uri="customtags" %>
<html>
<head>
    <title>Cписок компаний</title>
</head>
<body>
<%List<CompanyResult> lc = (List)request.getAttribute("listOfCompanies");%>
<ctg:table rows="${lc.size}" head="Список">
    <%for (CompanyResult c: lc) {%>
    <tr>
        <td><%=c.getTaxId()%></td>
        <td><%=c.getTitle()%></td>
        <td><%=c.getIndustry_risk()%></td>
        <td><%=c.getFinal_score()%></td>
        <td><%=c.getAccounts_date()%></td>
    </tr>
    <%}%>
</ctg:table>

</body>
</html>
