<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Form</title>
</head>
<body>
    <g:each in="${categories}" var="category" status="i">
        <h3>Class: ${i+1}.${category.type}</h3>
        <p>
            Price: ${category.price}
        </p>
    </g:each>
</body>
</html>