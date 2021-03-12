<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2021/3/11
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Converter</title>
</head>
<body>
<p>
    id:${user.id}
</p>
<p>
    name:${user.username}
</p>

<p>
    <%--
        JSTL,还要自己写pattern<form:formate>
    --%>
    birthday:<spring:eval expression="user.birthday"></spring:eval>
</p>

<p>
    balance:<spring:eval expression="user.balance"></spring:eval>
</p>

<p>
    <%--使用spring提供的标签库，相较于JSTL，不能自定义显示格式--%>
    <%--一般用来显示格式化的数据--%>
    hobbies:<spring:eval expression="user.hobbies"></spring:eval>
</p>

<p>
    salary:<spring:eval expression="user.salary"></spring:eval>
</p>

<p>
    taskCount:<spring:eval expression="user.taskCount"></spring:eval>
</p>

</body>
</html>
