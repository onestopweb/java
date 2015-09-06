package cn.client.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.client.dao.BaseDao;
import cn.client.dao.NeOrderFatherDao;
import cn.entity.NeOrderFather;

/*
 * 订单父表 DAO 实现
 * */
public class NeOrderFatherDaoImpl extends BaseDao implements NeOrderFatherDao {
	Connection conn = null;//数据库连接  
	PreparedStatement pstmt = null;//数据库操作  
	ResultSet rs = null;//保存查询结果  

	//插入新的订单号和用户名
	public int insertOrderFather(String orderFatherId, String username) {
		String sql = "insert into ne_order_father" +
				"  (ne_order_father_id, ne_user_id, ne_order_time, ne_status_id)" + 
				"values" + 
				"  (?, ?, sysdate, 1)";
		return this.executeUpdate(sql, new  Object[]{ 
				orderFatherId,
				username
		});
	}

	//根据用户名来获取总订单数
	public  int getTotalCount(String username){
		int total = 0;
		String sql = "select count(*) from ne_order_father where ne_user_id =?";
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

	//根据用户名和状态号来获取订单数
	public  int getTotalCount(String username,int statusId){
		int total = 0;
		String sql = "select count(*) from ne_order_father where ne_user_id =? and ne_status_id=?";
		conn=this.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setInt(2, statusId);
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

	//根据设置每页的数目和第几页和用户名来获取列表数据
	public List<NeOrderFather> getNeOrderFatherByPage(int pageIndex, int pageSize,String username){
		int start = (pageIndex - 1) * pageSize; // 上限  
		int end = pageIndex * pageSize; // 下限
		if(start>=1){
			start++;
		}
		List<NeOrderFather> list = new ArrayList<NeOrderFather>();
		NeOrderFather item = null;
		String sql ="SELECT * FROM ( SELECT A.*, ROWNUM RN " +
				"FROM (SELECT * FROM ne_order_father  where " + 
				"ne_user_id =? " + 
				"order by ne_order_father.ne_order_time desc) A) WHERE RN BETWEEN ? AND ?";
		conn=this.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rs = pstmt.executeQuery();
			while(rs.next()){
				item = new NeOrderFather(
						rs.getString(1),
						rs.getString(2),
						rs.getString(3),
						rs.getInt(4)
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

	//修改订单状态,根据订单号，和要修改的状态号
	public int update(String orderFatherId,int statusId){
		String sql= "update ne_order_father " +
						"   set ne_status_id = ? " + 
						" where ne_order_father_id = ?";
		return this.executeUpdate(sql, new Object[]{
				statusId,
				orderFatherId
		});
	}
}
