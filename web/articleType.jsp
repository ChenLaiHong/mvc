<%--
  Created by IntelliJ IDEA.
  Date: 2017/12/25
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>文章类型管理</title>
</head>
<body background="${path}/image/1.jpg">
<a href="add_articleType.jsp?typeId=0">添加文章类型</a>
<table align="center" border="1" cellpadding="7" bgcolor="#F5CBFF" style="width:50%;height:35px">
    <tr></tr>

    <tr><th>类型名称</th><th>文章数</th><th>操作</th></tr>
    <c:forEach var="c" items="${requestScope.list}">
        <tr>
            <td align="center" width="7%">${c.typeName}</td>
            <td align="center" width="7%">${c.articleCount}</td>

            <td align="center" width="7%">
                <a href="${path}/ArticleTypeServlet?typeId=${c.typeId}">编辑</a>
                <a href="javascript:void(0)" onclick="del('${c.typeId}')">删除</a>
            </td>

        </tr>

    </c:forEach>

</table>

<script type="text/javascript">
    function del(typeId) {
        if(window.confirm("你确定删除吗？"))
            location.href = '${pageContext.request.contextPath}/DeleteTypeServlet?typeId=' + typeId;
    }

</script>
<br>

</body>
</html>
