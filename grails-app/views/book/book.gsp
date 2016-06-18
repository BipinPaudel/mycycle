<%--
  Created by IntelliJ IDEA.
  User: bips
  Date: 6/6/16
  Time: 4:05 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
</head>

<body>
    <g:form controller="book" action="save" var="">
        <g:datePicker name="startDate"/>
        <g:datePicker name="endDate"/>
        <g:field type="number" name="quantity"/>
        <g:field type="hidden" name="bicycle" value="${bicycleId}"/>
        <g:actionSubmit value="Save"/>

    </g:form>
</body>
</html>