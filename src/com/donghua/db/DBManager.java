package com.donghua.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class DBManager {
	
	private static String URL = "jdbc:mysql://localhost:3306/test?characterEncoding=gbk";
	private static String USERNAME = "root";
	private static String PASSWORD = "root";
	/**
	 * 获取数据库连接
	 * */
	public static Connection getConnection(){

		Connection conn = null;
		
		try {
			Class.forName(Driver.class.getName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("没有加载驱动类");
		}
		try {
			conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("建立连接时出现问题");
		}
		return conn;
	}
	
	/**
	 * 查询关闭方法
	 * */
	public static void close(Connection conn,PreparedStatement ps,ResultSet rs){
		try {
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
<<<<<<< HEAD
	/**
	 * 更新操作专用关闭方法
	 * @param conn
	 * @param ps
	 * @param rs
	 */
	public static void close(Connection conn,PreparedStatement ps){
		try {
			ps.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
=======
>>>>>>> 23e69f5991fa73c7dc4daf37eb88c04320c033c3
}
