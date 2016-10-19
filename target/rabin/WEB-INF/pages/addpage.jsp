<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: MyCall
  Date: 10/17/2016
  Time: 6:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AddItem</title>
</head>
<body>
<form:form action="/insert" commandName="userBean" method="post">
    <p>
        <label >username</label></br>
        <input type="text" name="userId">
    </p>
    <p>
        <label>password</label></br>
        <input type="password" name="password">
    </p>

    <p><button type="submit">Add</button></p>

    </form:form>
</body>
</html>
