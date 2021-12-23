<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<title>Login and Registration</title>
</head>
<body>
	<div class="container mt-5">
	<div class="row justify-content-center">
	<c:if test="${logoutMessage != null}">
        <c:out value="${logoutMessage}"></c:out>
    </c:if>
    </div>
    <h1 class="row justify-content-center mt-5">Login</h1>
	    <c:if test="${errorMessage != null}">
	        <c:out value="${errorMessage}"></c:out>
	    </c:if>
	    <div class="d-flex justify-content-end">
            <a href="/registration" class="btn btn-info">Register Here</a>
    	</div>
	    <form method="POST" action="/login">
        <div class="form-group">
            <label for="username">Username</label>
            <input class="form-control" type="text" id="username" name="username"/>
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <input class="form-control" type="password" id="password" name="password"/>
        </div>
        <div class="mt-3">
        	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        	<input type="submit" class="btn btn-success" value="Login"/>
        </div>
    </form>
    </div>
</body>
</html>