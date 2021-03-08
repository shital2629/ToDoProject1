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
<div>
<form:form  method="get" action="tasksave${project.id}" modelAttribute="task">
ID<form:input path= "id"/><br><br>
TaskName<form:input path="taskName"/><br><br>
Status<form:input path="status"/>
<br>
<input type="submit" value="Save"/>          
</form:form>
</div>
</body>
</html>