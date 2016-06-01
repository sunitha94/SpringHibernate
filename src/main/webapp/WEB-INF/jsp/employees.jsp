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
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
  <script src="/script1.js"></script>

</head>
<body>
<a href="/"><h1>Emplpoyees Page</h1></a>
<a href="/addEmployee">AddEmployee</a>
<input type="search" id="searchName">
<input type="button" id="searchButton" value="search">
<table>
  <thead>
  <tr>
    <th>Id</th>
    <th>Name</th>
    <th>Action</th>
  </tr>
  </thead>
  <tbody id="empData">
  <c:forEach var="employee" items="${employees}">
    <tr>
      <td>${employee.empid}</td>
      <td>${employee.name}</td>
      <td><a href="/deleteEmp/${employee.empid}">delete</a></td>
      <td><a href="/employees/${employee.empid}">update</a></td>
    </tr>
  </c:forEach>
  </tbody>
</table>
<div id="result1"></div>
<p id="error"></p>
</body>
</html>


