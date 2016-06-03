<%--
  Created by IntelliJ IDEA.
  User: ehc
  Date: 31/5/16
  Time: 11:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>add</title>
</head>
<body>
<form:form action="/employees/add" method="POST" modelAttribute="employee">
  Name: <form:input type="text" path="name" name="name"/><br/>
  Street:<form:input type="text" path="address.street" name="street"/><br/>
  City : <form:input type="text" path="address.city" name="city"/><br/>
<br/>
  <input type="submit" value="add">
</form:form>
</body>
</html>