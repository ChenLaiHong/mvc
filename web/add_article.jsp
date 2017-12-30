<%--
  Created by IntelliJ IDEA.
  User: 赖红
  Date: 2017/12/30
  Time: 10:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>添加文章</title>
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
            var articleName= document.getElementById("articleName")
            var article= document.getElementById("article")
            if(articleName =="" || articleName == null){
                alert("标题不能为空")
                return false;
            }else if(article == "" || article == null){
                alert("文章内容不能为空")
                return false;
            }else
            return true;

        }
    </script>
</head>
<body background="${path}/image/1.jpg">
<tr>
    <p align="center" class="STYLE1">添加文章</p>
</tr>
<table align="center" border="1" cellpadding="8" bgcolor="#F5CBFF" style="width:500px;height:35px">
<form action="ArticleServlet" method="post" onsubmit="return checkAll()">

    <tr>
        <td>文章标题：</td>
        <td><input type="text" name="articleName" id="articleName" placeholder="请输入文章标题" autocomplete="off"/>
        </td>
    </tr>
    <tr>
        <td>文章类型：</td>
        <td>
            <select name="typeId" >
                <c:forEach var="list" items="${list}">
                     <option value="${list.typeId}">${list.typeName}</option>
                </c:forEach>
            </select>
        </td>
    </tr>
    <tr>
        <td>内容：</td>
        <td><textarea rows="13" cols="45" name="article" id="article"></textarea></td>
    </tr>
    <tr>
        <td><input type="submit" value="发表">
    </tr>

    </td>
</form>
</table>
</body>
</html>
