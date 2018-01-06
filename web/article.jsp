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
    <title>文章详情</title>


    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/blog.css">
    <link href="http://blog.java1234.com/favicon.ico" rel="SHORTCUT ICON">
    <link rel="stylesheet" href="css/layout.css" type="text/css" />
    <script
            src="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/js/jquery-1.11.2.min.js"></script>
    <script
            src="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="/head.jsp"/>
<!-- ####################################################################################################### -->
<div class="wrapper col2">
    <div id="topnav">
        <ul>
            <li><a href="/LoginServlet">首页</a></li>
            <li class="active"><a href="/StuArticleServlet">文章</a></li>
            <li><a href="full-width.html">发表</a> </li>
            <li><a href="#">设置</a></li>
        </ul>
    </div>
</div>

<div>
<div id="site_content">

    <div class="container">
        <table>

            <div class="blog_title">
                <h3>
                    <strong>${article.articleName }</strong>
                </h3>
            </div>
            <div class="blog_info">
                发布时间：『${article.articleDate }』&nbsp;&nbsp;博客类别：${type}&nbsp;&nbsp;阅读(${article.readCount})
                评论(${article.commentCount})
            </div>
            <div class="blog_content">${article.article }</div>


    <div class="data_list">
        <div class="data_list_title">
            <img src="${pageContext.request.contextPath}/image/comment_icon.png" /> 评论信息
            <c:if test="${commentList.size()>10}">
                <a href="javascript:showOtherComment()"
                   style="float: right;padding-right: 40px;">显示所有评论</a>
            </c:if>
        </div>
        <div class="commentDatas">
            <c:choose>
                <c:when test="${commentList.size()==0}">
                    暂无评论
                </c:when>
                <c:otherwise>
                    <c:forEach var="comment" items="${commentList }" varStatus="status">
                        <c:choose>
                            <c:when test="${status.index<10 }">
                                <div class="comment">
								<span><font>${status.index+1}楼(${comment.author })&nbsp;&nbsp;&nbsp;&nbsp;</font>
                                        ${comment.content}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[&nbsp;${comment.commentDate }&nbsp;]</span>
                                </div>
                            </c:when>
                            <c:otherwise>
                                <div class="otherComment">
                                    <div class="comment">
									<span><font>${status.index+1}楼&nbsp;&nbsp;&nbsp;&nbsp;</font>
                                            ${comment.content}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[&nbsp;${comment.commentDate }&nbsp;]
                                    </span>
                                    </div>
                                </div>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
    </table>
</div>
    <div class="data_list">
        <div class="data_list_title">
            <img src="${pageContext.request.contextPath}/image/publish_comment_icon.png" /> 发表评论
        </div>
        <c:if test="${user.uname ==null}">
            <a href="${pageContext.request.contextPath}/index.jsp">去登录</a>
        </c:if>

        <jsp:include page="/writeCom.jsp"/>
    </div>
    <br>
        <jsp:include page="/tail.jsp"/>

</body>

</html>
