<%--
  Created by IntelliJ IDEA.
  User: bips
  Date: 6/20/16
  Time: 10:51 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title></title>
</head>

<body>
    <table>
        <tr>
            <th>User</th>
            <th>Bicycle</th>
            <th>Date</th>
            <th>Price</th>
        </tr>
        <g:each in="${reports}" var="report">
            <tr>
                <td>${report.user.username}</td>
                <td>${report.bicycle.title}</td>
                <td>${report.date}</td>
                <td>${report.price}</td>
                <td>
                    <g:link controller="returnReport" action="delete"
                        params="${[id:report.id]}">
                        Delete
                    </g:link>
                </td>

            </tr>
        </g:each>
    </table>
</body>
</html>