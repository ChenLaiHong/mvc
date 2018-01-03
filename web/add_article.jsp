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
    <script type="text/javascript" charset="UTF-8" src="./static/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="UTF-8" src="./static/ueditor/ueditor.all.min.js"> </script>
    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
    <script type="text/javascript" charset="UTF-8" src="./static/ueditor/lang/zh-cn/zh-cn.js"></script>



    <script type="text/javascript">
        //发送
        function sendEm(){
            var article = UE.getEditor('article').getContent();
            alert("内容"+article)
            var form = document.getElementById("form");
            var input = document.createElement("input");
            input.type = "hidden";
            input.name = "article";
            input.value = article;
            form.appendChild(input);
            return true;

        }

    </script>
</head>
<body background="${path}/image/1.jpg">
<tr>
    <p align="center" class="STYLE1">添加文章</p>
</tr>
<h5  style="text-align: center;color: red">${requestScope.mesg}</h5>
<table align="center" border="1" cellpadding="8" bgcolor="#F5CBFF" style="width:1000px;height:35px">

    <form id="form" action="ArticleServlet" method="post" onsubmit="return sendEm()">

    <tr>
        <td>文章标题：</td>
        <td><input type="text" name="articleName" id="articleName" placeholder="请输入文章标题" autocomplete="off"/>
        </td>
    </tr>
    <tr>
        <td>文章类型：</td>
        <td>
            <select name="typeId" id="typeId">
                <c:forEach var="list" items="${list}">
                     <option value="${list.typeId}">${list.typeName}</option>
                </c:forEach>
            </select>
        </td>
    </tr>
    <tr>
        <td>内容：</td>
        <td> <script id="article" type="text/plain"></script> </td>
    </tr>
    <tr>
        <td><input type="submit" value="发表">
    </tr>

    </td>
    </form>
</table>

</body>
<script type="text/javascript">
        var ue = UE.getEditor('article');
</script>
</html>
