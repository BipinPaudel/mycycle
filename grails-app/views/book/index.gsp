<%--
  Created by IntelliJ IDEA.
  User: bips
  Date: 6/6/16
  Time: 4:02 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>

<head>
    <meta name="layout" content="main"/>
    <title></title>
</head>

<body>

${bookList.size()}
<table style="width: 100%">

    <tr>
        <th> User </th>
        <th> Bicycle</th>
        <th>Quantity</th>
        <th> Start Date</th>
        <th>End Date</th>
        <th> Paid </th>
        <th>Status </th>

    </tr>
    <g:each in="${bookList}" var="bookingList" status="i">

        <tr>
            <td>
                ${bookingList.user.username}
            </td>
            <td>
                ${bookingList.bicycle.title}
            </td>
            <td>
                ${bookingList.quantity}
            </td>
            <td>
                ${bookingList.startDate}
            </td>
            <td>
                ${bookingList.endDate}
            </td>
            <td>
                <g:if test="${bookingList.paid==0}">
                    Not paid
                </g:if>
                <g:else>
                    Paid
                </g:else>

            </td>
            <td>
               <g:if test="${bookingList.status==0}">
                   Booked
               </g:if>
                <g:else>
                   <p>Taken</p>
                </g:else>

            </td>
            <td>
                <g:link controller="book" action="returnCycle" params=
                "${[bicycleId:bookingList.bicycle.id,quantity:bookingList.quantity,id:bookingList.id]}">
                    Return
                </g:link>
            </td>
            <td>
                <g:link controller="book" action="taken" params="${[bookId:bookingList.id]}">
                    Taken
                </g:link>
            </td>
        </tr>
    </g:each>
</table>

</body>
</html>