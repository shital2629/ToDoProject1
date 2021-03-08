<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<form:form  method="get" action="projectsave" modelAttribute="project">
ID<form:input path="id"/>
ProjectName<form:input path="projectName"/>
<br>
<input type="submit" value="Save"/>          
</form:form>
</div>
</body>
</html>