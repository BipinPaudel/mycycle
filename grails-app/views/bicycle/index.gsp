<%--
  Created by IntelliJ IDEA.
  User: bips
  Date: 5/23/16
  Time: 4:26 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title> </title>
</head>

<body>
    <g:each in="${bicycles}" var="bicycle" status="i">
        <h3>Title: ${bicycle.title} <br></h3>
        <h3>Price: ${bicycle.totalPrice}</h3>
        <g:link controller="book" action="book" params="${[id:bicycle.id]}">
            <h4>Book</h4>
        </g:link>
    </g:each>

<g:link controller="bicycle" action="form">
    Add new Bicycle
</g:link>
</body>
</html>