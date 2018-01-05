<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="lsl" uri="/lsl" %>
<%--
  Created by IntelliJ IDEA.
  User: 赖红
  Date: 2018/1/5
  Time: 9:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文章列表</title>
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
                <li class="last"><a href="#">设置首页</a></li>
                <li><a href="#">添加收藏</a></li>
                <li><a href="#">手机版</a></li>
            </ul>
            <p>通讯地址：广东省佛山市南海软件科技园 邮编:528225</p>
        </div>
        <br class="clear" />
    </div>
</div>
<!-- ####################################################################################################### -->
<div class="wrapper col2">
    <div id="topnav">
        <ul>
            <li><a href="studentLoSuc.jsp">首页</a></li>
            <li class="active"><a href="/StuArticleServlet">文章</a></li>
            <li><a href="full-width.html">发表</a> </li>
            <li><a href="#">设置</a></li>
        </ul>
    </div>
</div>

<div id="comments" style="text-align: center">
    <h2>文章</h2>
<table style="width:80%;height:60px">

<c:forEach var="c" items="${requestScope.articles.list}">
    <ul class="commentlist">
        <li class="comment_odd">
           <span class="name" style="color: #591434" aria-setsize="50"><a href="#">${c.articleName}</a></span>
            <br><br>
        <ul>
        <li>阅读量：${c.readCount} &nbsp;&nbsp;&nbsp;评论量：${c.commentCount}&nbsp;&nbsp;&nbsp;作者：${c.author}</li>
        </ul>
            <div class="submitdate" style="color: #ffcc66"><a href="#">${c.articleDate }</a></div>
            <p>${lsl:sub(c.article)}</p>
        </li>
    </ul>
</c:forEach>
</table>



    <br>
    共[${articles.totalrecord}]条记录 ,
    每页<input type="text" id="pagesize" value="${articles.pagesize}" onchange="changesize(this.value,${articles.pagesize})" style="width:30px" maxlength="2">条,
    共[${articles.totalpage}]页,
    当前[${articles.currentpage}]页
    &nbsp;&nbsp;&nbsp;
    <a href="javascript:void(0)" onclick="gotopage(${articles.previouspage})">上一页</a>
    <c:forEach var="pagenum" items="${articles.pagebar}">
        <c:if test="${pagenum==articles.currentpage}">
            <font color='red'>${pagenum}</font>
        </c:if>

        <c:if test="${pagenum!=articles.currentpage}">
            <a href="javascript:void(0)" onclick="gotopage(${pagenum})">${pagenum}</a>
        </c:if>
    </c:forEach>
    <a href="javascript:void(0)" onclick="gotopage(${articles.nextpage})">下一页</a>
</div>
<jsp:include page="/tail.jsp"/>
<script>
    function gotopage(currentpage) {
        if(currentpage <1 || currentpage !=parseInt(currentpage)){
            alert("请输入有效值！");
            document.getElementById("pagenum").value='';
        }else {
            var pagesize = document.getElementById("pagesize").value;
            window.location.href='${pageContext.request.contextPath}/StuArticleServlet?currentpage='+currentpage+'&pagesize='+pagesize;
        }

    }

    function changesize(pagesize,oldvalue){
        if(pagesize<0 || pagesize!=parseInt(pagesize)){
            alert("请输入合法值！！");
            document.getElementById("pagesize").value = oldvalue;
        }else{
            window.location.href='${pageContext.request.contextPath}/StuArticleServlet?pagesize=' + pagesize;
        }
    }
</script>
</body>

</html>
