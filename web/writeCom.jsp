<%--
  Created by IntelliJ IDEA.
  User: 赖红
  Date: 2018/1/6
  Time: 10:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>写评论</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/CommentServlet" method="post">
    <div class="publish_comment">
        <input type="hidden" name="articleId" value="${article.articleId}">
        <div>
			<textarea style="width: 100%" rows="3" id="content" name="content"
                      placeholder="智慧如你，不想发表一点想法咩~ "></textarea>
        </div>
        <div class="publishButton">
            <button class="btn btn-primary" type="submit">发表评论</button>
        </div>
    </div>
</form>
</body>
</html>
