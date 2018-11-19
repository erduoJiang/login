package com.donghua.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.donghua.bean.UserInfo;
import com.donghua.biz.UserBiz;

@SuppressWarnings("serial")
public class UserLoginServlet extends HttpServlet {
	
	private UserBiz ub = new UserBiz();
	List<UserInfo> list=ub.getAllUser();
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}


	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException {
		
		
		String type = request.getParameter("type");
		Map<String, String[]> map = new HashMap<>();
		map = request.getParameterMap();
		for (Entry<String, String[]> entry : map.entrySet()) { 
			System.out.println("_______________");
			  System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue()); 
			}
		System.out.println(request.getParameterMap());
		request.setCharacterEncoding("UTF-8");
		
		
		if("login".equals(type)){
			
//			String name = request.getParameter("userName");
			String pass = request.getParameter("userPass");
			String name	=new String(request.getParameter("userName").getBytes("iso-8859-1"),"UTF-8");

			// ͨ���û����ж��û���������Ƿ���ȷ
			String result = ub.userAndPassIsTrue(name);
			if(name != null && pass != null){
				if(result == null){
					request.setAttribute("NOTRUEMSG", "<font color='red'>�û���������������</font>");
					request.getRequestDispatcher("login.jsp").forward(request, response);
					return;
				}else{
					if(!pass.equals(result)){
						request.setAttribute("NOTRUEMSG", "<font color='red'>�û���������������</font>");
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
//				request.setAttribute("ERRORMSG", "<font color='red'>���¼�����</font>");
				request.getRequestDispatcher("login.jsp").forward(request, response);
				
			}else{
				request.getSession().setAttribute("USERINFO", ui);
				request.setAttribute("ALLUSER", list);
				request.getRequestDispatcher("index.jsp").forward(request, response);
				
			}
			
		}else if("delete".equals(type)){
			ub.delete((Integer.parseInt(request.getParameter("id"))));
			
			request.setAttribute("ALLUSER", ub.getAllUser());
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else if("add".equals(type)){
			UserInfo ui = new UserInfo();
			
			//新增操作
			String name = new String(request.getParameter("userName").getBytes("iso-8859-1"),"UTF-8");
			String pass = new String(request.getParameter("userPass").getBytes("iso-8859-1"),"UTF-8");
			String sex = new String(request.getParameter("userSex").getBytes("iso-8859-1"),"UTF-8");
			String age = new String(request.getParameter("userAge").getBytes("iso-8859-1"),"UTF-8");
			String address = new String(request.getParameter("userAddress").getBytes("iso-8859-1"),"UTF-8");
			ui.setUserName(name);
			ui.setUserPass(pass);
			ui.setUserSex(sex);
			ui.setUserAge(Integer.parseInt(age));
			ui.setUserAddress(address);
			ub.add(ui);
			request.setAttribute("ALLUSER", ub.getAllUser());
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else if("modify".equals(type)){
			UserInfo ui = new UserInfo();
			//修改操作
			String name = new String(request.getParameter("userName").getBytes("iso-8859-1"),"UTF-8");
			String pass = new String(request.getParameter("userPass").getBytes("iso-8859-1"),"UTF-8");
			String sex = new String(request.getParameter("userSex").getBytes("iso-8859-1"),"UTF-8");
			String age = new String(request.getParameter("userAge").getBytes("iso-8859-1"),"UTF-8");
			String address = new String(request.getParameter("userAddress").getBytes("iso-8859-1"),"UTF-8");
			String id = new String(request.getParameter("id").getBytes("iso-8859-1"),"UTF-8");
			ui.setUserName(name);
			ui.setUserPass(pass);
			ui.setUserSex(sex);
			ui.setUserAge(Integer.parseInt(age));
			ui.setUserAddress(address);
			ui.setUsrId(Integer.parseInt(id));
			ub.modify(ui);
			request.setAttribute("ALLUSER", ub.getAllUser());
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else if("find".equals(type)){
//			ub.find(new String(request.getParameter("find").getBytes("iso-8859-1"),"UTF-8"));
			
			request.setAttribute("ALLUSER", ub.find(new String(request.getParameter("find").getBytes("iso-8859-1"),"UTF-8")));
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}
}


