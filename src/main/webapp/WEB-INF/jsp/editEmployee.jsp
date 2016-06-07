<%--
  Created by IntelliJ IDEA.
  User: ehc
  Date: 31/5/16
  Time: 3:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
  City : <form:select path="address.city" name="city">
  <form:option value="city">city...</form:option>
  <form:option value="hyderabad">hyderabad</form:option>
  <form:option value="madhapur">madapur</form:option>
</form:select><br/><br/>
<form:radiobutton path="gender" value="female"/>female
<form:radiobutton path="gender" value="male" />male</br>
 Certificates :
  <c:if test="${employee.certificatesList!=null}">
    <c:forEach var="certificates" items="${employee.certificatesList}">
      <c:out value="${certificates.cname}"/>
    </c:forEach>
  </c:if>
  </br></br> <input type="submit" value="Update">
</form:form>
</body>
</html>