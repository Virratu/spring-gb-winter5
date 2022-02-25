<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
    <head>
        <title>Create product</title>
    </head>
    <body>
        <%--@elvariable id="product" type="ru.gb.entity.Product"--%>
        <form:form action="create" modelAttribute="product">
            <form:hidden path="id"/>
            TITLE:<form:input path="title"/>
            <br>
            COST:<form:input path="cost" type="number"/>
            <br>
            <input type="submit" value="Save"/>
        </form:form>
    </body>
</html>
