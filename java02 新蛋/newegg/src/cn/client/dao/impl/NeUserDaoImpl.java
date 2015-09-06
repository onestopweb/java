package cn.client.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.client.dao.BaseDao;
import cn.client.dao.NeUserDao;
import cn.entity.NeUser;
/*
 * 用户表 DAO 实现
 * */
public class NeUserDaoImpl extends BaseDao implements NeUserDao {
	Connection conn = null;//数据库连接  
	PreparedStatement pstmt = null;//数据库操作  
	ResultSet rs = null;//保存查询结果  

	//登陆方法
	public int login(String username, String password) {
		String sql = " select count(*) from ne_user where NE_USER_ID=? and " +
				"NE_PASSWORD=? and NE_LEVEL_ID='1'";
		conn=this.getConnection();
		int count = 0;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			if(rs.next()){
				count = rs.getInt(1); 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeAll(conn, pstmt, rs);
		}
		return count;
	}

	//注册方法
	public int register(String username,String password){
		String sql = "insert into ne_user (NE_USER_ID, NE_PASSWORD, NE_USERNAME, NE_TEL, NE_PHONE, NE_EMAIL," +
				" NE_POSTALCODE, NE_SAVE, NE_CITY, NE_BOROUGH, NE_ADDRESS, NE_LEVEL_ID)" + 
				"values (?, ?,null, null, null, null, null, null, null, null, null, 1)";
		return this.executeUpdate(sql, new Object[]{ username, password});
	}

	//ajaxUser验证
	public int ajaxUser(String username){
		String sql = " select count(*) from ne_user where NE_USER_ID=? ";
		conn=this.getConnection();
		int count = 0;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, username);
			rs = pstmt.executeQuery();
			if(rs.next()){
				count = rs.getInt(1); 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeAll(conn, pstmt, rs);
		}
		return count;
	}

	//根据用户ID获得对应的用户资料
	public NeUser select(String username){
		String sql = "select ne_user_id, ne_password, ne_username, ne_tel, ne_phone, ne_email," +
				" ne_postalcode, ne_save, ne_city, ne_borough, ne_address," + 
				" ne_level_id from ne_user where ne_user_id=?";
		NeUser item = null;
		conn = this.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, username);
			rs = pstmt.executeQuery();
			if(rs.next()){
				item = new NeUser(
						rs.getString(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7),
						rs.getString(8),
						rs.getString(9),
						rs.getString(10),
						rs.getString(11),
						rs.getInt(12)
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeAll(conn, pstmt, rs);
		}
		return item;
	}

	//修改用户资料
	public int update(String ne_username, String ne_tel, String ne_phone, String ne_email, String ne_postalcode, 
			String ne_save,String ne_city, String ne_borough, String ne_address, String ne_user_id){
		String sql ="update ne_user" +
				"   set ne_username = ?," + 
				"       ne_tel = ?," + 
				"       ne_phone = ?," + 
				"       ne_email = ?," + 
				"       ne_postalcode = ?," + 
				"       ne_save = ?," + 
				"       ne_city = ?," + 
				"       ne_borough = ?," + 
				"       ne_address = ?" + 
				" where ne_user_id = ?";

		return this.executeUpdate(sql, new Object[]{ 
				ne_username, 
				ne_tel,
				ne_phone, 
				ne_email,
				ne_postalcode, 
				ne_save,
				ne_city,
				ne_borough,
				ne_address, 
				ne_user_id});
	}
}
