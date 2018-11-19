package com.donghua.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.donghua.bean.UserInfo;
import com.donghua.biz.UserBiz;

public class deleteServlet extends HttpServlet {
	
	/**
	 */
	private static final long serialVersionUID = 7212412600519392605L;
	UserBiz ub = new UserBiz();
	UserInfo ui = new UserInfo();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ub.delete((Integer.parseInt(req.getParameter("id"))));
		List<UserInfo> list = new ArrayList<UserInfo>();
		list=ub.getAllUser();
		req.setAttribute("ALLUSER", list);
		req.getRequestDispatcher("index.jsp").forward(req, resp);
		
	}
	
}
