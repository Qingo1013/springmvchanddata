<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2021/3/11
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add user</title>
</head>
<body>
<h1>Add user</h1>


<form:form action="${pageContext.request.contextPath}/form/user" method="post" modelAttribute="user">
    <%--
    private Integer id;
    private String username;
    private Date birthday;
    private Double balance;//余额 格式：￥5000
    private String[] hobbies;
    private Double salary;//工资 格式：10,000.00
    private Double taskCount;//工作完成百分比 格式：90%
    --%>
    <p>
        id:<form:input path="id"/> <form:errors path="id"/>
    </p>
    <p>
        name:<form:input path="username"/> <form:errors path="username"/>
    </p>

    <p>
        birthday:<form:input path="birthday"/> <form:errors path="birthday"/>
    </p>

    <p>
        balance:<form:input path="balance"/> <form:errors path="balance"/>
    </p>

    
    <p>
        salary:<form:input path="salary"/> <form:errors path="salary"/>
    </p>

    <p>
        taskCount:<form:input path="taskCount"/> <form:errors path="taskCount"/>
    </p>
    
    <p>
        hobbies:
        <%--checkbox 静态数据源--%>
<%--        <form:checkbox path="hobbies" value="打游戏"/>
        <form:label path="hobbies">打游戏</form:label>
        <form:checkbox path="hobbies" value="听音乐"/>
        <form:label path="hobbies">听音乐</form:label>
        <form:errors path="hobbies" />--%>
        <%--checkboxes 动态数据源--%>
        <form:checkboxes path="hobbies" items="${map}"></form:checkboxes>
    </p>
    
    <p>
        <input type="submit" value="提交">
    </p>


</form:form>
<%--spring的标签库是支持put、delete请求方式的--%>
<form:form method="put">
    qqa&wxy
</form:form>

<%--
<form action="${pageContext.request.contextPath}/user" method="post">
    &lt;%&ndash;
    private Integer id;
    private String username;
    private Date birthday;
    private Double balance;//余额 格式：￥5000
    private String[] hobbies;
    private Double salary;//工资 格式：10,000.00
    private Double taskCount;//工作完成百分比 格式：90%
    &ndash;%&gt;
    <p>
        id:<input type="text" name="id" value="${user.id}">${errors.id}
    </p>
        <p>
        name:<input type="text" name="username" value="${user.username}">${errors.username}
    </p>

    <p>
        birthday:<input type="text" name="birthday" value="${user.birthday}">${errors.birthday}
    </p>

    <p>
        balance:<input type="text" name="balance" value="${user.balance}">${errors.balance}
    </p>

    <p>
        hobbies:<input type="checkbox" name="hobbies" value="打游戏">打游戏
        <input type="checkbox" name="hobbies" value="听音乐">听音乐${errors.hobbies}
    </p>

    <p>
        salary:<input type="text" name="salary" value="${user.salary}">${errors.salary}
    </p>

    <p>
        taskCount:<input type="text" name="taskCount" value="${user.taskCount}">${errors.taskCount}
    </p>

    <p>
        <input type="submit" value="提交">
    </p>


</form>--%>
</body>
</html>
