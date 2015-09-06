package cn.service.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.service.dao.BaseDao;
import cn.service.dao.ProductsBrandDao;
import cn.entity.ProductsBrand;


/*
 * 商品品牌表 DAO 实现
 * */
public class ProductsBrandDaoImpl extends BaseDao implements ProductsBrandDao {

	Connection conn = null;//数据库连接  
	PreparedStatement pstmt = null;//数据库操作  
	ResultSet rs = null;//保存查询结果  

	//商品品牌表列表
	public List<ProductsBrand> productsBrandList() {
		List<ProductsBrand> productsBrandList = new ArrayList<ProductsBrand>();
		ProductsBrand item = null;
		String sql = "select products_brand_id, products_brand_content, products_classify_id from products_brand order by products_brand_id asc";
		conn=this.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				item = new ProductsBrand(
						rs.getInt(1),
						rs.getString(2),
						rs.getInt(3)
						);
				productsBrandList.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeAll(conn, pstmt, rs);
		}
		return productsBrandList;
	}

	//根据名称获得对应的值
	public int selectKey(String productsBrandContent){
		String sql = 
				"select products_brand_id, products_brand_content, " +
						" products_classify_id from products_brand" + 
						"  where products_brand_content like ?";
		int key = 0;
		conn=this.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,"%"+ productsBrandContent+"%");
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

	//根据品牌名和分类Id插入数据
	public int insert(String productsBrand,int productsClassifyId){
		String sql = "insert into products_brand " +
				"  (products_brand_id, products_brand_content, products_classify_id) " + 
				"values " + 
				"  (products_brand_seq.nextval, ?, ?)";

		return this.executeUpdate(sql, new  Object[]{
				productsBrand,
				productsClassifyId
		}
				);
	}

	//根据分类id修改分类内容
	public int update(String productsBrandContent, int productsBrandId){
		String sql = "update products_brand " +
				"   set products_brand_content = ? " + 
				" where products_brand_id = ?";
		return this.executeUpdate(sql, new  Object[]{
				productsBrandContent,
				productsBrandId
		}
				);
	}

	//根据分类号来获取列表
	public List<ProductsBrand> productsBrandList(int productsClassifyId){
		List<ProductsBrand> productsBrandList = new ArrayList<ProductsBrand>();
		ProductsBrand item = null;
		String sql ="select products_brand_id, products_brand_content, " +
				" products_classify_id from products_brand " + 
				" where products_classify_id=?";
		conn=this.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, productsClassifyId);
			rs = pstmt.executeQuery();
			while(rs.next()){
				item = new ProductsBrand(
						rs.getInt(1),
						rs.getString(2),
						rs.getInt(3)
						);
				productsBrandList.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeAll(conn, pstmt, rs);
		}
		return productsBrandList;
	}
}
