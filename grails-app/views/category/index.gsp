<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Form</title>
</head>
<body>
<table>
    <tr>
        <th> Class</th>
        <th>Price</th>
    </tr>

        <g:each in="${categories}" var="category" status="i">
            <tr>
            <td><g:link controller="bicycle" action="index" params="${[id:category.id]}">
                 <h3>${category.type}</h3> </g:link></td>

            <td>
                Price: ${category.price}
            </td>
                <td>
                    <sec:ifAllGranted roles="ROLE_ADMIN">
                        <g:link controller="category" action="delete" params="${[id:category.id]}">
                            Delete
                        </g:link>
                    </sec:ifAllGranted>
                </td>
            </tr>
        </g:each>


</table>

<sec:ifAllGranted roles="ROLE_ADMIN">
    <g:link controller="category" action="form">
        Add new Category
    </g:link>
</sec:ifAllGranted>

</body>

</html>
