<%--
  Created by IntelliJ IDEA.
  User: 赖红
  Date: 2017/12/28
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加文章类型</title>
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
            var name = document.getElementById("typeName");
            if (name.value == null || name.value == "") {
                document.getElementById("errorA").innerHTML = "请填写再提交！";
                return false;
            }else {
                return true;
            }
        }

    </script>
</head>
<body background="${path}/image/1.jpg">

<table align="center" border="1" cellpadding="8" bgcolor="#F5CBFF" style="width:500px;height:35px">
    <tr>
        <p align="center" class="STYLE1">添加文章类型</p>
    </tr>
    <form action="ArticleTypeServlet" method="post" onsubmit="return checkAll()">
        <input type="hidden" name="typeId" value="0">
        <tr>
            <td>类型名：</td>
            <td><input type="text" name="typeName" id="name" placeholder="请输入类型名" autocomplete="off"/>
            </td>
        </tr>
        <tr>
            <td><input type="submit" value="添加"></td>
            <td><div id="errorA" style="display:inline;color:red;"/></td>
        </tr>
    </form>
</table>
</body>
</html>
