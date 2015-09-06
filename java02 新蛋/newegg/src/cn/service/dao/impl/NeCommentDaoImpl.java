package cn.service.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.entity.NeComment;
import cn.service.dao.BaseDao;
import cn.service.dao.NeCommentDao;
/*
 * 评论表 DAO 实现
 * */
public class NeCommentDaoImpl extends BaseDao implements NeCommentDao {
	Connection conn = null;//数据库连接  
	PreparedStatement pstmt = null;//数据库操作  
	ResultSet rs = null;//保存查询结果  

	//评论分页
	public List<NeComment> getNeCommentByPage(int pageIndex, int pageSize,
			int id, String userId) {
		int start = (pageIndex - 1) * pageSize; // 上限  
		int end = pageIndex * pageSize; // 下限
		if(start>=1){
			start++;
		}
		List<NeComment> list = new ArrayList<NeComment>();
		NeComment item = null;
		conn = this.getConnection();
		if(id>0){
			String sql = "SELECT * FROM ( SELECT A.*, ROWNUM RN " +
					"FROM (SELECT * FROM ne_comment where ne_products_id=? " + 
					" order by ne_comment.ne_time desc) A) WHERE RN BETWEEN ? AND ?";
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
					"FROM (SELECT * FROM ne_comment where ne_user_id like ? " + 
					" order by ne_comment.ne_time desc) A) WHERE RN BETWEEN ? AND ?";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%"+userId+"%");
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
					"FROM (SELECT * FROM ne_comment " + 
					" order by ne_comment.ne_time desc) A) WHERE RN BETWEEN ? AND ?";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, start);
				pstmt.setInt(2, end);
				rs = pstmt.executeQuery();
				while(rs.next()){
					item = new NeComment(
							rs.getInt(1),
							rs.getString(2),
							rs.getString(3),
							rs.getString(4),
							rs.getInt(5)
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

	//根据商品id和用户名来获取评论数量
	public int getNeCommentByCount( int id, String userId){
		int count =0;
		conn = this.getConnection();
		if(id>0){
			String sql = "SELECT count(*) FROM ne_comment where ne_products_id= ?";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, id);
				rs = pstmt.executeQuery();
				if(rs.next()){
					count = rs.getInt(1);
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}finally{
				this.closeAll(conn, pstmt, rs);
			}
			return count;
		}else if(userId!=null){
			String sql = "SELECT count(*) FROM ne_comment where ne_user_id like ?";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%"+userId+"%");
				rs = pstmt.executeQuery();
				if(rs.next()){
					count = rs.getInt(1);
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}finally{
				this.closeAll(conn, pstmt, rs);
			}
			return count;
		}else{
			String sql = "SELECT count(*) FROM ne_comment";
			try {
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				if(rs.next()){
					count = rs.getInt(1);
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}finally{
				this.closeAll(conn, pstmt, rs);
			}
			return count;
		}
	}

	//根据商品id和用户名修改评论状态
	public int updateStatusId(int id,String userId, int statusId){
		String sql = "update ne_comment " +
				"   set   ne_status_id = ?, " + 
				"         ne_time = sysdate " + 
				" where ne_products_id =? and ne_user_id =?";
		return this.executeUpdate(sql, new  Object[]{
				statusId,
				id,
				userId
		}
				);
	}

	//根据商品id和用户名获取数据
	public NeComment getComment(int id,String userId){
		NeComment item = null;
		String sql = "select ne_products_id, ne_content, ne_user_id, ne_time," +
				" ne_status_id from ne_comment where ne_products_id=? and ne_user_id =?";

		conn = this.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.setString(2, userId);
			rs = pstmt.executeQuery();
			if(rs.next()){
				item = new NeComment(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getInt(5)
						);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeAll(conn, pstmt, rs);
		}
		return item;
	}

	//根据商品id和用户名修改评论内容
	public int updateComment(int id,String userId,String comment){
		String sql = "update ne_comment " +
				"   set  ne_content = ? " + 
				"where ne_products_id=? and ne_user_id =?";

		return this.executeUpdate(sql, new  Object[]{
				comment,
				id,
				userId
		}
				);
	}
}
