<%@ page isELIgnored="false" %>
<%@ page language ="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Заказчик</title>
</head>

<body>
<a href="main">На Главную</a>
<form:form method="post" modelAttribute="newCustomer" action="add_customer">
    <b>Имя</b><br>
    <form:input path="firstName"/><br>
    <b>Фамилия</b><br>
    <form:input path="lastName"/><br>
    <b>Телефон</b><br>
    <form:input path="phone"/><br>
    <b>e-mail</b><br>
    <form:input path="email"/><br>
    <b>Адрес</b><br>
    <form:textarea path="address"/><br>
    <form:button value="add_customer">Далее</form:button>
</form:form>
</body>
</html>
