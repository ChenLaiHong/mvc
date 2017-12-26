<%--
  Created by IntelliJ IDEA.
  User: 赖红
  Date: 2017/12/2
  Time: 17:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>信息管理</title>
  </head>
  <body>
<h5 style="text-align: center">在线人数<%=session.getAttribute("userNum")%></h5>
     <a href="comment.jsp">评论</a>
     <a href="login.jsp">登录</a>
  </body>
</html>
