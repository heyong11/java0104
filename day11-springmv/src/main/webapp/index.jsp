<%--
  Created by IntelliJ IDEA.
  User: 二月月i
  Date: 2021/4/13
  Time: 17:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>用户登录</title>
</head>
<body>
${erroyy}
${loginerror}
${erroy}
    <form action="login" method="get" enctype="multipart/form-data">
        用户名:<input type="text" name="username" ><br>
        密 码:<input type="password" name="password" ><br>
        <input type="submit" value="提交">
    </form>

</body>
</html>
