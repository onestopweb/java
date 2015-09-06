package cn.service.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.entity.NeOrderFather;
import cn.service.dao.BaseDao;
import cn.service.dao.NeOrderFatherDao;

/*
 * 订单父表 DAO 实现
 * */
public class NeOrderFatherDaoImpl extends BaseDao implements NeOrderFatherDao {
	Connection conn = null;//数据库连接  
	PreparedStatement pstmt = null;//数据库操作  
	ResultSet rs = null;//保存查询结果  

	//订单列表分页
	public List<NeOrderFather> getNeOrderFatherByPage(int pageIndex, int pageSize,String orderFatherId ,String userId){
		int start = (pageIndex - 1) * pageSize; // 上限  
		int end = pageIndex * pageSize; // 下限
		if(start>=1){
			start++;
		}
		List<NeOrderFather> list = new ArrayList<NeOrderFather>();
		NeOrderFather item = null;
		conn=this.getConnection();
		if(orderFatherId==null&userId==null){
			String sql = "SELECT * FROM ( SELECT A.*, ROWNUM RN " +
					"FROM (SELECT * FROM ne_order_father " + 
					"order by ne_order_father.ne_order_time desc) A) " + 
					" WHERE RN BETWEEN ? AND ?";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, start);
				pstmt.setInt(2, end);
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
		}else if(orderFatherId!=null&userId==null){
			String sql = "SELECT * FROM ( SELECT A.*, ROWNUM RN " +
					"FROM (SELECT * FROM ne_order_father where " + 
					"ne_order_father_id like ? " + 
					"order by ne_order_father.ne_order_time desc) A) " + 
					" WHERE RN BETWEEN ? AND ?";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%"+orderFatherId+"%");
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
		}else{
			String sql = "SELECT * FROM ( SELECT A.*, ROWNUM RN " +
					"FROM (SELECT * FROM ne_order_father where " + 
					"ne_user_id like ? " + 
					"order by ne_order_father.ne_order_time desc) A) " + 
					" WHERE RN BETWEEN ? AND ?";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%"+userId+"%");
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
	}

	//根据用户名和订单号来获取总订单数
	public  int getTotalCount(String orderFatherId ,String userId){
		int total = 0;
		conn=this.getConnection();
		if(orderFatherId==null&userId==null){
			String sql = "SELECT count(*) FROM ne_order_father";
			try {
				pstmt=conn.prepareStatement(sql);
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
		}else if(orderFatherId!=null&userId==null){
			String sql = "SELECT count(*) FROM ne_order_father where\n" +
					"ne_order_father_id like ?";
			try {
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, "%"+orderFatherId+"%");
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
		}else{
			String sql = "SELECT count(*) FROM ne_order_father where\n" +
					"ne_user_id like ?";
			try {
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, "%"+userId+"%");
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

	}

	//修改订单号状态
	public int updaeOrderStatus(String orderFatherId, int statusId){
		String sql = "update ne_order_father" +
				"   set ne_status_id = ? " + 
				" where ne_order_father_id = ?";
		return this.executeUpdate(sql, new  Object[]{
				statusId,
				orderFatherId
		}
				);
	}
}
