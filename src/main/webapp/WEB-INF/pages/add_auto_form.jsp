<%@ page isELIgnored="false" %>
<%@ page language ="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Новый Автомобиль</title>
</head>
<body>
<a href="main">На Главную</a>
<form:form method="post" modelAttribute="newAuto" action="add_auto">
    <form:hidden path="isSold" value="${false}"/>

    <b>Производитель</b><br>
    <form:input path="supplier"/><br>
    <b>Модель</b><br>
    <form:input path="mark"/><br>
    <b>Серийный номер</b><br>
    <form:input path="serialNumber"/><br>

    <b>Объем Двигателя</b><br>
    <form:input path="engineCapacity"/><br>
    <b>Мощность Двгателя</b><br>
    <form:input path="enginePower"/><br>
    <b>Объем Топливного Бака</b><br>
    <form:input path="fuelCapacity"/><br>
    <b>Потребление Топлива</b><br>
    <form:input path="fuelConsumption"/><br>

    <b>Коробка передач?</b><br>
    <form:select path="autoGearBox">
        <form:option value="true">Автомат</form:option>
        <form:option value="false">Механика</form:option>
    </form:select><br>

    <b>Масса</b><br>
    <form:input path="mass"/><br>
    <b>Цвет</b><br>
    <form:input path="color"/><br>
    <b>Вместимовсть (пассажиров)</b><br>
    <form:input path="seats"/><br>

    <b>Цена</b><br>
    <form:input path="cost"/><br>

    <b>Последнее T.O. (YYYY-MM-DD)</b><br>
    <form:input path="lastService"/><br>
    <b>Пробег (Км.)</b><br>
    <form:input path="mileageKm"/><br>

    <b>В наличии?</b><br>
    <form:select path="inStock">
        <form:option value="true">Да</form:option>
        <form:option value="false">Нет</form:option>
    </form:select><br>

    <form:button value="add_auto">Добавить</form:button>
</form:form>
</body>
</html>
