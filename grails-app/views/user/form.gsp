<%--
  Created by IntelliJ IDEA.
  User: bips
  Date: 5/18/16
  Time: 2:38 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
</head>

<body>
<g:form controller="user" action="save">
    <label>First name: </label>
    <g:textField name="firstname"/><br/>

    <label>Last name: </label>
    <g:textField name="lastname"/><br/>

    <label>Email: </label>
    <g:textField name="email"/><br/>

    <label>String password: </label>
    <g:textField name="password"/><br/>

    <label>Date: </label>
    <g:datePicker name="created"/><br/>

    <label>Role: </label>
    <g:select  name="role" from="${role}"  />

    <g:actionSubmit value="Save"/>
</g:form>
</body>
</html>