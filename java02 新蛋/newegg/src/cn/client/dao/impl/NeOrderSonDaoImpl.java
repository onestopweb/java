package cn.client.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.client.dao.BaseDao;
import cn.client.dao.NeOrderSonDao;
import cn.entity.NeOrderSon;

/*
 * 订单子表 DAO 实现
 * */
public class NeOrderSonDaoImpl extends BaseDao implements NeOrderSonDao {
	Connection conn = null;//数据库连接  
	PreparedStatement pstmt = null;//数据库操作  
	ResultSet rs = null;//保存查询结果  

	//插入订单号，商品id,和金钱和数量 
	public int insertOrderSon(String orderFatherId, int id, double money,
			int number) {
		String sql = "insert into ne_order_son " +
				"  (ne_order_father_id, ne_products_id, ne_money, ne_number) " + 
				"values " + 
				"  (?, ?, ?, ?)";
		return this.executeUpdate(sql, new  Object[]{ 
				orderFatherId,
				id,
				money,
				number
		});
	}

	//根据订单号获得列表
	public List<NeOrderSon> neOrderSonList(String orderFatherId){
		String sql = "select ne_order_father_id, ne_products_id, ne_money," +
				" ne_number from ne_order_son where ne_order_father_id = ?";
		List<NeOrderSon> list = new ArrayList<NeOrderSon>();
		NeOrderSon item = null;
		conn=this.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, orderFatherId);
			rs = pstmt.executeQuery();
			while(rs.next()){
				item = new NeOrderSon(
						rs.getString(1),
						rs.getInt(2),
						rs.getDouble(3),
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
