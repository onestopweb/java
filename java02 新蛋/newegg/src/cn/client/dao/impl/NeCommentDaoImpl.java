package cn.client.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.client.dao.BaseDao;
import cn.client.dao.NeCommentDao;
import cn.entity.NeComment;

public class NeCommentDaoImpl extends BaseDao implements NeCommentDao {
	Connection conn = null;//数据库连接  
	PreparedStatement pstmt = null;//数据库操作  
	ResultSet rs = null;//保存查询结果  

	//根据设置商品id来获取总页数
	public int getTotalCount(int id){
		int total = 0;
		String sql = " select count(*) from ne_comment where ne_products_id=?";
		conn=this.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				total = rs.getInt(1); 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeAll(conn, pstmt, rs);
		}
		return total;
	}

	//根据设置每页的数目和第几页和商品id来获取列表数据
	public List<NeComment> getNeCommentByPage(int pageIndex, int pageSize,int id){
		int start = (pageIndex - 1) * pageSize; // 上限  
		int end = pageIndex * pageSize; // 下限
		if(start>=1){
			start++;
		}
		List<NeComment> neCommentList = new ArrayList<NeComment>();
		NeComment item = null;
		String sql = "SELECT * FROM ( SELECT A.*, ROWNUM RN " +
				"FROM (SELECT * FROM ne_comment   where " + 
				"ne_products_id =? and (ne_status_id=1 or ne_status_id=3) " +
				"order by ne_comment.ne_time desc) A) WHERE RN BETWEEN ? AND ?";
		conn=this.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rs = pstmt.executeQuery();
			while(rs.next()){
				item = new NeComment(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getInt(5)
						);
				neCommentList.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeAll(conn, pstmt, rs);
		}
		return neCommentList;
	}

	//根据商品的id和用户名插入评论内容
	public int addNeComment(int id, String username, String content){
		String sql = "insert into ne_comment " +
				"  (ne_products_id, ne_content, ne_user_id, ne_time, ne_status_id) " + 
				"values" + 
				"  (?, ?, ?, sysdate, 1)";
		return this.executeUpdate(sql, new Object[]{ 
				id , 
				content ,
				username
		});
	}

	//根据名字来在获取评论数
	public int getTotalCount(String username){
		int total = 0;
		String sql = " select count(*) from ne_comment where ne_user_id =?";
		conn=this.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, username);
			rs = pstmt.executeQuery();
			if(rs.next()){
				total = rs.getInt(1); 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeAll(conn, pstmt, rs);
		}
		return total;
	}
	//根据状态号获取列表信息
	public List<NeComment> getNeCommentByStatus(int statusId){
		List<NeComment> neCommentList = new ArrayList<NeComment>();
		NeComment item = null;
		String sql = "select ne_products_id, ne_content, ne_user_id, ne_time, " +
				" ne_status_id from ne_comment where ne_status_id=? " + 
				"  order by ne_time desc";
		conn=this.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, statusId);
			rs = pstmt.executeQuery();
			while(rs.next()){
				item = new NeComment(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getInt(5)
						);
				neCommentList.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeAll(conn, pstmt, rs);
		}
		return neCommentList;
	}

	//根据商品id和用户名来判断是否评论过
	public int selectComment(int id, String username){
		int count = 0;
		String sql = "select count(*) from ne_comment where ne_products_id=? and ne_user_id=?";
		conn=this.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.setString(2, username);
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
