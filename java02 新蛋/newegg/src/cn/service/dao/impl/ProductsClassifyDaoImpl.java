package cn.service.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.service.dao.BaseDao;
import cn.service.dao.ProductsClassifyDao;
import cn.entity.ProductsClassify;


/*
 * 商品类型表 DAO 实现
 * */
public class ProductsClassifyDaoImpl extends BaseDao implements
ProductsClassifyDao {
	Connection conn = null;//数据库连接  
	PreparedStatement pstmt = null;//数据库操作  
	ResultSet rs = null;//保存查询结果  

	//商品品牌表列表
	public List<ProductsClassify> productsClassifyList() {
		List<ProductsClassify> productsClassifyList = new ArrayList<ProductsClassify>();
		ProductsClassify item = null;
		String sql = "select products_classify_id, products_classify_content from products_classify order by products_classify_id asc";
		conn=this.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				item = new ProductsClassify(
						rs.getInt(1),
						rs.getString(2)
						);
				productsClassifyList.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeAll(conn, pstmt, rs);
		}
		return productsClassifyList;
	}

	//根据名称获得对应的值
	public int selectKey(String productsClassifyContent){
		String sql = "select products_classify_id from " +
				"products_classify where products_classify_content=?";
		int key = 0;
		conn=this.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, productsClassifyContent);
			rs = pstmt.executeQuery();
			if(rs.next()){
				key = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeAll(conn, pstmt, rs);
		}
		return key;
	}

	//根据类型插入数据
	public int insert(String productsClassify){
		String sql = "insert into products_classify " +
				"  (products_classify_id, products_classify_content) " + 
				"values " + 
				"  (products_classify_seq.nextval, ?)";
		return this.executeUpdate(sql, new  Object[]{
				productsClassify
		}
				);
	}

	//根据分类id修改分类内容
	public int update(String productsClassifyContent, int productsClassifyId){
		String sql = "update products_classify " +
				"   set  products_classify_content = ? " + 
				" where products_classify_id = ?";
		return this.executeUpdate(sql, new  Object[]{
				productsClassifyContent,
				productsClassifyId
		}
				);
	}
}
