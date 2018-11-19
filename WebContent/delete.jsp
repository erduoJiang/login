<%@page import="com.donghua.bean.UserInfo"%>
<%@page import="com.donghua.biz.UserBiz"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title></title>
</head>

<body>
	<body>
   <%
     //1 获得客户端数据
     int id=Integer.parseInt(request.getParameter("id"));    
     //2 利用StudentDao类的delStudent(id)方法删除
     UserBiz ub=new UserBiz();
     List<UserInfo> list = new ArrayList<UserInfo>();
     
     String name = request.getParameter("userName");
	 String pass = request.getParameter("userPass");
	 UserInfo ui = new UserInfo();
	 ui.setUserName(name);
	 ui.setUserPass(pass);
     ub.checkLogin(ui);
     
     int result=ub.delete(id);
     list=ub.getAllUser();
     request.setAttribute("ALLUSER", list);
     request.setAttribute("USERINFO", ui);

     //3 回到main.jsp
     request.getRequestDispatcher("index.jsp").forward(request, response);
    %>
    <%-- <jsp:forward page="index.jsp"></jsp:forward> --%>
  </body>

</body>
</html>