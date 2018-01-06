<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/1
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<script src="/static/updateSelf.js" type="text/javascript"></script>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改信息</title>
    <script type="text/javascript">
        function checkAll(){
            var pres = document.getElementsByName("pre");
            var preferences = "";
            for(var i=0;i<pres.length;i++){
                var input = pres[i];
                if(input.checked==true){
                    preferences = preferences + input.value + ",";
                }
            }
            preferences = preferences.substr(0,preferences.length-1);
            var form = document.getElementById("form");
            var input = document.createElement("input");
            input.type = "hidden";
            input.name = "preferences";
            input.value = preferences;
            form.appendChild(input);
            return true;
        }
    </script>
</head>
<body>
<jsp:include page="/head.jsp"/>
<!-- ####################################################################################################### -->
<div class="wrapper col2">
    <div id="topnav">
        <ul>
            <li><a href="studentLoSuc.jsp">首页</a></li>
            <li><a href="/StuArticleServlet">文章</a></li>
            <li><a href="/StuAddArticleServlet">发表</a> </li>
            <li class="active"><a href="UpdateSelfServlet?uid=${user.uid}">修改个人信息</a></li>
        </ul>
    </div>
</div>
<form id="form" action="UpdateSelfServlet" method="post" onsubmit="return checkAll();">
    <h2 align="center">修改信息</h2>
    <table align="center">
<input type="hidden" name = "uid" value="${user.uid}">
        ${user.uid}
        <tr>
            <td align="right">用户名：</td>
            <td><input type="text" size="20" name="uname" id="name" value="${user.uname}" onblur="c2()" onfocus="c1()"
                       readonly/>
                <font size="2"><span id="namewarn" style="color: #d6090e;"></span></font></td>
        </tr>
        <tr>
            <td align="right">密码：</td>
            <td><input type="password" size="20" name="password" id="pwd" placeholder="请输入密码" value="${user.password}" onblur="checkPwd()"/>
                <font size="2"><span id="pwdwarn" style="color: #d6090e;"></span></font></td>
        </tr>
        <tr>
            <td align="right">确认密码：</td>
            <td><input type="password" size="20" name="password2" id="repwd" placeholder="请再次输入密码" value="${user.password}" onblur="checkrePwd()"/>
                <font size="2"> <span id="repwdwarn" style="color: #d6090e;"></span></font></td>
        </tr>

        <tr>
            <td align="right">性别：</td>
            <td><c:forEach var="sex" items="${sex}">
                <input type="radio" name="sex" value="${sex}" ${user.sex==sex?'checked':''}>${sex}
            </c:forEach>
            </td>
        </tr>
        <tr>
            <td align="right">邮箱：</td>
            <td><input type="text" size="20" name="email" id="mail" placeholder="请输入邮箱" value="${user.email}"
                       onblur="checkmail()"/>
                <font size="2"><span id="mailwarn" style="color: #d6090e;"></span></font></td>
        </tr>

        <tr>
            <td align="right"> 爱好：</td>
            <td><c:forEach var="p" items="${preferences}">
                <input type="checkbox" name="pre" value="${p}" ${fn:contains(user.preferences,p)?'checked':''}>${p}
            </c:forEach>
            </td>

        </tr>
        <tr>

            <td align="right"> 专业：</td>
            <td>
                <select name="major" id="major" size="1" disabled="disabled">
                <c:forEach var="major" items="${major}">
                    <option value="${major}" ${user.major==major?'selected':''}>${major}</option>
                </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td align="right">其他：</td>
            <td>
                <textarea id="others" name="others">${user.others}</textarea>
            </td>
        </tr>

        <tr>
            <td colspan="2">
                <center><input type="submit" value="修改">
                    &nbsp;&nbsp;
                    <input type="reset" value="重置"></center>
            </td>
        </tr>
    </table>
</form>
</body>
</html>

</body>
</html>
