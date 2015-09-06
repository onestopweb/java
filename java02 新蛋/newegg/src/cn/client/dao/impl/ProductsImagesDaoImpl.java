package cn.client.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.client.dao.BaseDao;
import cn.client.dao.ProductsImagesDao;
import cn.entity.ProductsImages;

/*
 * 大小图表 DAO 实现
 * */
public class ProductsImagesDaoImpl extends BaseDao implements ProductsImagesDao {
	Connection conn = null;//数据库连接  
	PreparedStatement pstmt = null;//数据库操作  
	ResultSet rs = null;//保存查询结果  

	//根据 id 查找商品大小图的数据
	public List<ProductsImages> selectList(int id) {
		List<ProductsImages> productsImagesList = new ArrayList<ProductsImages>();
		ProductsImages item = null;
		String sql = "select products_id, products_smallmap, products_large from products_images where products_id = ?";
		conn=this.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()){
				item = new ProductsImages(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3)
						);
				productsImagesList.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeAll(conn, pstmt, rs);
		}
		return productsImagesList;
	}
}
