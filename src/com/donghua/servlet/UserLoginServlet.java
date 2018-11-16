package com.donghua.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.donghua.bean.UserInfo;
import com.donghua.biz.UserBiz;

@SuppressWarnings("serial")
public class UserLoginServlet extends HttpServlet {
	
	private UserBiz ub = new UserBiz();
	
	
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("userName");
		String pass = request.getParameter("userPass");

		// 通过用户名判断用户名和密码是否正确
		String result = ub.userAndPassIsTrue(name);
		if(name != null && pass != null){
			if(result == null){
				request.setAttribute("NOTRUEMSG", "<font color='red'>用户名或密码输入错误</font>");
				request.getRequestDispatcher("login.jsp").forward(request, response);
				return;
			}else{
				if(!pass.equals(result)){
					request.setAttribute("NOTRUEMSG", "<font color='red'>用户名或密码输入错误</font>");
					request.getRequestDispatcher("login.jsp").forward(request, response);
					return;
				}
			}
		}
		
		UserInfo ui = new UserInfo();
		ui.setUserName(name);
		ui.setUserPass(pass);
		ui = ub.checkLogin(ui);
		if(ui == null){
//			request.setAttribute("ERRORMSG", "<font color='red'>请登录后访问</font>");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			
		}else{
			request.setAttribute("USERINFO", ui);
			request.getRequestDispatcher("index.jsp").forward(request, response);
			
		}
		
	}
}


