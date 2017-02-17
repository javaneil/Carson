<%@include file="head.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<style>
    table, th, td {
        border: 1px solid black;
        border-collapse: collapse;
        padding: 5px;
    }
    th {
        text-align: center;
    }
    tr {
        text-align: left;
    }
</style>

<html>
<body>

<%--TODO Pretty up the results!--%>
<div class="container-fluid" align="center">

    <h2>Coffees: </h2>
    <br />
    <table>
        <tr>
            <th><c:out value="ID"/></th>
            <th><c:out value="${'Name'}"/></th>
            <th>Description</th>
            <th>Vendor</th>
        </tr>
        <c:forEach var="coffee" items="${coffeeList}">
            <tr>
                <td><c:out value="${coffee.getCoffeeId()}"    /></td>
                <td><c:out value="${coffee.getCoffeeName()}"  /></td>
                <td><c:out value="${coffee.getDescription()}" /></td>
                <td><c:out value="${coffee.getVendorName()}"  /></td>
            </tr>
        </c:forEach>
    </table>

    <br />
    <a href="index.jsp">Home</a>

</div>

</body>
</html>
