<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
            integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

    <title>Accident</title>
</head>
<body>

<div class="card-body">
    <a href="<c:url value='/create'/>">Добавить инцидент</a>
    <br>
    <a href="<c:url value='/edit'/>">Редактировать инцидент</a>

    <input type="hidden" name="id" value="99"/>


    <table class="table">
        <thead>
        <tr>
            <th scope="col">Название</th>
            <th scope="col">Описание</th>
            <th scope="col">Адрес</th>
            <th scope="col">Тип события</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${accidents}" var="acc">
            <tr>
                <td>
                    <%--<span>--%>
                       <%--<a href="<c:url value='/edit?id=${acc.id}'/>">Редактировать</a>--%>
                    <%--</span>--%>
                    <c:out value="${acc.name}"/>
                </td>
                <%--<td>--%>
                    <%--<c:out value="${acc.text}"/>--%>
                <%--</td>--%>
                <%--<td>--%>
                    <%--<c:out value="${acc.address}"/>--%>
                <%--</td>--%>
                <%--<td>--%>
                    <%--<c:out value="${acc.type.name}"/>--%>
                <%--</td>--%>
                <%--<td>--%>
                    <%--<c:out value="${acc.id}"/>--%>
                <%--</td>--%>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>