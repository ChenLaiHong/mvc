<%--
  Created by IntelliJ IDEA.
  User: 赖红
  Date: 2018/1/6
  Time: 11:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>写文章</title>
    <script type="text/javascript" charset="UTF-8" src="./static/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="UTF-8" src="./static/ueditor/ueditor.all.min.js"> </script>
    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
    <script type="text/javascript" charset="UTF-8" src="./static/ueditor/lang/zh-cn/zh-cn.js"></script>
    <link rel="stylesheet" type="text/css" href="./css/style2.css" />

    <script type="text/javascript">
        function check(){
            var article = UE.getEditor('article').getContent();
            var form = document.getElementById("form");
            var input = document.createElement("input");
            input.type = "hidden";
            input.name = "article";
            input.value = article;
            form.appendChild(input);
            return true;

        }

    </script>
    <script type="text/javascript">
        var ue = UE.getEditor('article');
    </script>
</head>
<body>
<jsp:include page="/head.jsp"/>
<!-- ####################################################################################################### -->
<div class="wrapper col2">
    <div id="topnav">
        <ul>
            <li><a href="/LoginServlet">首页</a></li>
            <li><a href="/StuArticleServlet">文章</a></li>
            <li class="active"><a href="/StuAddArticleServlet">发表</a> </li>
            <li><a href="#">设置</a></li>
        </ul>
    </div>
</div>

<div id="site_content">
    <form id="form" action="StuAddArticleServlet" method="post" onsubmit="return check()">
    <table cellspacing="20px">
        <tr>
            <input type="hidden" id="author" name="author" value="${user.uname }"/>
            <td width="80px">文章标题：</td>
            <td><input type="text" id="articleName" name="articleName" style="width: 400px;"/></td>
        </tr>
        <tr>
            <td>类别：</td>
            <td>
                <select id="typeId" name="typeId" >
                    <option value="">请选择博客类别...</option>
                    <c:forEach var="list" items="${list }">
                        <option value="${list.typeId }">${list.typeName }</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td valign="top">文章内容：</td>
            <td>
                <script id="article" type="text/plain" style="width:100%;height:300px;"></script></td>
        </tr>
        <tr> <td><input type="submit" value="发表"/></td>
        </tr>
    </table>
    </form>
</div>
</body>

</html>
