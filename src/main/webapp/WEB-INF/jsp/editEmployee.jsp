<%--
  Created by IntelliJ IDEA.
  User: ehc
  Date: 31/5/16
  Time: 3:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Home</title>
</head>
<body>
<form:form action="/employees/update" method="POST" modelAttribute="employee">
  <form:input type="hidden" path="id"/>
  Name: <form:input type="text" path="name" name="name"/><br/>
<form:input type="hidden" path="address.id" name="id"/>
  Street:<form:input type="text" path="address.street" name="street"/><br/>
  City : <form:input type="text" path="address.city" name="city"/><br/>
  <input type="submit" value="Update">
</form:form>
</body>
</html>