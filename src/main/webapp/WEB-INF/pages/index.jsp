<%@ page isELIgnored="false" %>
<%@ page language ="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Главная Страница</title>
</head>
<body>

<table border="1" width="80%">
    <tr>
        <th>ID</th>
        <th>Производитель</th>
        <th>Модель</th>
        <th>Серийный номер</th>
        <th></th>
    </tr>
    <c:forEach items="${allAutos}" var="item">
        <tr>
            <td><c:out value="${item.id}"/></td>
            <td><c:out value="${item.supplier}"/></td>
            <td><c:out value="${item.mark}"/></td>
            <td><c:out value="${item.serialNumber}"/></td>
            <td><a href="auto_show?id=${item.id}">Подробнее</a></td>
        </tr>
    </c:forEach>
</table>
<a href="add_auto_form">Новый автомобиль</a><br/>
<a href="orders_show">Посмотреть заказы</a><br/>
</body>
</html>
