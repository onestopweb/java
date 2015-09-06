package cn.client.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.client.dao.BaseDao;
import cn.client.dao.ProductsContentDao;
import cn.entity.ProductsContent;

/*
 * 内容表 DAO 实现
 * */
public class ProductsContentDaoImpl extends BaseDao implements
ProductsContentDao {
	
	Connection conn = null;//数据库连接  
	PreparedStatement pstmt = null;//数据库操作  
	ResultSet rs = null;//保存查询结果  
	
	//根据 id 查找商品内容的数据
	public List<ProductsContent> selectList(int id){
		List<ProductsContent> productsContentList = new ArrayList<ProductsContent>();
		ProductsContent item = null;
		String sql = "select products_id, products_content from products_content where products_id = ? order by products_content asc";
		conn=this.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()){
			item = new ProductsContent(
					rs.getInt(1),
					rs.getString(2)
					);
			productsContentList.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeAll(conn, pstmt, rs);
		}
		return productsContentList;
	}
}
