<%--
  Created by IntelliJ IDEA.
  User: bikash
  Date: 5/23/16
  Time: 3:38 PM
--%>

<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Form</title>
</head>
<body>
<g:form controller="bicycle" action="save">
    <label>Category: </label>
        <g:select from="${category.type}" name="category"/><br/>
    <label>Title: </label>
        <g:textField name="title"/><br/>
    <label>Quantity: </label>
        <g:textField name="quantity"/><br/>
    <label>Date: </label>
        <g:datePicker name="date"/><br/>
    <label>Price: </label>
        <g:textField name="totalPrice"/><br/>
    <label>Description: </label>
    <g:textField name="description"></g:textField>
    <g:actionSubmit value="Save"/>
</g:form>
</body>
</html>