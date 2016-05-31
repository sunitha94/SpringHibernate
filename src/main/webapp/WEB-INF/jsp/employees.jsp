<%--
  Created by IntelliJ IDEA.
  User: ehc
  Date: 30/5/16
  Time: 2:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Home</title>
</head>
<body>
<a href="/"><h1>Emplpoyees Page</h1></a>
<table>
  <tr>
    <td>Id</td>
    <td>Name</td>
    <td>Action</td>
  </tr>
  <c:forEach var="employee" items="${employees}">
    <tr>
      <td>${employee.empid}</td>
      <td>${employee.name}</td>
      <td><a href="/deleteEmp/${employee.empid}">delete</a></td>
    </tr>
  </c:forEach>
  <a href="/addEmployee">addEmplyee</a>
</table>
</body>
</html>


