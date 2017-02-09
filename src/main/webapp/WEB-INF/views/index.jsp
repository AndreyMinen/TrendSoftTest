<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Управление новостями</title>
    <link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet" type="text/css"/>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
</head>
<body>
    <a href="<c:url value="/"/>">вернуться назад</a>
    <h1 align="center">Новости</h1>
    <div id="block-search">
        <form method="get" action="<c:url value="/search"/>">
            <ul>
                <li>Поиск:</li>
                <li>
                    <select name="sel_cat">
                        <c:forEach items="${categories}" var="cat">
                            <option value="${cat.id}">${cat.title}</option>
                        </c:forEach>
                    </select>
                </li>
                <li><input type="text" name="search_title" placeholder="Название"></li>
                <li><input type="text" name="search_descr" placeholder="Содержание"></li>
                <li><input type="submit" value="Найти"></li>
            </ul>
        </form>
    </div>
    <div id="block-table">
        <c:if test="${!empty newsList}">
            <table border="1">
                <tr>
                    <th>Дата публикации</th>
                    <th>Категория</th>
                    <th>Название</th>
                    <th>Описание</th>
                    <th>Действие</th>
                </tr>
                <c:forEach items="${newsList}" var="news">
                    <tr>
                        <td><fmt:formatDate value="${news.date_publish}" pattern="dd.MM.yyyy HH:mm"/></td>
                        <td>${news.category_id.title}</td>
                        <td>${news.title}</td>
                        <td>${news.descr}</td>
                        <td>
                            <ul>
                                <li><a href="<c:url value="/edit/${news.id}"/>">Редактиривать</a></li>
                                <li><a href="<c:url value="/remove/${news.id}"/>">Удалить</a></li>
                            </ul>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </div>

    <div id="block-create">

        <form:form action="/news/add" commandName="news">
            <table>
                <c:if test="${!empty news.title}">
                    <tr>
                        <td>
                            <form:label path="id">
                                <spring:message text="ID:"/>
                            </form:label>
                        </td>
                        <td>
                            <form:input path="id" readonly="true" size="5" disabled="true"/>
                            <form:hidden path="id" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="date_publish">
                                <spring:message text="Дата публикации:"/>
                            </form:label>
                        </td>
                        <td>
                            <form:input path="date_publish" readonly="true" disabled="true"/>
                        </td>
                    </tr>
                </c:if>
                <tr>
                    <td>
                       Категории:
                    </td>
                    <td>
                        <select name="sel_cat">
                            <c:forEach items="${categories}" var="cat">
                                <option value="${cat.id}">${cat.title}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:label path="title">
                            <spring:message text="Название:"/>
                        </form:label>
                    </td>
                    <td>
                        <form:input path="title" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:label path="descr">
                            <spring:message text="Описание"/>
                        </form:label>
                    </td>
                    <td>
                        <form:textarea path="descr" rows="10" cols="40"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <c:if test="${!empty news.title}">
                            <input type="submit" value="<spring:message text="Обновить"/>">
                        </c:if>
                        <c:if test="${empty news.title}">
                            <input type="submit" value="<spring:message text="Добавить"/>">
                        </c:if>
                    </td>
                </tr>
            </table>
        </form:form>

    </div>
</body>
</html>
