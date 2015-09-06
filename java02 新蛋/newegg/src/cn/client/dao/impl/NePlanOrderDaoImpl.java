package cn.client.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.client.dao.BaseDao;
import cn.client.dao.NePlanOrderDao;
import cn.entity.NePlanOrder;

/*
 * 预订单表 DAO 实现
 * */
public class NePlanOrderDaoImpl extends BaseDao implements NePlanOrderDao {
	Connection conn = null;//数据库连接  
	PreparedStatement pstmt = null;//数据库操作  
	ResultSet rs = null;//保存查询结果  

	//预订单的列表，根据名字和状态号来获取列表数据
	public List<NePlanOrder> nePlanOrderList(String username, int statusId) {
		List<NePlanOrder> list = new ArrayList<NePlanOrder>();
		NePlanOrder item = null;
		String sql = "select ne_products_id, ne_number, ne_user_id, ne_time," +
				"ne_status_id from ne_plan_order where ne_user_id=? and ne_status_id = ?";
		conn = this.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setInt(2, statusId);
			rs = pstmt.executeQuery();
			while(rs.next()){
				item = new NePlanOrder(
						rs.getInt(1),
						rs.getInt(2),
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

	//删除预订单，根据商品id和名字和状态号
	public int deletePlanOrder (int id, String username, int statusId){
		String sql = "delete ne_plan_order" +
				" where ne_products_id=? and ne_user_id=? and ne_status_id=?";
		return this.executeUpdate(sql, new Object[]{ id, username, statusId});
	}

	//删除预订单，根据用户名字和状态号
	public int deletePlanOrder(String username, int statusId){
		String sql = "delete ne_plan_order" +
				" where ne_user_id=? and ne_status_id = ?";

		return this.executeUpdate(sql, new Object[]{ username, statusId});
	}

	//修改除预订单，根据商品id和名字和状态号和数量
	public int updatePlanOrder(int id, String username, int statusId, int number){
		String sql = "update ne_plan_order" +
				"   set ne_number = ?" + 
				" where ne_products_id =? and ne_user_id =? and ne_status_id=?";
		return this.executeUpdate(sql, new Object[]{number, id, username, statusId});
	}

	//插入一条数据，根据商品id和名字和状态号和数量
	public int insertPlanOrder(int id, String username, int statusId, int number){
		String sql = "insert into ne_plan_order" +
				"  (ne_products_id, ne_number, ne_user_id, ne_time, ne_status_id)" + 
				" values" + 
				"  (?, ?, ?, sysdate, ?)";
		return this.executeUpdate(sql, new Object[]{ id,number, username, statusId});
	}

	//判断是否已经存在相同的产品，根据商品id和名字和状态号
	public int selectPlanOrde(int id, String username, int statusId){
		String sql = "select count(*) from ne_plan_order where " +
				" ne_products_id=? and ne_user_id=? and ne_status_id=?";
		int count =0;
		conn = this.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.setString(2, username);
			pstmt.setInt(3, statusId);
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
