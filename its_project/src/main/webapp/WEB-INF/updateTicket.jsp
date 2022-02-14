<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<title>Update a Ticket</title>
</head>
<body>
	<div class="container mt-5">
        <h1 class="row justify-content-center">Update a Ticket</h1>
        <div class="d-flex justify-content-end">
            <a href="/home" class="btn btn-info">All Task Dashboard</a>
        </div>
        <div class="mt-5">
        <form:form action="/ticket/${ticket.id}/edit" method="post" modelAttribute="ticket">
        <input type="hidden" name="_method" value="put" />
            <form:label path="priority" class="form-label">Please Verify Priority Level:</form:label>
			<form:select id="priority" name="priority" path="priority" class="form-control">
					<form:option value="High">High</form:option>
					<form:option value="Medium">Medium</form:option>
					<form:option value="Low">Low</form:option>
			</form:select>

            <form:label path="osVersion" class="form-label">OS Version:</form:label>
            <form:select id="osVersion" name="osVersion" path="osVersion" class="form-control">
				<form:option value="Mac OS">Mac OS</form:option>
				<form:option value="Windows OS">Windows OS</form:option>
				<form:option value="Linux Distro">Linux Distro</form:option>
			</form:select>

            <form:label path="bugSumm" class="form-label">Bug Summary:</form:label>
            <form:textarea path="bugSumm" class="form-control"></form:textarea>

            <form:label path="bugDetails" class="form-label">Bug Details:</form:label>
            <form:textarea path="bugDetails" class="form-control"></form:textarea>

        	<form:input type="hidden" path="users" value="${userId}"/>
        <div class="mt-4">
			<button class="btn btn-primary"> Update</button>
		</div>
		</form:form>
        </div>
    </div>
</body>
</html>