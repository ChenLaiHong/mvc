<%--
  Created by IntelliJ IDEA.
  User: 赖红
  Date: 2017/12/2
  Time: 19:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>

    <style type="text/css">
        .STYLE1 {
            color: #F5CBFF;
            font-weight: bold;
            font-size: 36px;
            font-family: "楷体_GB2312";
        }
    </style>

    <script>
        function checkAll() {
            var name = document.getElementById("name");
            var password1 = document.getElementById("password");
            if (name.value == null || name.value == "" || password1.value == null || password1.value == "") {
                document.getElementById("errorA").innerHTML = "请输入用户名和密码！";
                return false;
            }else {
                return true;
            }
        }

    </script>

</head>
<body background="${path}/image/1.jpg">

<table align="center" border="1" cellpadding="8" bgcolor="#F5CBFF" style="width:560px;height:35px">
    <tr>
        <p align="center" class="STYLE1">学生登录窗口</p>
    </tr>
    <form action="LoginServlet" method="post" onsubmit="return checkAll()">
        <font color="red">${requestScope.msg}</font>
        <tr>
            <td>*用户名：</td>
            <td><input type="text" name="username" id="name" placeholder="请输入用户名" autocomplete="off"/>
            </td>
        </tr>
        <tr>
            <td>*密码：</td>
            <td><input type="password" name="password" id="password" placeholder="请输入密码" autocomplete="off"/>
            </td>
        </tr>
        <tr>
            <td><input type="submit" value="登录">
            <td>
                <h6>还没有账号？去<a href="register.jsp">注册！</a><div id="errorA" style="display:inline;color:red;"></div></h6>
            </td>
        </tr>

        </td>
    </form>
</table>

</body>
</html>
