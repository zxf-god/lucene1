<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/14
  Time: 9:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录界面</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/admin/login" method="post"><table>
    <tr><td>用户名：</td><td><input type="text" name="a_name"></td></tr>
    <tr><td>密码：</td><td><input type="password" name="a_password"></td></tr>
    <tr><td><input type="reset" value="重置"></td><td><input type="submit" value="登录"></td></tr>
</table></form>
</body>
</html>
