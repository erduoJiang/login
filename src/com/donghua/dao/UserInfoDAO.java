package com.donghua.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.donghua.bean.UserInfo;
import com.donghua.db.DBManager;


public class UserInfoDAO {
	
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	/**
	 * �ж��û��Ƿ��¼�ɹ����ɹ�����ui�����򷵻�null
	 * 
	 * */
	public UserInfo checkLogin(UserInfo ui){
		
		conn = DBManager.getConnection();
		String sql = "SELECT * FROM userinfo where username = ? and userpass = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, ui.getUserName());
			ps.setString(2, ui.getUserPass());
			rs = ps.executeQuery();
			
			if(rs.next()){
				ui.setUsrId(rs.getInt(1));
				ui.setUserName(rs.getString(2));
				ui.setUserPass(rs.getString(3));
				ui.setUserSex(rs.getString(4));
				ui.setUserAge(rs.getInt(5));
				ui.setUserAddress(rs.getString(6));
			}else{
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBManager.close(conn, ps, rs);
		}
		
		return ui;
	}
	
	/**
	 * �����û����жϣ��û����Ƿ���ڣ������Ƿ���ȷ
	 * */
	public String userAndPassIsTrue(String userName){
		
		String resuPass = null;;
		conn = DBManager.getConnection();
		String sql = "SELECT * FROM userinfo where username = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, userName);
			rs = ps.executeQuery();
			
			if(rs.next()){
				resuPass = rs.getString(3);
				
			}else{
				return resuPass;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBManager.close(conn, ps, rs);
		}
		return resuPass;
	}
	
}
