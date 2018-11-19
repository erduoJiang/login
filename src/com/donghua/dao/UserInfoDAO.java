package com.donghua.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;
=======
>>>>>>> 23e69f5991fa73c7dc4daf37eb88c04320c033c3

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
	
<<<<<<< HEAD
	/**
	 * ��ȡ�����û���Ϣ
	 * */
	public List<UserInfo> getAllUser(){
		
		List<UserInfo> list = new ArrayList<>();
		
		conn = DBManager.getConnection();
		String sql = "SELECT * FROM userinfo";
		try {
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			 
			while(rs.next()){
				UserInfo ui = new UserInfo();
				ui.setUsrId(rs.getInt(1));
				ui.setUserName(rs.getString(2));
				ui.setUserPass(rs.getString(3));
				ui.setUserSex(rs.getString(4));
				ui.setUserAge(rs.getInt(5));
				ui.setUserAddress(rs.getString(6));
				list.add(ui);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBManager.close(conn, ps, rs);
		}
		
		return list;
	}

	/**
	 * ɾ������
	 * */
	public int delete(Integer id){
		
		int resu = 0;
		conn = DBManager.getConnection();
		String sql = "DELETE FROM userinfo WHERE usrId=?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			resu = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBManager.close(conn, ps);
		}
		
		return resu;
	}

	/**
	 * ��������
	 * */
	public int add(UserInfo ui){
		int resu = 0;
		conn = DBManager.getConnection();
		String sql = "INSERT INTO userinfo(userName,userPass,userSex,userAge,userAddress) VALUES(?,?,?,?,?)";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, ui.getUserName());
			ps.setString(2, ui.getUserPass());
			ps.setString(3, ui.getUserSex());
			ps.setInt(4, ui.getUserAge());
			ps.setString(5, ui.getUserAddress());
			resu = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBManager.close(conn, ps);
		}
		
		return resu;
	}
	
	/**
	 * �޸Ĳ���
	 * */
	public int modify(UserInfo ui){
		int resu = 0;
		conn = DBManager.getConnection();
        String sql="update userinfo set userName=?,userPass=?,userSex=?,userAge=?,userAddress=? where usrId=?";
        try {
        	ps = conn.prepareStatement(sql);
			ps.setString(1, ui.getUserName());
			ps.setString(2, ui.getUserPass());
			ps.setString(3, ui.getUserSex());
			ps.setInt(4, ui.getUserAge());
			ps.setString(5, ui.getUserAddress());
			ps.setInt(6, ui.getUsrId());
			resu = ps.executeUpdate();

        } catch (SQLException e) {
                 e.printStackTrace();
        }
        finally
        {
        	DBManager.close(conn, ps);
        }
        return resu;
	}
	
	/**
	 * �����û�����ѯ
	 * */
	public List<UserInfo> find(String name){
		
		List<UserInfo> list = new ArrayList<>();
		
		conn = DBManager.getConnection();
		String sql = "SELECT * FROM userinfo where userName LIKE ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, '%'+name+'%');
			rs = ps.executeQuery();
			 
			while(rs.next()){
				UserInfo ui = new UserInfo();
				ui.setUsrId(rs.getInt(1));
				ui.setUserName(rs.getString(2));
				ui.setUserPass(rs.getString(3));
				ui.setUserSex(rs.getString(4));
				ui.setUserAge(rs.getInt(5));
				ui.setUserAddress(rs.getString(6));
				list.add(ui);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBManager.close(conn, ps, rs);
		}
		
		return list;
	}
=======
>>>>>>> 23e69f5991fa73c7dc4daf37eb88c04320c033c3
}
