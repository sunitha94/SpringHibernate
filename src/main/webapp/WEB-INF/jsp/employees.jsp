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
<a href="/"><h1>Emplpoyees Page</h1></a>
<a href="/addEmployee">AddEmployee</a></br></br>
<input type="search" id="searchName">
<input type="button" id="searchButton" value="search"></br></br>
<body id="bd">
<table border="1"  border-collapse="collapse" id="tb">
  <thead id="th1">
  <tr>
    <th>Id</th>
    <th>Name</th>
    <th>street</th>
    <th>city</th>
    <th>Gender</th>
    <th colspan="2">Action</th>
  </tr>
  </thead>
  <tbody id="empData">
  <c:forEach var="employee" items="${employees}">
    <tr>
      <td>${employee.id}</td>
      <td>${employee.name}</td>
      <td>${employee.address.street}</td><td>${employee.address.city}</td>
      <td>${employee.gender}</td>
      <td><a href="/deleteEmp/${employee.id}">delete</a></td>
      <td><a href="/employees/${employee.id}">update</a></td>
    </tr>
  </c:forEach>
  </tbody>
</table>
<p id="error-dialog-error-label"></p>
</body>
</html>


