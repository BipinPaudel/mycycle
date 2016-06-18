<%--
  Created by IntelliJ IDEA.
  User: bips
  Date: 6/6/16
  Time: 4:05 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title></title>
</head>

<body>
    <g:form controller="book" action="save" var="">
        Start Date:
        <g:datePicker name="startDate"/><br>
        End Date
        <g:datePicker name="endDate"/> <br>
        Quantity
        <g:field type="number" name="quantity"/><br>
        <g:field type="hidden" name="bicycle" value="${bicycleId}"/>
        <g:actionSubmit value="Save"/>

    </g:form>
</body>
</html>