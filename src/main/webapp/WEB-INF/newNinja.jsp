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
    <title>Ninja Registration</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container mt-5">
	
	<h1>Register a new Ninja!</h1>
	
	<form:form class="form-control" action="/ninja/new" method="post" modelAttribute="newNinja">
        	  		<form:label path="dojo" class="form-label">Select a Dojo:</form:label>
			  		<form:select path="dojo" class="form-select">
				      	<c:forEach var="oneDojo" items="${dojos}">
				            <form:option value="${oneDojo.id}">${oneDojo.name}</form:option>
				        </c:forEach>
				    </form:select>
			  		
			  		<form:label path="firstName" class="form-label">First Name:</form:label>
			  		<form:errors path="firstName" class="text-danger"/>
			    	<form:input path="firstName" class="form-control"/>	    
			  		
			  		<form:label path="lastName" class="form-label">Last Name:</form:label>
			  		<form:errors path="lastName" class="text-danger"/>
			    	<form:input path="lastName" class="form-control"/>	   
			
					<form:label path="age" class="form-label">Age:</form:label>
					<form:errors path="age" class="text-danger"/>					
			    	<form:input path="age" type="number" step="1" class="form-control"/>	    
			    	   	
			  		<button type="submit" class="btn btn-primary mt-2">Submit</button>
			  
        	</form:form>
		<a href="/" class="btn btn-sm btn-secondary mt-5">Go back</a>
	</div>
</body>
</html>