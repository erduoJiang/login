<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<<<<<<< HEAD
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
=======
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

>>>>>>> 23e69f5991fa73c7dc4daf37eb88c04320c033c3
<title></title>
</head>

<body>
	<%
<<<<<<< HEAD
		if(request.getSession().getAttribute("USERINFO") == null){
			/* request.setAttribute("ERRORMSG","<font color='red'>请登录后访问</font>"); */
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else{
			request.getSession().getAttribute("USERINFO");
		}
	%>
	
	
	this is my JSP page!!!好了，你进来了
	<a href="modify.jsp?id=-1"><input type="button" value="新增"/></a>
	<form action="checkLogin?type=find" method="post">
		<input type="text" name="find"/>
		<input type="submit" value="查询"/>
	</form>
	<table border="1">
		<tr>
		<th>用户姓名</th>
		<th>性别</th>
		<th>年龄</th>
		<th>住址</th>
		<th>操作</th>
		</tr>
			 <c:forEach items="${ALLUSER}" var="c">
                        <tr>
                              
                                <td>${c.userName}</td>
                                <td>${c.userSex}</td>
                                <td>${c.userAge}</td>
                                <td>${c.userAddress}</td>
                                <td>
                                   	<a href="modify.jsp?id=${c.usrId}&name=${c.userName}&pass=${c.userPass}&sex=${c.userSex}&age=${c.userAge}&address=${c.userAddress}">修改</a>
            						<a href="checkLogin?id=${c.usrId}&type=delete">删除</a>
 
                                </td>
                        </tr>
                            </c:forEach>
		
	</table>
=======
		if(request.getAttribute("USERINFO") == null){
			/* request.setAttribute("ERRORMSG","<font color='red'>请登录后访问</font>"); */
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else{
			request.getAttribute("USERINFO");
		}
	%>
	<div><p><%=request.getAttribute("USERINFO")==null?"":request.getAttribute("USERINFO") %></p></div>
	
	this is my JSP page!!!好了，你进来了
>>>>>>> 23e69f5991fa73c7dc4daf37eb88c04320c033c3
</body>
</html>