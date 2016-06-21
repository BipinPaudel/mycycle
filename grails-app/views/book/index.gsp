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

<table style="width: 100%">

    <tr>
        <th> User </th>
        <th> Bicycle</th>
        <th>Quantity</th>
        <th> Start Date</th>
        <th>End Date</th>
        <th> Paid </th>
        <th>Status </th>
        <th>Payable Amount</th>

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
                ${bookingList.totalAmount}
            </td>
            <td>
                <sec:ifAllGranted roles="ROLE_ADMIN">
                <g:link controller="book" action="returnCycle" params=
                "${[bicycleId:bookingList.bicycle.id,totalAmount:bookingList.totalAmount,
                    id:bookingList.id,user_id:bookingList.user.id,
                quantity: bookingList.quantity]}">
                    Return
                </g:link>
                </sec:ifAllGranted>
            </td>
            <td>
                <sec:ifAllGranted roles="ROLE_ADMIN">
                <g:link controller="book" action="taken" params="${[bookId:bookingList.id]}">
                    Status
                </g:link>
                </sec:ifAllGranted>
            </td>
            <td>
                <g:link controller="book" action="delete" params=
                "${[bicycleId:bookingList.bicycle.id,quantity:bookingList.quantity,id:bookingList.id]}">
                    Delete
                </g:link>
            </td>
        </tr>
    </g:each>
</table>

</body>
</html>