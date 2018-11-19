package com.donghua.biz;

import java.util.List;

import com.donghua.bean.UserInfo;
import com.donghua.dao.UserInfoDAO;

public class UserBiz {
	public UserInfoDAO uiDao = new UserInfoDAO();
	
	public UserInfo checkLogin(UserInfo ui){
		return uiDao.checkLogin(ui);
	}
	public String userAndPassIsTrue(String userName){
		return uiDao.userAndPassIsTrue(userName);
	}
	
	public List<UserInfo> getAllUser(){
		
		return uiDao.getAllUser();
	}
	
	public int delete(int id){
		return uiDao.delete(id);
	}
	
	public int add(UserInfo ui){
		return uiDao.add(ui);
	}
	
	public int modify(UserInfo ui){
		return uiDao.modify(ui);
	}
	
	public List<UserInfo> find(String name){
		
		return uiDao.find(name);
	}
}
