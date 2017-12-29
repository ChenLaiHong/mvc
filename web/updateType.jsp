<%--
  Created by IntelliJ IDEA.
  User: 赖红
  Date: 2017/12/29
  Time: 19:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更新文章类型</title>
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
            var typeName= document.getElementById("typeName")
            if(typeName == "" || typeName ==null){
                alert("请填写类型名称")
            }
        }
    </script>
</head>
<body background="${path}/image/1.jpg">
<form id="form" action="ArticleTypeServlet" method="post" onsubmit="return checkAll()">

    <tr>
        <p align="center" class="STYLE1">修改文章类型</p>
    </tr>
    <p align="center">
    <table align="center" border="1" cellpadding="8" bgcolor="#F5CBFF" style="width:560px;height:35px">
        <input type="hidden" name="typeId" value="${type.typeId}">
        <tr>
            <td>类型名称：</td>
            <td><input type="text" value="${type.typeName}" id="typeName" name="typeName"/>
            </td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="修改"/>
            </td>

        </tr>
    </table>
    </p>
</form>

</body>
</html>
