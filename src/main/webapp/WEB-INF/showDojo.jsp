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
    <title>${dojo.name}</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container mt-5">
	
		<h1>${dojo.name}'s Ninjas</h1>
		
		<table class="table table-primary table-striped">
			<thead>
			    <tr>				      
			      <th class="col">First Name</th>
			      <th class="col">Last Name</th>
			      <th class="col-2">Age</th>   
				</tr>
			</thead>
			<tbody>
			  	<c:forEach var="ninja" items="${dojo.ninjas}">			<!-- LOOP -->
				<tr>
   					<td><c:out value="${ninja.firstName}"/></td>
   					<td><c:out value="${ninja.lastName}"/></td>
   					<td><c:out value="${ninja.age}"/></td>			    					  					
			  	</tr>
				</c:forEach>								<!-- END LOOP -->
			</tbody>
		</table>  
		
		<a href="/" class="btn btn-sm btn-secondary mt-5">Go back</a>
	
	</div>
</body>
</html>