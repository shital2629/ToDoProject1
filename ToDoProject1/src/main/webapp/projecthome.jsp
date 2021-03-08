<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<table border=1>
<tr>
    <th>Id</th>
    <th>Name</th>
    <th>Delete</th>
</tr>

<c:forEach var="p" items="${plist}">
<tr>
    <td>${p.projectName}</td>
    <td><button><a href="projectdelete${p.id}">Delete</a></button></td>
    <td><button><a href="viewtask${p.id}">ViewTasks</a></button></td>
</tr>

  </c:forEach>
 </table>
 <br>
<button><a href="projectadd">Add</a></button>
</div>
</body>
</html>