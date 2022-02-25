<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
    <head>
        <title>List of products</title>
    </head>
    <body>
        <h1>Product list:</h1>
        <c:forEach var="product" items="${products}">
            <c:url var="viewUrl" value="/products/product/${product.id}"/>
            <li>
                <a href="${viewUrl}"> View </a>
                id: ${product.id} title: ${product.title} cost: ${product.cost}

                <c:url var="editUrl" value="/products/edit">
                    <c:param name="id" value="${product.id}"/>
                </c:url>
                <a href="${editUrl}"> EDIT </a>
                <c:url var="deleteUrl" value="/products/delete">
                    <c:param name="id" value="${product.id}"/>
                </c:url>
                <a href="${deleteUrl}"> DELETE </a>
            </li>
        </c:forEach>
        <br>
        <c:url var="createUrl" value="/products/create"/>
        <a href="${createUrl}"> CREATE </a>
    </body>
</html>
