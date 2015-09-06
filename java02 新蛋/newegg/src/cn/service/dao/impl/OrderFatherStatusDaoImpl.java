package cn.service.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.entity.OrderFatherStatus;
import cn.service.dao.BaseDao;
import cn.service.dao.OrderFatherStatusDao;

/*
 * 订单主状态表 DAO 接口
 * */
public class OrderFatherStatusDaoImpl extends BaseDao implements
OrderFatherStatusDao {
	Connection conn = null;//数据库连接  
	PreparedStatement pstmt = null;//数据库操作  
	ResultSet rs = null;//保存查询结果  

	//订单主状态列表
	public List<OrderFatherStatus> orderFatherStatusList() {
		String sql = "select order_father_status_id, order_father_status_content from order_father_status";
		List<OrderFatherStatus> list = new ArrayList<OrderFatherStatus>();
		OrderFatherStatus item = null;
		conn=this.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				item = new OrderFatherStatus(
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
