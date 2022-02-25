<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
    <head>
        <title>Product</title>
    </head>
    <body>
        ID: ${product.id}
        <br>
        TITLE: ${product.title}
        <br>
        COST: ${product.cost}
        <br>
        <c:url var="deleteUrl" value="/products/delete">
            <c:param name="id" value="${product.id}"/>
        </c:url>
        <a href="${deleteUrl}"> DELETE </a>
        <c:url var="editUrl" value="/products/edit">
            <c:param name="id" value="${product.id}"/>
        </c:url>
        <a href="${editUrl}"> EDIT </a>
    </body>
</html>