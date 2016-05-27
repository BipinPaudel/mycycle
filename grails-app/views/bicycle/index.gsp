<%--
  Created by IntelliJ IDEA.
  User: bips
  Date: 5/23/16
  Time: 4:26 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
</head>

<body>
    <g:each in="${bicycles}" var="bicycle" status="i">
        <h3>Title: ${bicycle.title} <br></h3>
        <h3>Price: ${bicycle.totalPrice}</h3>

    </g:each>
</body>
</html>