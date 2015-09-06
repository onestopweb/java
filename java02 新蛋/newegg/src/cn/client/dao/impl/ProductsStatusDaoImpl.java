package cn.client.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.client.dao.BaseDao;
import cn.client.dao.ProductsStatusDao;
import cn.entity.ProductsStatus;
/*
 * 商品状态表 DAO 实现
 * */
public class ProductsStatusDaoImpl extends BaseDao implements ProductsStatusDao {
	Connection conn = null;//数据库连接  
    PreparedStatement pstmt = null;//数据库操作  
    ResultSet rs = null;//保存查询结果 
    
  //商品状态表列表
	public List<ProductsStatus> productsStatusList() {
		List<ProductsStatus> productsStatusList = new ArrayList<ProductsStatus>();
		ProductsStatus item = null;
		String sql = "select products_status_id, products_status_content, products_status_img from products_status";
		conn=this.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				item = new ProductsStatus(
					rs.getInt(1),
					rs.getString(2),
					rs.getString(3)
				);
				productsStatusList.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeAll(conn, pstmt, rs);
		}
		return productsStatusList;
	}

}
