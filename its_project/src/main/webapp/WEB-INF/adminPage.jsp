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
<title>View Closed Tickets</title>
</head>
<body>
    <div class="container mt-5">
    <div class="d-flex justify-content-end">
			<a href="/home" class="btn btn-outline-success">Go to Main Dashboard</a>
	</div>
	<h3>Admin Access: <c:out value="${currentUser.username}"></c:out></h3>
		<div class="d-flex justify-content-end">
            <form id="logoutForm" method="POST" action="/logout">
        	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        	<input type="submit" class="btn btn-warning" value="Logout" />
    		</form>
        </div>
        <h1 class="row justify-content-center">Admin Ticket Dashboard</h1>
        <div class="d-flex justify-content-end">
        	<a href="/new" class="btn btn-success">Create Ticket</a>
        </div>
        <div class="mt-5">
            <table class="table table-striped table-hover table-bordered table table-sm table align-middle">
                <thead class="table-light">
                    <tr>
                        <th class="col-md-1 offset-md-1">#</th>
                        <th class="col-md-2 offset-md-2">Priority</th>
                        <th class="col-md-2 offset-md-2">OS Version</th>
                        <th>Ticket Summary</th>
                        <th class="col-md-2 offset-md-2">Actions</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach var="ticket" items="${tickets}">
                    <tr>
                        <td>${ticket.id}</td>
                        <td>${ticket.priority}</td>
                        <td>${ticket.osVersion}</td>
                        <td><a href="/ticket/${ticket.id}">${ticket.bugSumm}</a></td>
                        <td>
                        	<form action="/ticket/${ticket.id}/delete" method="post">
                        	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        	<button class="btn btn-danger">Delete</button>
                        	</form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</body>
</html>