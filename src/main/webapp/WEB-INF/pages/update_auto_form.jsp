<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %><html>
<head>
    <title>Изменение Данных</title>
</head>
<body>
<a href="main">На Главную</a><br/>
<a href="auto_show?id=${auto.id}">Назад</a><br/>

<form:form method="post" modelAttribute="auto" action="update_auto">
    <form:hidden path="id"/>
    <form:hidden path="inStock" value="${auto.inStock}"/>
    <form:hidden path="isSold" value="${auto.isSold}"/>

    <b>Производитель</b><br>
    <form:input path="supplier" value="${auto.supplier}"/><br>
    <b>Модель</b><br>
    <form:input path="mark" value="${auto.mark}"/><br>
    <b>Серийный номер</b><br>
    <form:input path="serialNumber" value="${auto.serialNumber}"/><br>

    <b>Объем Двигателя</b><br>
    <form:input path="engineCapacity" value="${auto.engineCapacity}"/><br>
    <b>Мощность Двгателя</b><br>
    <form:input path="enginePower" value="${auto.enginePower}"/><br>
    <b>Объем Топливного Бака</b><br>
    <form:input path="fuelCapacity" value="${auto.fuelCapacity}"/><br>
    <b>Потребление Топлива</b><br>
    <form:input path="fuelConsumption" value="${auto.fuelConsumption}"/><br>

    <b>Коробка передач?</b><br>
    <form:select path="autoGearBox" value="${auto.autoGearBox}">
        <form:option value="true">Автомат</form:option>
        <form:option value="false">Механика</form:option>
    </form:select><br>

    <b>Масса</b><br>
    <form:input path="mass" value="${auto.mass}"/><br>
    <b>Цвет</b><br>
    <form:input path="color" value="${auto.color}"/><br>
    <b>Вместимовсть (пассажиров)</b><br>
    <form:input path="seats" value="${auto.seats}"/><br>

    <b>Цена</b><br>
    <form:input path="cost" value="${auto.cost}"/><br>

    <b>Последнее T.O. (YYYY-MM-DD)</b><br>
    <form:input path="lastService" value="${auto.lastService}"/><br>
    <b>Пробег (Км.)</b><br>
    <form:input path="mileageKm" value="${auto.mileageKm}"/><br>

    <form:button value="update_auto">Готово</form:button>
</form:form>
</body>
</html>
