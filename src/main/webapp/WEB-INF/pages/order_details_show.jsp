<%@ page isELIgnored="false" %>
<%@ page language ="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>
        Заказ - <c:out value="${order.id}"/>
    </title>
</head>
<body>
<a href="main">На Главную</a>
<table width="25%">
    <tr>
        <td>Id Заказа</td>
        <td><c:out value="${order.id}"/></td>
    </tr>
    <tr>
        <th>Заказчик</th>
        <th></th>
    </tr>
    <tr>
        <td>Имя</td>
        <td><c:out value="${order.customer.firstName}"/></td>
    </tr>
    <tr>
        <td>Фамилия</td>
        <td><c:out value="${order.customer.lastName}"/></td>
    </tr>
    <tr>
        <td>Телефон</td>
        <td><c:out value="${order.customer.phone}"/></td>
    </tr>
    <tr>
        <td>Email</td>
        <td><c:out value="${order.customer.email}"/></td>
    </tr>
    <tr>
        <td>Адрес</td>
        <td><c:out value="${order.customer.address}"/></td>
    </tr>
</table>

<table border="1px" width="40%" title="Т.Т.Х.">
    <tr>
        <th>Данные Автомобиля</th>
        <th><a href="auto_show?id=${order.auto.id}">Подробнее</a></th>
    </tr>
    <tr>
        <td>Объем Двигателя л.</td>
        <td><c:out value="${order.auto.engineCapacity}"/></td>
    </tr>
    <tr>
        <td>Мощность Двигателя л.с.</td>
        <td><c:out value="${order.auto.enginePower}"/></td>
    </tr>
    <tr>
        <td>Объем Топливного Бака л.</td>
        <td><c:out value="${order.auto.fuelCapacity}"/></td>
    </tr>
    <tr>
        <td>Потребление Топлива л./100 км.</td>
        <td><c:out value="${order.auto.fuelConsumption}"/></td>
    </tr>
    <tr>
        <td>Коробка передач</td>
        <td>
            <c:choose>
                <c:when test="${order.auto.autoGearBox == true}">Автомат</c:when>
                <c:when test="${order.auto.autoGearBox == false}">Механическая</c:when>
            </c:choose>
        </td>
    </tr>
    <tr>
        <td>Масса кг.</td>
        <td><c:out value="${order.auto.mass}"/></td>
    </tr>
</table>

<table width="40%">
    <tr>
        <td>Статус</td>
        <td><c:out value="${order.status}"/></td>
    </tr>
    <c:if test="${sReserved != null}">
        <tr>
            <td>Дата бронирования</td>
            <td><c:out value="${sReserved}"/></td>
        </tr>
    </c:if>
    <c:if test="${sArrived != null}">
        <tr>
            <td>Дата прибытия на склад</td>
            <td><c:out value="${sArrived}"/></td>
        </tr>
    </c:if>
    <c:if test="${sTesting!= null}">
        <tr>
            <td>Начат тест-драйв</td>
            <td><c:out value="${sTesting}"/></td>
        </tr>
    </c:if>
    <c:choose>
        <c:when test="${sFinished != null}">
            <tr>
                <th>Заказ Совершен</th>
                <th><c:out value="${sFinished}"/></th>
            </tr>
        </c:when>
        <c:when test="${sDenied != null}">
            <tr>
                <th>Заказ Отменен</th>
                <th><c:out value="${sDenied}"/></th>
            </tr>
        </c:when>
    </c:choose>
</table>
<c:if test="${order.status == 'Arrived'}">
    <a href="order_start_test_drive?id=${order.id}">Начался тест-драйв</a><br/>
</c:if>
<c:if test="${order.status == 'Test Diving' or order.status == 'Arrived'}">
    <a href="order_finish?id=${order.id}&denied=0">Заказ подтвержден</a><br/>
    <a href="order_finish?id=${order.id}&denied=1">Заказ отменен</a><br/>
</c:if>

</body>
</html>
