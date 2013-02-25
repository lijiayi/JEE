<%--@elvariable id="valueHolder" type="de.spqrinfo.jee6.cdiservlet.beans.ValueHolder"--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CDI Servlet</title>
</head>
<body>
    <h1>CDI Servlet</h1>

    <table>
        <tr>
            <td>Kind</td>
            <td>Value</td>
        </tr>
        <tr>
            <td>CDI Bean with Application Scope</td>
            <td>${valueHolder.cdiApplicationScopedCount}</td>
        </tr>
        <tr>
            <td>CDI Bean with Session Scope</td>
            <td>${valueHolder.cdiSessionScopedCount}</td>
        </tr>
        <tr>
            <td>CDI Bean with Request Scope</td>
            <td>${valueHolder.cdiRequestScopedCount}</td>
        </tr>
        <tr>
            <td>Servlet contained counter with Application Scope</td>
            <td>${valueHolder.servletApplicationScopedCount}</td>
        </tr>
        <tr>
            <td>Servlet contained counter with Request Scope</td>
            <td>${valueHolder.servletRequestScopedCount}</td>
        </tr>
    </table>
</body>
</html>
