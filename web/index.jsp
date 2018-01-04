<%--
  Created by IntelliJ IDEA.
  User: 赖红
  Date: 2017/12/2
  Time: 17:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>

 <link rel="stylesheet" href="css/style.css" type="text/css" media="all">
<html>
  <head>
    <title>学生首页</title>
      <script src="static/js.js"></script>
  </head>
  <body>
  <h1>登录表单</h1>

  <div class="container w3layouts agileits">

      <div class="login w3layouts agileits">
          <h2>登 录</h2>
          <h5  style="text-align: center;color: red">${requestScope.message}</h5>
          <form action="LoginServlet" method="post">
              <input type="text" name="username" placeholder="用户名" autocomplete="off">
              <input type="password" name="password" placeholder="密码" autocomplete="off">

          <ul class="tick w3layouts agileits">
              <li>
                  <input type="checkbox" id="brand1" value="">
                  <label for="brand1"><span></span>记住我</label>
              </li>
          </ul>
          <div class="send-button w3layouts agileits">

                  <input type="submit" value="登 录">

          </div>
          <a href="#">记住密码?</a>
          </form>
          <div class="clear"></div>
      </div><div class="copyrights">Collect from <a href="http://www.cssmoban.com/" >企业网站模板</a></div>
      <div class="register w3layouts agileits">
          <h2>注 册</h2>
          <h5  style="text-align: center;color: red">${requestScope.masg}</h5>
          <form action="RegisterServlet" method="post">

              <input type="text" id="uname" name="uname" placeholder="用户名" autocomplete="off">
              <input type="text" id="email" name="email" placeholder="邮箱" autocomplete="off">
              <input type="password" id="password" name="password" placeholder="密码" autocomplete="off">
              <input type="password" id="password2" name="password2" placeholder="确认密码" autocomplete="off">

          <div class="send-button w3layouts agileits">
                  <input type="submit" value="免费注册">
          </div>
          </form>
          <div class="clear"></div>

      </div>
      <div class="clear"></div>
  </div>
  </div>
  </body>

</html>
