package com.donghua.biz;

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
}
