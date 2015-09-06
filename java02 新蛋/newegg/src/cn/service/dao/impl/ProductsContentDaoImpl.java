package cn.service.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.entity.ProductsContent;
import cn.service.dao.BaseDao;
import cn.service.dao.ProductsContentDao;

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

	//根据id删除商品内容的数据
	public int delete(int id){
		String sql = "delete products_content " +
				" where products_id =?";
		return this.executeUpdate(sql, new  Object[]{
				id
		}
				);
	}

	//根据id和内容名称删除单个商品内容的数据
	public int delete(int id, String productsContent){
		String sql = 	"delete products_content " +
				" where products_id = ? and products_content =?";
		return this.executeUpdate(sql, new  Object[]{
				id,
				productsContent
		}
				);
	}

	//根据id插入内容图
	public int insert(int id, String productsContent){
		String sql = "insert into products_content " +
				"  (products_id, products_content) " + 
				"values " + 
				"  (?, ?)";
		return this.executeUpdate(sql, new  Object[]{
				id,
				productsContent
		}
				);
	}

}
