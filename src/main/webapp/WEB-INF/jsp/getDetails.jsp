<%--
  Created by IntelliJ IDEA.
  User: ehc
  Date: 30/5/16
  Time: 5:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Home</title>
</head>
<body>
<form:form action="/employees/get" method="POST" modelAttribute="employee">
  <form:input type="hidden" path="id"/>
  Name: <form:input type="text" path="name" name="name"/><br/>
</form:form>
</body>
</html>