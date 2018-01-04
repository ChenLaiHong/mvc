<%--
  Created by IntelliJ IDEA.
  User: 赖红
  Date: 2018/1/4
  Time: 17:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="lsl" uri="/lsl" %>
<html>
<head>
    <title>生活信息管理</title>
</head>
<body background="${path}/image/1.jpg">
<a href="add_life.jsp">添加生活信息</a>
<table align="center" border="1" cellpadding="7" bgcolor="#F5CBFF" style="width:50%;height:35px">
    <tr></tr>

    <tr><th>名称</th><th>介绍</th><th>阅读量</th><th>发布时间</th><th>操作</th></tr>
    <c:forEach var="c" items="${requestScope.list}">
        <tr>
            <td align="center" width="7%">${c.lifeName}</td>
            <td align="center" width="7%">${lsl:sub(c.lifeContent)}</td>
            <td align="center" width="7%">${c.readNum}</td>
            <td align="center" width="7%">${c.releaseTime}</td>
            <td align="center" width="7%">
                <a href="${path}/ArticleTypeServlet?lifeId=${c.lifeId}">编辑</a>
                <a href="javascript:void(0)" onclick="del('${c.lifeId}')">删除</a>
            </td>

        </tr>

    </c:forEach>

</table>

<script type="text/javascript">
    function del(lifeId) {
        if(window.confirm("你确定删除吗？"))
            location.href = '${pageContext.request.contextPath}/DeleteTypeServlet?lifeId=' + lifeId;
    }

</script>
<br>
</body>
</html>
