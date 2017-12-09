<%--
  Created by IntelliJ IDEA.
  User: 赖红
  Date: 2017/12/2
  Time: 21:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="lsl" uri="/lsl" %>
<html>
<head>
    <title>用户列表</title>
    <style type="text/css">
        .STYLE1 {
            color: #F5CBFF;
            font-weight: bold;
            font-size: 36px;
            font-family: "楷体_GB2312";
        }
        .inputAttr1{

            width: 350px;
            height: 40px;
            border-radius:5px;
            border: 1px solid #999999;
            box-shadow: 1px 1px 3px #cccccc;
            padding-left: 10px;
            margin-right: 10px;
        }
        .bt{
            width: 50px;
            height: 40px;
            background-color:#F5CBFF;
        }

    </style>

</head>
<body background="${path}/image/1.jpg">


<tr>
    <p align="center" class="STYLE1">查询学生窗口</p>
</tr>
<p align="center">
<table align="center" border="1" cellpadding="7" bgcolor="#F5CBFF" style="width:70%;height:35px">
    <form action="QueryServlet" method="post">
        <input type="text" placeholder="请输入查询内容" class="inputAttr1" name="query"><input type="submit" class="bt" value="搜索">
    </form>
    <tr></tr>
    <tr></tr>

    <tr><th>用户名</th><th>性别</th><th>专业</th><th>邮箱</th><th>爱好</th><th>备注</th><th>操作</th></tr>
    <c:forEach var="c" items="${requestScope.queryPage.list}" varStatus="status">
        <tr>
            <td align="center" width="7%">${c.uname}</td>
            <td align="center" width="7%">${c.sex}</td>
            <td align="center" width="10%">${c.major}</td>
            <td align="center" width="10%">${c.email}</td>
            <td align="center" width="15%">${lsl:sub(c.preferences)}</td>
            <td align="center" width="17%">${lsl:sub(c.others)}</td>
            <td align="center" width="12%">
                <a href="${path}/UpdateServlet?uid=${c.uid}">编辑</a>
                <a href="javascript:void(0)" onclick="del('${c.uid}')">删除</a>
            </td>

        </tr>

    </c:forEach>

</table>

<script type="text/javascript">
    function del(uid) {
        if(window.confirm("你确定删除吗？"))
            location.href = '${pageContext.request.contextPath}/DeleteServlet?uid=' + uid;
    }
    function gotopage(currentpage) {
        if(currentpage <1 || currentpage !=parseInt(currentpage)){
            alert("请输入有效值！");
            document.getElementById("pagenum").value='';
        }else {
            var pagesize = document.getElementById("pagesize").value;
            window.location.href='${pageContext.request.contextPath}/QueryServlet?currentpage='+currentpage+'&pagesize='+pagesize;
        }

    }

    function changesize(pagesize,oldvalue){
        if(pagesize<0 || pagesize!=parseInt(pagesize)){
            alert("请输入合法值！！");
            document.getElementById("pagesize").value = oldvalue;
        }else{
            window.location.href='${pageContext.request.contextPath}/QueryServlet?pagesize=' + pagesize;
        }
    }
</script>
<br>
共[${queryPage.totalrecord}]条记录 ,
每页<input type="text" id="pagesize" value="${queryPage.pagesize}" onchange="changesize(this.value,${queryPage.pagesize})" style="width:30px" maxlength="2">条,
共[${queryPage.totalpage}]页,
当前[${queryPage.currentpage}]页
&nbsp;&nbsp;&nbsp;
<a href="javascript:void(0)" onclick="gotopage(${queryPage.previouspage})">上一页</a>
<c:forEach var="pagenum" items="${queryPage.pagebar}">
    <c:if test="${pagenum==queryPage.currentpage}">
        <font color='red'>${pagenum}</font>
    </c:if>

    <c:if test="${pagenum!=queryPage.currentpage}">
        <a href="javascript:void(0)" onclick="gotopage(${pagenum})">${pagenum}</a>
    </c:if>
</c:forEach>
<a href="javascript:void(0)" onclick="gotopage(${queryPage.nextpage})">下一页</a>


</body>
</html>
