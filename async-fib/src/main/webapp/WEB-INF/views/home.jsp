<%--@elvariable id="fibonacci" type="de.spqrinfo.jee.async.web.Fibonacci"--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Fibonacci calculation</title>
</head>
<body>
    <h1>Fibonacci calculation</h1>

    <p>
        Debug information:
        <br/>Servlet ID: ${servletId}
        <br/>Model ID: ${fibonacci}
    </p>

    <h2>Asynchronous Fibonacci calculation</h2>
    <form action="home.do" method="post">
        <div>
            <input type="hidden" name="operation" value="calculate"/>
            <label for="inputValue">fib(n) with n :=</label>
            <input id="inputValue" name="inputValue" type="text" value="${fibonacci.inputValue}"/>
            <input type="submit" value="Calculate"/>
        </div>
    </form>

    <h3>Check Results</h3>
    <form action="home.do" method="post">
        <div>
            <input type="hidden" name="operation" value="check"/>
            <input type="submit" value="Check"/>
        </div>
    </form>

    <c:choose>
        <c:when test="${fibonacci.haveResult}">
            <div style="width: 100%; padding: 5px; border: 1px solid black; color: #adff2f; background-color: gray">
                ${fibonacci.result}
            </div>
        </c:when>
        <c:otherwise>
            <p style="padding: 5px; border: 1px solid black; background-color: #ffb6c1">Calculation not started or still running!</p>
        </c:otherwise>
    </c:choose>

    <hr/>

    <h2>Synchronous Fibonacci calculation</h2>
    <form action="home.do" method="post">
        <div>
            <input type="hidden" name="operation" value="calculateSynchronous"/>
            <label for="inputValueSynchronous">fib(n) with n :=</label>
            <input id="inputValueSynchronous" name="inputValueSynchronous" type="text" value="${fibonacci.inputValueSynchronous}"/>
            <input type="submit" value="Calculate Synchronous"/>
        </div>
    </form>

    <c:if test="${fibonacci.haveResultSynchronous}">
        <div style="width: 100%; padding: 5px; border: 1px solid black; color: #adff2f; background-color: gray">
            ${fibonacci.resultSynchronous}
        </div>
    </c:if>

</body>
</html>
