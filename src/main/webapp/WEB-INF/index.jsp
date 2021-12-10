<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dojos and Ninjas</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
   	<div class="container mt-5">
   
   		<h1>New Dojo</h1>
   
   		<div class="mt-2">
   			<form:form class="form-control" action="/dojo/create" method="post" modelAttribute="newDojo">
   				<form:label path="name" class="form-label">Enter New Dojo name:</form:label>
   				<form:errors path="name" class="text-danger"/>
			    <form:input path="name" class="form-control"/>
			    <button class="btn btn-primary btn-sm mt-1">Create</button>
   			</form:form>
   		</div>
   		<div class="mt-2">
   			<a href="/ninja/new">Register a new ninja</a>
   		</div>
   		<div class="mt-3">
   			<table class="table table-primary table-striped">
				<thead>
				    <tr>				      
				      <th class="col">Location</th>
				      <th class="col">Actions</th>				         
					</tr>
				</thead>
				<tbody>
				  	<c:forEach var="dojo" items="${dojos}">			<!-- LOOP -->
					<tr>
    					<td><c:out value="${dojo.name}"/></td>
    					<td><a href="/dojo/${dojo.id}/show">View Roster</a></td>    								    					  					
				  	</tr>
					</c:forEach>								<!-- END LOOP -->
				</tbody>
			</table> 
   		
   		</div>
   		
	</div>	
</body>
</html>