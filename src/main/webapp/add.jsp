<%@page pageEncoding="UTF-8" %>
<html>
<body>
<form action="${pageContext.request.contextPath}/depart/add" method="post">
    <table>
        <tr><td>部门编号：</td><td><input type="text" name="d_id"/></td></tr>
        <tr><td>部门名称：</td><td><input type="text" name="d_name"/></td></tr>
        <tr><td>部门描述：</td><td><input type="text" name="d_des"/></td></tr>
        <tr><td><input type="reset" value="重置"/></td><td><input type="submit" value="提交"/></td></tr>
    </table>
</form>
</body>
</html>