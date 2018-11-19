package com.donghua.biz;

<<<<<<< HEAD
import java.util.List;

=======
>>>>>>> 23e69f5991fa73c7dc4daf37eb88c04320c033c3
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
<<<<<<< HEAD
	
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
=======
>>>>>>> 23e69f5991fa73c7dc4daf37eb88c04320c033c3
}
