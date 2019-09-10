<%@ page isELIgnored="false" %>
<%@ page language ="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Все заказы</title>
</head>
<body>
<a href="main">На Главную</a>
<table border="1" width="80%">
    <tr>
        <th>Имя</th>
        <th>Фамилия</th>
        <th>Серийный номер Автомобиля</th>
        <th>Статус</th>
        <th></th>
    </tr>
    <c:forEach items="${allOrders}" var="item">
        <tr>
            <td><c:out value="${item.customer.firstName}"/></td>
            <td><c:out value="${item.customer.lastName}"/></td>
            <td><c:out value="${item.auto.serialNumber}"/></td>
            <td><c:out value="${item.status}"/></td>
            <td><a href="order_details_show?id=${item.id}">Подробнее</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
