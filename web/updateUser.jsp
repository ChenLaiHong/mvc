<%--
  Created by IntelliJ IDEA.
  User: 赖红
  Date: 2017/12/3
  Time: 18:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
    <title>修改用户</title>
    <style type="text/css">

        .STYLE1 {
            color: #F5CBFF;
            font-weight: bold;
            font-size: 36px;
            font-family: "楷体_GB2312";
        }

    </style>

    <script type="text/javascript">
        function checkAll(){
            var pres = document.getElementsByName("pre");
            var preference = "";
            for(var i=0;i<pres.length;i++){
                var input = pres[i];
                if(input.checked==true){
                    preference = preference + input.value + ",";
                }
            }
            preference = preference.substr(0,preference.length-1);
            var form = document.getElementById("form");
            var input = document.createElement("input");
            input.type = "hidden";
            input.name = "preference";
            input.value = preference;
            form.appendChild(input);
            return true;
        }
    </script>
</head>
<body>
<body background="${path}/image/1.jpg">

<form id="form" action="register_check.jsp" method="post" onsubmit="return checkAll()">

    <tr>
        <p align="center" class="STYLE1">修改学生信息</p>
    </tr>
    <p align="center">
    <table align="center" border="1" cellpadding="8" bgcolor="#F5CBFF" style="width:560px;height:35px">
    <input type="hidden" name="uid" value="${user.uid}">
        <tr>
            <td>*用户名：</td>
            <td><input type="text" name="username" value="${user.uname}" />
            </td>
        </tr>
        <tr>
            <td>*邮箱：</td>
            <td><input type="text" name="email"value="${user.email}"/>
            </td>
        </tr>
        <tr>
            <td>性别：</td>
            <td>
                <c:forEach var="sex" items="${sex}">
                 <input type="radio" name="sex" value="${sex}" ${user.sex==sex?'checked':''}>${sex}
                </c:forEach>
            </td>
        </tr>
        <tr>
            <td>专业：</td>
            <td>

                <select name="major" >
                    <c:forEach var="major" items="${major}">
                        <option value="${major}" <c:if test="${user.major==major?'checked':''}"></c:if>${major}</option>
                    </c:forEach>
            </select>

            </td>
        </tr>
    <tr>
        <td>爱好</td>
        <td>
            <c:forEach var="p" items="${preferences}">
                <input type="checkbox" name="pre" value="${p}" ${fn:contains(user.preferences,p)?'checked':''}>${p}
            </c:forEach>
        </td>
    </tr>
        <tr>
            <td>备注</td>
            <td><textarea rows="3" cols="30"> ${user.others}</textarea>
        </tr>

        <tr>
            <td colspan="2"><input type="submit" value="注册"/>
                <div id="errorA" style="display:inline;color:red;"></div>
            </td>

        </tr>
    </table>
    </p>
</form>

</body>
</html>
