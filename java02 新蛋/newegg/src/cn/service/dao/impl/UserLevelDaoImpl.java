package cn.service.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.service.dao.BaseDao;
import cn.service.dao.UserLevelDao;
import cn.entity.UserLevel;

/*
 * 用户级别表 Dao 实现
 * */
public class UserLevelDaoImpl extends BaseDao implements UserLevelDao {
	Connection conn = null;//数据库连接  
	PreparedStatement pstmt = null;//数据库操作  
	ResultSet rs = null;//保存查询结果  

	//用户级别表列表
	public List<UserLevel> userLevelList(){
		String sql ="select user_leve_id, user_leve_content from user_level";
		List<UserLevel> list = new ArrayList<UserLevel>();
		UserLevel item = null;
		conn=this.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				item = new UserLevel(
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
