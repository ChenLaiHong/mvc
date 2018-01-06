<%--
  Created by IntelliJ IDEA.
  User: 赖红
  Date: 2018/1/5
  Time: 9:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="css/layout.css" type="text/css" />
<html>
<head>
    <title>前台首部</title>
</head>
<body>
<div class="wrapper col1">
    <div id="header">
        <div id="logo">
            <h1>东软</h1>
            <p>我向你一步步走近</p>
        </div>
        <div class="fl_right">
            <ul>
                <li class="last">当前用户：<td style="color: #843534">${user.uname}</td></li>
                <li><a href="#">添加收藏</a></li>
                <li><a href="/LoginOutServlet"><td style="color: red">退出登录</td> </a></li>
            </ul>
            <p>通讯地址：广东省佛山市南海软件科技园 邮编:528225</p>
        </div>
        <br class="clear" />
    </div>
</div>
</body>
</html>
