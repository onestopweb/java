package cn.service.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.entity.NeProducts;
import cn.service.dao.BaseDao;
import cn.service.dao.NeProductsDao;
/*
 * 商品表 DAO 实现
 * */
public class NeProductsDaoImpl extends BaseDao implements NeProductsDao {
	Connection conn = null;//数据库连接  
	PreparedStatement pstmt = null;//数据库操作  
	ResultSet rs = null;//保存查询结果  

	//商品列表
	public List<NeProducts> neProductsList() {
		List<NeProducts> neProductsList = new ArrayList<NeProducts>();
		NeProducts  item = null;
		String sql = "select ne_products_id, ne_classify_id, ne_brand_id," +
				"ne_model, ne_introduce, ne_bewrite, ne_print, ne_picture," + 
				"ne_price, ne_number, ne_time, ne_status_id," + 
				"ne_grounding from ne_products";
		conn = this.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				item = new NeProducts(
						rs.getInt(1),
						rs.getInt(2),
						rs.getInt(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7),
						rs.getString(8),
						rs.getDouble(9),
						rs.getInt(10),
						rs.getString(11),
						rs.getInt(12),
						rs.getString(13)
						);
				neProductsList.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeAll(conn, pstmt, rs);
		}
		return neProductsList;
	}

	//商品分页
	public List<NeProducts> getNeProductsLisByPage(int pageIndex, 
			int pageSize, int classifyId ,int brandId ,String bewrite, int statusNum){
		int start = (pageIndex - 1) * pageSize; // 上限  
		int end = pageIndex * pageSize; // 下限
		if(start>=1){
			start++;
		}
		List<NeProducts> list = new ArrayList<NeProducts>();
		NeProducts  item = null;
		conn = this.getConnection();
		if(statusNum==1){
			if(classifyId>0){
				String sql= "SELECT * FROM ( SELECT A.*, ROWNUM RN " +
						"FROM (SELECT * FROM ne_products where ne_classify_id=? " + 
						" order by ne_products.ne_time desc) A) WHERE RN BETWEEN ? AND ?";
				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, classifyId);
					pstmt.setInt(2, start);
					pstmt.setInt(3, end);
					rs = pstmt.executeQuery();
					while(rs.next()){
						item = new NeProducts(
								rs.getInt(1),
								rs.getInt(2),
								rs.getInt(3),
								rs.getString(4),
								rs.getString(5),
								rs.getString(6),
								rs.getString(7),
								rs.getString(8),
								rs.getDouble(9),
								rs.getInt(10),
								rs.getString(11),
								rs.getInt(12),
								rs.getString(13)
								);
						list.add(item);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}finally{
					this.closeAll(conn, pstmt, rs);
				}
				return list;
			}else if(brandId>0){
				String sql= "SELECT * FROM ( SELECT A.*, ROWNUM RN " +
						"FROM (SELECT * FROM ne_products where ne_brand_id=? " + 
						" order by ne_products.ne_time desc) A) WHERE RN BETWEEN ? AND ?";

				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, brandId);
					pstmt.setInt(2, start);
					pstmt.setInt(3, end);
					rs = pstmt.executeQuery();
					while(rs.next()){
						item = new NeProducts(
								rs.getInt(1),
								rs.getInt(2),
								rs.getInt(3),
								rs.getString(4),
								rs.getString(5),
								rs.getString(6),
								rs.getString(7),
								rs.getString(8),
								rs.getDouble(9),
								rs.getInt(10),
								rs.getString(11),
								rs.getInt(12),
								rs.getString(13)
								);
						list.add(item);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}finally{
					this.closeAll(conn, pstmt, rs);
				}
				return list;
			}else if(bewrite != null){
				String sql= "SELECT * FROM ( SELECT A.*, ROWNUM RN " +
						"FROM (SELECT * FROM ne_products where ne_introduce like ? " + 
						" order by ne_products.ne_time desc) A) WHERE RN BETWEEN ? AND ?";
				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, "%"+bewrite+"%");
					pstmt.setInt(2, start);
					pstmt.setInt(3, end);
					rs = pstmt.executeQuery();
					while(rs.next()){
						item = new NeProducts(
								rs.getInt(1),
								rs.getInt(2),
								rs.getInt(3),
								rs.getString(4),
								rs.getString(5),
								rs.getString(6),
								rs.getString(7),
								rs.getString(8),
								rs.getDouble(9),
								rs.getInt(10),
								rs.getString(11),
								rs.getInt(12),
								rs.getString(13)
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
				String sql= "SELECT * FROM ( SELECT A.*, ROWNUM RN " +
						"FROM (SELECT * FROM ne_products " + 
						" order by ne_products.ne_time desc) A) WHERE RN BETWEEN ? AND ?";
				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, start);
					pstmt.setInt(2, end);
					rs = pstmt.executeQuery();
					while(rs.next()){
						item = new NeProducts(
								rs.getInt(1),
								rs.getInt(2),
								rs.getInt(3),
								rs.getString(4),
								rs.getString(5),
								rs.getString(6),
								rs.getString(7),
								rs.getString(8),
								rs.getDouble(9),
								rs.getInt(10),
								rs.getString(11),
								rs.getInt(12),
								rs.getString(13)
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
		}else if(statusNum==2){
			if(classifyId>0){
				String sql= "SELECT * FROM ( SELECT A.*, ROWNUM RN " +
						"FROM (SELECT * FROM ne_products where ne_classify_id=? " + 
						" order by ne_products.ne_number desc) A) WHERE RN BETWEEN ? AND ?";
				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, classifyId);
					pstmt.setInt(2, start);
					pstmt.setInt(3, end);
					rs = pstmt.executeQuery();
					while(rs.next()){
						item = new NeProducts(
								rs.getInt(1),
								rs.getInt(2),
								rs.getInt(3),
								rs.getString(4),
								rs.getString(5),
								rs.getString(6),
								rs.getString(7),
								rs.getString(8),
								rs.getDouble(9),
								rs.getInt(10),
								rs.getString(11),
								rs.getInt(12),
								rs.getString(13)
								);
						list.add(item);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}finally{
					this.closeAll(conn, pstmt, rs);
				}
				return list;
			}else if(brandId>0){
				String sql= "SELECT * FROM ( SELECT A.*, ROWNUM RN " +
						"FROM (SELECT * FROM ne_products where ne_brand_id=? " + 
						" order by ne_products.ne_number desc) A) WHERE RN BETWEEN ? AND ?";

				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, brandId);
					pstmt.setInt(2, start);
					pstmt.setInt(3, end);
					rs = pstmt.executeQuery();
					while(rs.next()){
						item = new NeProducts(
								rs.getInt(1),
								rs.getInt(2),
								rs.getInt(3),
								rs.getString(4),
								rs.getString(5),
								rs.getString(6),
								rs.getString(7),
								rs.getString(8),
								rs.getDouble(9),
								rs.getInt(10),
								rs.getString(11),
								rs.getInt(12),
								rs.getString(13)
								);
						list.add(item);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}finally{
					this.closeAll(conn, pstmt, rs);
				}
				return list;
			}else if(bewrite != null){
				String sql= "SELECT * FROM ( SELECT A.*, ROWNUM RN " +
						"FROM (SELECT * FROM ne_products where ne_introduce like ? " + 
						" order by ne_products.ne_number desc) A) WHERE RN BETWEEN ? AND ?";
				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, "%"+bewrite+"%");
					pstmt.setInt(2, start);
					pstmt.setInt(3, end);
					rs = pstmt.executeQuery();
					while(rs.next()){
						item = new NeProducts(
								rs.getInt(1),
								rs.getInt(2),
								rs.getInt(3),
								rs.getString(4),
								rs.getString(5),
								rs.getString(6),
								rs.getString(7),
								rs.getString(8),
								rs.getDouble(9),
								rs.getInt(10),
								rs.getString(11),
								rs.getInt(12),
								rs.getString(13)
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
				String sql= "SELECT * FROM ( SELECT A.*, ROWNUM RN " +
						"FROM (SELECT * FROM ne_products " + 
						" order by ne_products.ne_number desc) A) WHERE RN BETWEEN ? AND ?";
				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, start);
					pstmt.setInt(2, end);
					rs = pstmt.executeQuery();
					while(rs.next()){
						item = new NeProducts(
								rs.getInt(1),
								rs.getInt(2),
								rs.getInt(3),
								rs.getString(4),
								rs.getString(5),
								rs.getString(6),
								rs.getString(7),
								rs.getString(8),
								rs.getDouble(9),
								rs.getInt(10),
								rs.getString(11),
								rs.getInt(12),
								rs.getString(13)
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
		}else{
			if(classifyId>0){
				String sql= "SELECT * FROM ( SELECT A.*, ROWNUM RN " +
						"FROM (SELECT * FROM ne_products where ne_classify_id=? " + 
						" order by ne_products.ne_price desc) A) WHERE RN BETWEEN ? AND ?";
				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, classifyId);
					pstmt.setInt(2, start);
					pstmt.setInt(3, end);
					rs = pstmt.executeQuery();
					while(rs.next()){
						item = new NeProducts(
								rs.getInt(1),
								rs.getInt(2),
								rs.getInt(3),
								rs.getString(4),
								rs.getString(5),
								rs.getString(6),
								rs.getString(7),
								rs.getString(8),
								rs.getDouble(9),
								rs.getInt(10),
								rs.getString(11),
								rs.getInt(12),
								rs.getString(13)
								);
						list.add(item);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}finally{
					this.closeAll(conn, pstmt, rs);
				}
				return list;
			}else if(brandId>0){
				String sql= "SELECT * FROM ( SELECT A.*, ROWNUM RN " +
						"FROM (SELECT * FROM ne_products where ne_brand_id=? " + 
						" order by ne_products.ne_price desc) A) WHERE RN BETWEEN ? AND ?";

				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, brandId);
					pstmt.setInt(2, start);
					pstmt.setInt(3, end);
					rs = pstmt.executeQuery();
					while(rs.next()){
						item = new NeProducts(
								rs.getInt(1),
								rs.getInt(2),
								rs.getInt(3),
								rs.getString(4),
								rs.getString(5),
								rs.getString(6),
								rs.getString(7),
								rs.getString(8),
								rs.getDouble(9),
								rs.getInt(10),
								rs.getString(11),
								rs.getInt(12),
								rs.getString(13)
								);
						list.add(item);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}finally{
					this.closeAll(conn, pstmt, rs);
				}
				return list;
			}else if(bewrite != null){
				String sql= "SELECT * FROM ( SELECT A.*, ROWNUM RN " +
						"FROM (SELECT * FROM ne_products where ne_introduce like ? " + 
						" order by ne_products.ne_price desc) A) WHERE RN BETWEEN ? AND ?";
				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, "%"+bewrite+"%");
					pstmt.setInt(2, start);
					pstmt.setInt(3, end);
					rs = pstmt.executeQuery();
					while(rs.next()){
						item = new NeProducts(
								rs.getInt(1),
								rs.getInt(2),
								rs.getInt(3),
								rs.getString(4),
								rs.getString(5),
								rs.getString(6),
								rs.getString(7),
								rs.getString(8),
								rs.getDouble(9),
								rs.getInt(10),
								rs.getString(11),
								rs.getInt(12),
								rs.getString(13)
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
				String sql= "SELECT * FROM ( SELECT A.*, ROWNUM RN " +
						"FROM (SELECT * FROM ne_products " + 
						" order by ne_products.ne_price desc) A) WHERE RN BETWEEN ? AND ?";
				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, start);
					pstmt.setInt(2, end);
					rs = pstmt.executeQuery();
					while(rs.next()){
						item = new NeProducts(
								rs.getInt(1),
								rs.getInt(2),
								rs.getInt(3),
								rs.getString(4),
								rs.getString(5),
								rs.getString(6),
								rs.getString(7),
								rs.getString(8),
								rs.getDouble(9),
								rs.getInt(10),
								rs.getString(11),
								rs.getInt(12),
								rs.getString(13)
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
	}

	//根据分类，品牌和描述来获取商品数量
	public int getNeProductsLisByCount(int classifyId ,int brandId ,String bewrite){
		int count = 0;
		conn = this.getConnection();
		if(classifyId>0){
			String sql = "SELECT count(*) FROM ne_products where ne_classify_id=?";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, classifyId);
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

		}else if(brandId>0){
			String sql = "SELECT count(*) FROM ne_products where ne_brand_id=?";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, brandId);
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
		}else if(bewrite != null){
			String sql = "SELECT count(*) FROM ne_products where ne_introduce like ?";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%"+bewrite+"%");
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
		}else{
			String sql = "SELECT count(*) FROM ne_products";
			try {
				pstmt = conn.prepareStatement(sql);
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

	//上架和下架
	public int updateGrounding(int id, String grounding){
		String sql ="update ne_products " +
				"   set  ne_grounding = ? " + 
				" where ne_products_id = ?";
		return this.executeUpdate(sql, new  Object[]{
				grounding,
				id
		}
				);
	}

	//修改价格
	public int updatePrice(int id, double price){
		String sql ="update ne_products " +
				"   set  ne_price = ? " + 
				" where ne_products_id = ?";
		return this.executeUpdate(sql, new  Object[]{
				price,
				id
		}
				);
	}

	//修改数量
	public int updateNumber(int id, int number){
		String sql ="update ne_products " +
				"   set  ne_number = ? " + 
				" where ne_products_id = ?";

		return this.executeUpdate(sql, new  Object[]{
				number,
				id
		}
				);
	}

	//根据 id 查找商品的数据
	public NeProducts select(int id){
		NeProducts item = null;
		String sql = "select ne_products_id, ne_classify_id, ne_brand_id, ne_model, ne_introduce," +
				" ne_bewrite, ne_print, ne_picture, ne_price, ne_number, ne_time," + 
				"  ne_status_id, ne_grounding from ne_products where ne_products_id =?";
		conn = this.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				item = new NeProducts(
						rs.getInt(1),
						rs.getInt(2),
						rs.getInt(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7),
						rs.getString(8),
						rs.getDouble(9),
						rs.getInt(10),
						rs.getString(11),
						rs.getInt(12),
						rs.getString(13)
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeAll(conn, pstmt, rs);
		}
		return item;
	}

	//根据id修改内容
	public int updateById(int id, String model,String introduce,String bewrite,
			double price, int number, int statusId){
		String sql = "update ne_products" +
				"   set ne_model = ?," + 
				"       ne_introduce = ?," + 
				"       ne_bewrite = ?," + 
				"       ne_price = ?," + 
				"       ne_number = ?," + 
				"       ne_status_id = ?" + 
				" where ne_products_id = ?";
		return this.executeUpdate(sql, new  Object[]{
				model,
				introduce,
				bewrite,
				price,
				number,
				statusId,
				id
		}
				);
	}

	//根据 id 修改内容
	public int updateById(int id, int classifyId,int brandId,
			String model,String introduce,String bewrite,
			double price, int number, int statusId,int grounding){
		String sql = 
				"update ne_products " +
						"   set ne_classify_id = ?, " + 
						"       ne_brand_id = ?, " + 
						"       ne_model = ?, " + 
						"       ne_introduce = ?, " + 
						"       ne_bewrite = ?, " + 
						"       ne_price = ?, " + 
						"       ne_number = ?, " + 
						"       ne_status_id = ?, " + 
						"       ne_grounding = ? " + 
						" where ne_products_id = ?";
		return this.executeUpdate(sql, new  Object[]{
				classifyId,
				brandId,
				model,
				introduce,
				bewrite,
				price,
				number,
				statusId,
				grounding,
				id
		}
				);
	}

	//判断些id是否存在
	public int selectId(int id){
		String sql = "select ne_products_id from ne_products where ne_products_id=?";
		conn = this.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeAll(conn, pstmt, rs);
		}
		return id;
	}

	//根据id 更新小图和中图
	public int update(int id,String print, String picture){
		String sql = "update ne_products " +
				"   set ne_print = ?, " + 
				"       ne_picture = ? " + 
				" where ne_products_id = ?";
		return this.executeUpdate(sql, new  Object[]{
				print,
				picture,
				id
		}
				);
	}

	//插入一条商品数据
	public int insert( int classifyId,int brandId,
			String model,String introduce,String bewrite,
			double price, int number, int statusId,int grounding){
		String sql = 
				"insert into ne_products " +
						"  (ne_products_id, ne_classify_id, " + 
						"  ne_brand_id, ne_model, ne_introduce, " + 
						"  ne_bewrite, ne_print, ne_picture, ne_price, " + 
						"   ne_number, ne_time, ne_status_id, ne_grounding) " + 
						"values " + 
						"  (ne_products_seq.nextval, ?, " + 
						"   ?, ?, ?, " + 
						"   ?, 'xxxm.jpg', 'xxxt.jpg', ?, " + 
						"    ?, sysdate, ?, ?)";
		return this.executeUpdate(sql, new  Object[]{
				classifyId,
				brandId,
				model,
				introduce,
				bewrite,
				price,
				number,
				statusId,
				grounding
		}
				);
	}
}
