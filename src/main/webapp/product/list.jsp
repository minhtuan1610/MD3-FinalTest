<%--
  Created by IntelliJ IDEA.
  User: minhtuan
  Date: 12/04/2022
  Time: 09:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Products</title>
</head>
<body>
<div>
    <table>
        <caption><h2>List of Products</h2></caption>
        <tr>
            <th>ID</th>
            <th>Product Name</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Color</th>
            <th>Category</th>
        </tr>
        <c:forEach var="list" items="${pList}">
            <tr>
                <td><c:out value="${list.id}"/></td>
                <td><c:out value="${list.name}"/></td>
                <td><c:out value="${list.price}"/></td>
                <td><c:out value="${list.quantity}"/></td>
                <td><c:out value="${list.color}"/></td>
                <td><c:out value="${list.category.getCategory()}"/></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
