package cn.service.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.service.dao.BaseDao;
import cn.service.dao.NeUserDao;
import cn.entity.NeUser;

/*
 * 用户表 DAO 实现
 * */
public class NeUserDaoImpl extends BaseDao implements NeUserDao {
	Connection conn = null;//数据库连接  
	PreparedStatement pstmt = null;//数据库操作  
	ResultSet rs = null;//保存查询结果  

	//后台登陆方法
	public int loginOfAdmin(String inputAdmin, String inputPass) {
		String sql = "select count(*) from ne_user where " +
				"ne_user_id=? and " + 
				"ne_password=? " + 
				"and(ne_level_id=2 or ne_level_id=3)";
		conn=this.getConnection();
		int count = 0;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, inputAdmin);
			pstmt.setString(2, inputPass);
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

	//用户列表分页
	public List<NeUser> getNeUserByPage(int pageIndex, 
			int pageSize, int levelId,String userId ){
		int start = (pageIndex - 1) * pageSize; // 上限  
		int end = pageIndex * pageSize; // 下限
		if(start>=1){
			start++;
		}
		List<NeUser> list = new ArrayList<NeUser>();
		NeUser item = null;
		conn = this.getConnection();
		if(levelId >0 && userId !=null){
			String sql = "SELECT * FROM ( SELECT A.*, ROWNUM RN " +
					"FROM (SELECT * FROM ne_user where ne_level_id=? " + 
					" and ne_user_id like ? " + 
					"order by ne_user.ne_user_id ASC) A) " + 
					" WHERE RN BETWEEN ? AND ?";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, levelId);
				pstmt.setString(2, "%"+userId+"%");
				pstmt.setInt(3, start);
				pstmt.setInt(4, end);
				rs = pstmt.executeQuery();
				while(rs.next()){
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
					list.add(item);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				this.closeAll(conn, pstmt, rs);
			}
			return list;
		}else if(levelId>0 && userId ==null){
			String sql = "SELECT * FROM ( SELECT A.*, ROWNUM RN " +
					"FROM (SELECT * FROM ne_user where ne_level_id=? " + 
					"order by ne_user.ne_user_id ASC) A) " + 
					" WHERE RN BETWEEN ? AND ?";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, levelId);
				pstmt.setInt(2, start);
				pstmt.setInt(3, end);
				rs = pstmt.executeQuery();
				while(rs.next()){
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
					list.add(item);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				this.closeAll(conn, pstmt, rs);
			}
			return list;
		}else if(userId!=null){
			String sql = "SELECT * FROM ( SELECT A.*, ROWNUM RN " +
					"FROM (SELECT * FROM ne_user where ne_user_id like ? " + 
					"order by ne_user.ne_user_id ASC) A) " + 
					" WHERE RN BETWEEN ? AND ?";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%"+userId+"%");
				pstmt.setInt(2, start);
				pstmt.setInt(3, end);
				rs = pstmt.executeQuery();
				while(rs.next()){
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
					list.add(item);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				this.closeAll(conn, pstmt, rs);
			}
			return list;
		}else{
			String sql = "SELECT * FROM ( SELECT A.*, ROWNUM RN " +
					"FROM (SELECT * FROM ne_user " + 
					"order by ne_user.ne_user_id ASC) A) " + 
					" WHERE RN BETWEEN ? AND ?";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, start);
				pstmt.setInt(2, end);
				rs = pstmt.executeQuery();
				while(rs.next()){
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
					list.add(item);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				this.closeAll(conn, pstmt, rs);
			}
			return list;
		}
	}

	//获取数量
	public int getNeUserByCount(int levelId,String userId){
		int count = 0;
		conn = this.getConnection();
		if(levelId >0 && userId !=null){
			String sql = "SELECT count(*) FROM ne_user where ne_level_id=? " +
					" and ne_user_id like ?";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, levelId);
				pstmt.setString(2, "%"+userId+"%");
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
		}else if(levelId>0 && userId ==null){
			String sql = "SELECT count(*) FROM ne_user where ne_level_id=?";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, levelId);
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
		}else if(userId!=null){
			String sql = "SELECT count(*) FROM ne_user where  ne_user_id like ?";

			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%"+userId+"%");
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
		}else{
			String sql = "SELECT count(*) FROM ne_user";
			try {
				pstmt = conn.prepareStatement(sql);
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
	}

	//注销
	public int logoutUser(String logout){
		String sql = "update ne_user " +
				"   set ne_level_id = 4 " + 
				" where ne_user_id = ?";
		return this.executeUpdate(sql, new  Object[]{
				logout
		}
				);
	}

	//查找用用户数据
	public NeUser select(String userId){
		String sql = "select ne_user_id, ne_password, ne_username, ne_tel, ne_phone, ne_email," +
				" ne_postalcode, ne_save, ne_city, ne_borough, ne_address," + 
				" ne_level_id from ne_user where ne_user_id=?";
		NeUser item = null;
		conn = this.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userId);
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

	//根据用户ID修改用户数据
	public int update(String username,String tel, String phone, String email, 
			String postalcode,String save, String city,String borough,String address,String updateName){
		String sql ="update ne_user " +
				"   set " + 
				"       ne_username = ?, " + 
				"       ne_tel = ?, " + 
				"       ne_phone = ?, " + 
				"       ne_email = ?, " + 
				"       ne_postalcode = ?, " + 
				"       ne_save = ?, " + 
				"       ne_city = ?, " + 
				"       ne_borough = ?, " + 
				"       ne_address = ? " + 
				" where ne_user_id = ?";
		return this.executeUpdate(sql, new  Object[]{
				username,
				tel, 
				phone, 
				email, 
				postalcode,
				save,
				city,
				borough,
				address,
				updateName
		}
				);
	}

	//插入一条用户数据
	public int insert(String userId, String password, String username, String phone, int levelId){
		String sql = "insert into ne_user " +
				"  (ne_user_id, ne_password, ne_username, ne_tel, " + 
				"  ne_phone, ne_email, ne_postalcode, " + 
				"  ne_save, ne_city, ne_borough, " + 
				"  ne_address, ne_level_id) " + 
				"values " + 
				"  (?, ?, ?, null, " + 
				"   ?, null, null, null, null, null, null, ?)";

		return this.executeUpdate(sql, new  Object[]{
				userId,
				password,
				username,
				phone,
				levelId
		}
				);
	}

	//ajaxUser验证
	public int ajaxUser(String userId){
		String sql = " select count(*) from ne_user where NE_USER_ID=? ";
		conn=this.getConnection();
		int count = 0;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userId);
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
}
