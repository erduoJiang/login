
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>用户信息查询</title>

<script type="text/javascript" src="jquery-1.8.3.js"></script>
<link type="text/css" rel="styleSheet"  href="css/loginStyles.css" />

</head>
<body>
	<%
		String id = request.getParameter("id");
	System.out.println("****************"+id);	
	if("-1".equals(id)){
	%>	
	<div>
		<p>新增用户</p>
		<form action="checkLogin?type=add" method="post">
			<table border="1">
				<tr>
					<th>用户姓名</th>
					<th>密码</th>
					<th>性别</th>
					<th>年龄</th>
					<th>住址</th>
					
				</tr>
				<tr>
					<td><input type="text" name="userName"/></td>
					<td><input type="text" name="userPass"/></td>
					<td><input type="text" name="userSex"/></td>
					<td><input type="text" name="userAge"/></td>
					<td><input type="text" name="userAddress"/></td>
					
				</tr>
			</table>
			<input type="hidden" value="id="<%=id%>/>
			<input type="submit" value="提交"/>
		</form>
	</div>
	<%	
		}else{
	%>
	<div>
		<p>修改用户信息</p>
		<form action="checkLogin?type=modify&id=<%=id%>" method="post">
			<table border="1">
				<tr>
					<th>用户姓名</th>
					<th>密码</th>
					<th>性别</th>
					<th>年龄</th>
					<th>住址</th>
				</tr>
				<tr>
					<td><input type="text" name="userName" value="<%=new String(request.getParameter("name").getBytes("iso-8859-1"),"UTF-8")%>"/></td>
					<td><input type="text" name="userPass" value="<%=new String(request.getParameter("pass").getBytes("iso-8859-1"),"UTF-8")%>"/></td>
					<td><input type="text" name="userSex" value="<%=new String(request.getParameter("sex").getBytes("iso-8859-1"),"UTF-8")%>"/></td>
					<td><input type="text" name="userAge" value="<%=new String(request.getParameter("age").getBytes("iso-8859-1"),"UTF-8")%>"/></td>
					<td><input type="text" name="userAddress" value="<%=new String(request.getParameter("address").getBytes("iso-8859-1"),"UTF-8")%>"/></td>
					
				</tr>
				
			</table>
			<%-- <input type="hidden" value="'<%=id%>'"/> --%>
			<input type="submit" value="提交"/>
		</form>
	</div>
	<%} %>
</body>
</html>
