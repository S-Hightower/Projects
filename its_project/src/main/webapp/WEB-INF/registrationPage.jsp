<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<title>Registration Page</title>
</head>
<body>
	<div class="container mt-5">
		<h1  class="row justify-content-center mt-5">Register</h1>
	<div class="d-flex justify-content-end">
    	<a href="/login" class="btn btn-info">Login Here</a>
    </div>
    <div class="row justify-content-center">
    	<p><form:errors path="user.*"/></p>
    </div>
    <form:form method="POST" action="/registration" modelAttribute="user">
        <div class="form-group">
            <form:label path="username">Username:</form:label>
            <form:input class="form-control" path="username"/>
        </div>
        <div class="form-group">
            <form:label path="password">Password:</form:label>
            <form:password class="form-control" path="password"/>
        </div>
        <div class="form-group">
            <form:label path="passwordConfirmation">Password Confirmation:</form:label>
            <form:password class="form-control" path="passwordConfirmation"/>
        </div>
        <div class="mt-3">
        	<input type="submit" class="btn btn-success" value="Register"/>
        </div>
    </form:form>
    </div>
</body>
</html>