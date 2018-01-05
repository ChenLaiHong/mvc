<%--
  Created by IntelliJ IDEA.
  User: 赖红
  Date: 2018/1/4
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="lsl" uri="/lsl" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="imagetoolbar" content="no" />
<link rel="stylesheet" href="css/layout.css" type="text/css" />
<script type="text/javascript" src="static/scripts/jquery-1.4.1.min.js"></script>
<script type="text/javascript" src="static/scripts/jquery.slidepanel.setup.js"></script>
<script type="text/javascript" src="static/scripts/jquery-ui-1.7.2.custom.min.js"></script>
<script type="text/javascript" src="static/scripts/jquery.tabs.setup.js"></script>
<html>
<head>
    <title>学生登录成功后的首页</title>
</head>
<body>
<jsp:include page="/head.jsp"/>
<!-- ####################################################################################################### -->
<div class="wrapper col2">
    <div id="topnav">
        <ul>
            <li class="active"><a href="">首页</a></li>
            <li><a href="/StuArticleServlet">文章</a></li>
            <li><a href="full-width.html">发表</a> </li>
            <li><a href="#">设置</a></li>
        </ul>
    </div>
</div>
<!-- ####################################################################################################### -->
<div class="wrapper col3">
    <div id="featured_slide">
        <div id="featured_wrap">
            <ul id="featured_tabs">
                <li><a href="#fc1">钟楼<br />
                    <span>源于东大，始于东软</span></a></li>
                <li><a href="#fc2">图书馆<br />
                    <span>活到老，学到老</span></a></li>
                <li><a href="#fc3">继教<br />
                    <span>读书没有年龄限制</span></a></li>
                <li class="last"><a href="#fc4">Neusoft<br />
                    <span>广东东软学院</span></a></li>
            </ul>
            <div id="featured_content">
                <div class="featured_box" id="fc1"><img src="image/101.jpg" alt="" />
                </div>
                <div class="featured_box" id="fc2"><img src="image/102.jpg" alt="" />
                </div>
                <div class="featured_box" id="fc3"><img src="image/103.jpg" alt="" />
                </div>
                <div class="featured_box" id="fc4"><img src="image/104.jpg" alt="" />
                </div>
            </div>
        </div>
    </div>
</div>
<!-- ####################################################################################################### -->

<div class="wrapper col4">
    <div id="container">
        <div id="hpage">
            <ul>
                <c:forEach var="c" items="${requestScope.list}">
                <li class=${c.lifeId==4 ? "last":"" }>
                    <h2>${c.lifeName}</h2>
                    <div class="imgholder"><a href="#"><img src="image/${c.lifeId+4}.jpg" alt="" /></a></div>
                    <p>${lsl:sub1(c.lifeContent)}</p>
                    <p class="readmore"><a href="#">Continue Reading &raquo;</a></p>
                </li>
                </c:forEach>
            </ul>
            <br class="clear" />
        </div>
    </div>
</div>

<!-- ####################################################################################################### -->

<jsp:include page="/tail.jsp"/>
</body>
</html>
