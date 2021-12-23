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
<title>View Ticket Details</title>
</head>
<body>
	<div class="container mt-5">
		<h1 class="row justify-content-center">View Ticket Details</h1>
        <div class="d-flex justify-content-end">
            <a href="/home" class="btn btn-info">All Task Dashboard</a>
        </div>
        <div class="mt-5">
        <table class="table">
			  <tbody>
			    <tr class="table-danger">
			      <th scope="row">Priority:</th>
			      <td>${ticket.priority}</td>
			    </tr>
			    <tr class="table-info">
			      <th scope="row">OS Version:</th>
			      <td>${ticket.osVersion}</td>
			    </tr>
			    <tr class="table-success">
			      <th scope="row">Bug Summary:</th>
			      <td>${ticket.bugSumm}</td>
			    </tr>
			    <tr class="table-warning">
			      <th scope="row">Bug Details:</th>
			      <td>${ticket.bugDetails}</td>
			    </tr>
			  </tbody>
			</table>
			<div class="mt-4 d-flex justify-content-end">
        		<a href="/ticket/${ticket.id}/edit" class="btn btn-dark">Update</a>
        	</div>
        </div>
	</div>
</body>
</html>