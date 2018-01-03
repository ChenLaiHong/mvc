<%--
  Created by IntelliJ IDEA.
  User: 赖红
  Date: 2018/1/3
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>导航栏</title>
</head>
<body>
<h5 style="text-align: center">在线人数<%=session.getAttribute("userNum")%></h5>
<a href="/ArticleServlet" target="right">发表</a>
<a href="read.jsp" target="right">查看文章</a>
<a href="/ListTypeServlet" target="right">查看文章类型</a>
<a href="login.jsp" target="right">登录</a>
</body>
</html>
