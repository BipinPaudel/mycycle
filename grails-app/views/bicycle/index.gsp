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
    <table>
        <tr>
            <th>Title</th>
            <th>Category</th>
            <th>Remaining</th>
            <th>Description</th>
        </tr>
        <g:each in="${bicycles}" var="bicycle" status="i">
            <tr>
                <td>${bicycle.title}</td>
                <td>${bicycle.category.price}</td>
                <td>${bicycle.remaining}</td>
                <td>${bicycle.description}</td>
                <sec:ifAllGranted roles="ROLE_ADMIN">
                    <td><a href="../edit/${bicycle.id}/">Edit</a></td>
                </sec:ifAllGranted>
            <td><g:link controller="book" action="book" params="${[id:bicycle.id]}">
                   Book
                </g:link>
            </td>
                <td>
                    <sec:ifAllGranted roles="ROLE_ADMIN">
                        <g:link controller="bicycle" action="delete"
                                params="${[id:bicycle.id]}">
                            Delete
                        </g:link></sec:ifAllGranted>
                </td>
            </tr>

        </g:each>
    </table>

<sec:ifAllGranted roles="ROLE_ADMIN">
    <g:link controller="bicycle" action="form">
        Add new Bicycle
    </g:link></sec:ifAllGranted>


</body>
</html>