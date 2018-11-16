<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title></title>
</head>

<body>
	<%
		if(request.getAttribute("USERINFO") == null){
			/* request.setAttribute("ERRORMSG","<font color='red'>请登录后访问</font>"); */
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else{
			request.getAttribute("USERINFO");
		}
	%>
	<div><p><%=request.getAttribute("USERINFO")==null?"":request.getAttribute("USERINFO") %></p></div>
	
	this is my JSP page!!!好了，你进来了
</body>
</html>