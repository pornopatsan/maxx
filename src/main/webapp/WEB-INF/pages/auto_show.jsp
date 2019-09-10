<%@ page isELIgnored="false" %>
<%@ page language ="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>
        <c:out value="${auto.supplier}"/>
        <c:out value="${auto.mark}"/>
        <c:out value="${auto.serialNumber}"/>
    </title>
</head>
<body>
<a href="main">На Главную</a>
<c:if test="${error != ''}">
    <h3><c:out value="${error}"/></h3><br/>
</c:if>
<table width="25%">
    <tr>
        <td>Id</td>
        <td><c:out value="${auto.id}"/></td>
    </tr>
    <tr>
        <td>Производитель</td>
        <td><c:out value="${auto.supplier}"/></td>
    </tr>
    <tr>
        <td>Марка</td>
        <td><c:out value="${auto.mark}"/></td>
    </tr>
    <tr>
        <td>Серийный номер</td>
        <td><c:out value="${auto.serialNumber}"/></td>
    </tr>
    <tr>
        <td>Цвет</td>
        <td><c:out value="${auto.color}"/></td>
    </tr>
</table>

<table border="1px" width="40%" title="Т.Т.Х.">
    <tr>
        <td>Объем Двигателя л.</td>
        <td><c:out value="${auto.engineCapacity}"/></td>
    </tr>
    <tr>
        <td>Мощность Двигателя л.с.</td>
        <td><c:out value="${auto.enginePower}"/></td>
    </tr>
    <tr>
        <td>Объем Топливного Бака л.</td>
        <td><c:out value="${auto.fuelCapacity}"/></td>
    </tr>
    <tr>
        <td>Потребление Топлива л./100 км.</td>
        <td><c:out value="${auto.fuelConsumption}"/></td>
    </tr>
    <tr>
        <td>Коробка передач</td>
        <td>
            <c:choose>
                <c:when test="${auto.autoGearBox == true}">Автомат</c:when>
                <c:when test="${auto.autoGearBox == false}">Механическая</c:when>
            </c:choose>
        </td>
    </tr>
    <tr>
        <td>Масса кг.</td>
        <td><c:out value="${auto.mass}"/></td>
    </tr>
</table>

<table width="30%" title="">
    <tr>
        <td>Количество мест</td>
        <td><c:out value="${auto.seats}"/></td>
    </tr>
    <tr>
        <td>Пробег км.</td>
        <td><c:out value="${auto.mileageKm}"/></td>
    </tr>
    <tr>
        <td>Последнее ТО</td>
        <td><c:out value="${auto.lastService}"/></td>
    </tr>
    <tr>
        <th>Цена $</th>
        <th><c:out value="${auto.cost}"/></th>
    </tr>
    <tr>
        <c:choose>
            <c:when test="${auto.isSold == true}">
                <td><h4>Продано</h4></td>
                <td></td>
            </c:when>
            <c:when test="${auto.inStock == true}">
                <td>Есть в наличии !</td>
                <td></td>
            </c:when>
            <c:when test="${auto.inStock != true}">
                <td>Отсутствует</td>
                <td><a href="add_to_stock?id=${auto.id}">(Появилась на складе?)</a><br/></td>
            </c:when>
        </c:choose>
    </tr>
</table>
<a href="update_auto_form?id=${auto.id}">Изменить</a><br/>
<a href="add_customer_form?id=${auto.id}">Заброниовать машину</a><br/>
<a href="delete_auto?id=${auto.id}">Удалить машину</a><br/>
</body>
</html>
