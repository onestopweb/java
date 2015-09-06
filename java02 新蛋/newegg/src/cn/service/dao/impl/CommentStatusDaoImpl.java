package cn.service.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.entity.CommentStatus;
import cn.service.dao.BaseDao;
import cn.service.dao.CommentStatusDao;

/*
 * 评论状态表 DAO 实现
 * */
public class CommentStatusDaoImpl extends BaseDao implements CommentStatusDao {

	Connection conn = null;//数据库连接  
	PreparedStatement pstmt = null;//数据库操作  
	ResultSet rs = null;//保存查询结果  

	//评论状态列表
	public List<CommentStatus> commentStatusList() {
		String sql ="select comment_status_id, comment_status_content from comment_status";
		List<CommentStatus> list = new ArrayList<CommentStatus>();
		CommentStatus item = null;
		conn=this.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				item = new CommentStatus(
						rs.getInt(1),
						rs.getString(2)
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
