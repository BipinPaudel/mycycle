<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Form</title>
</head>
<body>
<g:form controller="category" action="save">
    <label>Class: </label>
    <g:textField name="type"/><br/>
    <label>Price: </label>
    <g:textField name="price"/><br/>
    <g:actionSubmit value="Save"/>
</g:form>
</body>
</html>