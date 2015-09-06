package cn.client.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.client.dao.BaseDao;
import cn.client.dao.NeProductsDao;
import cn.entity.NeProducts;
/*
 * 商品表 DAO 实现
 * */
public class NeProductsDaoImpl extends BaseDao implements NeProductsDao {
	Connection conn = null;//数据库连接  
	PreparedStatement pstmt = null;//数据库操作  
	ResultSet rs = null;//保存查询结果  

	//商品列表
	public List<NeProducts> neProductsList(){
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

	//手机摄影类
	public List<NeProducts> nePhone_photographyList() {
		List<NeProducts> neProductsList = new ArrayList<NeProducts>();
		NeProducts  item = null;
		String sql = "select ne_products_id, ne_classify_id, ne_brand_id, ne_model, ne_introduce," +
				"ne_bewrite, ne_print, ne_picture, ne_price, ne_number, ne_time," + 
				" ne_status_id, ne_grounding from ne_products " + 
				"where  ne_grounding=0 and (ne_classify_id=1 or ne_classify_id=3 or ne_classify_id=4)" + 
				" and rownum<7 order by ne_time desc";
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

	//电脑平板类
	public List<NeProducts> neComputer_tabletList() {
		List<NeProducts> neProductsList = new ArrayList<NeProducts>();
		NeProducts  item = null;
		String sql = "select ne_products_id, ne_classify_id, ne_brand_id, ne_model, ne_introduce," +
				"ne_bewrite, ne_print, ne_picture, ne_price, ne_number, ne_time," + 
				" ne_status_id, ne_grounding from ne_products " + 
				"where  ne_grounding=0 and (ne_classify_id=2 or ne_classify_id=6)" + 
				" and rownum<7 order by ne_time desc";
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

	//根据类来获取列表
	public List<NeProducts> neRankList(int classifyId){
		List<NeProducts> list = new ArrayList<NeProducts>();
		NeProducts  item = null;
		String sql = "select ne_products_id, ne_classify_id, ne_brand_id, ne_model, ne_introduce," +
				"ne_bewrite, ne_print, ne_picture, ne_price, ne_number, ne_time, ne_status_id," + 
				"ne_grounding from ne_products where ne_grounding=0 and ne_classify_id=?  and rownum<5  order by ne_time desc";
		conn = this.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, classifyId);
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

	//推荐系列
	public List<NeProducts> neGroomList(int statusId){
		List<NeProducts> list = new ArrayList<NeProducts>();
		NeProducts  item = null;
		String sql = "select ne_products_id, ne_classify_id, ne_brand_id, ne_model, ne_introduce, ne_bewrite," +
				" ne_print, ne_picture, ne_price, ne_number, ne_time," + 
				"  ne_status_id, ne_grounding from ne_products" + 
				" where ne_grounding=0 and ne_status_id=? and rownum<6 order by ne_time desc";
		conn = this.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, statusId);
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

	//根据状态号来获取列表
	public List<NeProducts> neListBystatusId(int statusId){
		String sql = "select ne_products_id, ne_classify_id," +
				" ne_brand_id, ne_model, ne_introduce," + 
				"  ne_bewrite, ne_print, ne_picture," + 
				"   ne_price, ne_number, ne_time," + 
				"   ne_status_id, ne_grounding" + 
				"   from ne_products where ne_grounding=0 and ne_status_id=? order by ne_time desc";
		List<NeProducts> list = new ArrayList<NeProducts>();
		NeProducts  item = null;
		conn = this.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, statusId);
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

	//搜索分页
	public List<NeProducts> getNeProductsByPage(int pageIndex, 
			int pageSize, int classifyId ,int brandId ,String bewrite, double priceBegin,
			double priceEnd, int statusNum){
		int start = (pageIndex - 1) * pageSize; // 上限  
		int end = pageIndex * pageSize; // 下限
		if(start>=1){
			start++;
		}
		if(priceEnd <= 1){
			priceBegin = 0;
			priceEnd = 1000000;
		}
		List<NeProducts> list = new ArrayList<NeProducts>();
		NeProducts  item = null;
		conn = this.getConnection();
		if(statusNum == 1){
			if(classifyId <=0 && brandId <=0){
				String sql = "SELECT * FROM ( SELECT A.*, ROWNUM RN " +
						"FROM (SELECT * FROM ne_products where ne_grounding=0 and ne_introduce like ? " + 
						" and ne_price>=? and ne_price<=? " + 
						" order by ne_products.ne_number desc) A) WHERE RN BETWEEN ? AND ?";
				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, "%"+bewrite+"%");
					pstmt.setDouble(2, priceBegin);
					pstmt.setDouble(3, priceEnd);
					pstmt.setInt(4, start);
					pstmt.setInt(5, end);
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
			}else if(classifyId >0 && brandId <=0){
				String sql = "SELECT * FROM ( SELECT A.*, ROWNUM RN " +
						"FROM (SELECT * FROM ne_products where ne_grounding=0 and ne_classify_id = ? " + 
						" and ne_price>=? and ne_price<=? " + 
						" order by ne_products.ne_number desc) A) WHERE RN BETWEEN ? AND ?";
				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, classifyId);
					pstmt.setDouble(2, priceBegin);
					pstmt.setDouble(3, priceEnd);
					pstmt.setInt(4, start);
					pstmt.setInt(5, end);
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
				String sql = "SELECT * FROM ( SELECT A.*, ROWNUM RN " +
						"FROM (SELECT * FROM ne_products where ne_grounding=0 and ne_brand_id = ?" + 
						"  and ne_price>=? and ne_price<=? " + 
						" order by ne_products.ne_number desc) A) WHERE RN BETWEEN ? AND ?";
				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, brandId);
					pstmt.setDouble(2, priceBegin);
					pstmt.setDouble(3, priceEnd);
					pstmt.setInt(4, start);
					pstmt.setInt(5, end);
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

		}else if(statusNum == 2){
			if(classifyId <=0 && brandId <=0){
				String sql = "SELECT * FROM ( SELECT A.*, ROWNUM RN " +
						"FROM (SELECT * FROM ne_products where ne_grounding=0 and ne_introduce like ? " + 
						" and ne_price>=? and ne_price<=? " + 
						" order by ne_products.ne_price desc) A) WHERE RN BETWEEN ? AND ?";
				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, "%"+bewrite+"%");
					pstmt.setDouble(2, priceBegin);
					pstmt.setDouble(3, priceEnd);
					pstmt.setInt(4, start);
					pstmt.setInt(5, end);
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
			}else if(classifyId >0 && brandId <=0){
				String sql = "SELECT * FROM ( SELECT A.*, ROWNUM RN " +
						"FROM (SELECT * FROM ne_products where ne_grounding=0 and ne_classify_id = ? " + 
						" and ne_price>=? and ne_price<=? " + 
						" order by ne_products.ne_price desc) A) WHERE RN BETWEEN ? AND ?";
				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, classifyId);
					pstmt.setDouble(2, priceBegin);
					pstmt.setDouble(3, priceEnd);
					pstmt.setInt(4, start);
					pstmt.setInt(5, end);
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
				String sql = "SELECT * FROM ( SELECT A.*, ROWNUM RN " +
						"FROM (SELECT * FROM ne_products where ne_grounding=0 and ne_brand_id = ?" + 
						"  and ne_price>=? and ne_price<=? " + 
						" order by ne_products.ne_price desc) A) WHERE RN BETWEEN ? AND ?";
				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, brandId);
					pstmt.setDouble(2, priceBegin);
					pstmt.setDouble(3, priceEnd);
					pstmt.setInt(4, start);
					pstmt.setInt(5, end);
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
			if(classifyId <=0 && brandId <=0){
				String sql = "SELECT * FROM ( SELECT A.*, ROWNUM RN " +
						"FROM (SELECT * FROM ne_products where ne_grounding=0 and ne_introduce like ? " + 
						" and ne_price>=? and ne_price<=? " + 
						" order by ne_products.ne_time desc) A) WHERE RN BETWEEN ? AND ?";
				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, "%"+bewrite+"%");
					pstmt.setDouble(2, priceBegin);
					pstmt.setDouble(3, priceEnd);
					pstmt.setInt(4, start);
					pstmt.setInt(5, end);
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
			}else if(classifyId >0 && brandId <=0){
				String sql = "SELECT * FROM ( SELECT A.*, ROWNUM RN " +
						"FROM (SELECT * FROM ne_products where ne_grounding=0 and ne_classify_id = ? " + 
						" and ne_price>=? and ne_price<=? " + 
						" order by ne_products.ne_time desc) A) WHERE RN BETWEEN ? AND ?";
				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, classifyId);
					pstmt.setDouble(2, priceBegin);
					pstmt.setDouble(3, priceEnd);
					pstmt.setInt(4, start);
					pstmt.setInt(5, end);
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
				String sql = "SELECT * FROM ( SELECT A.*, ROWNUM RN " +
						"FROM (SELECT * FROM ne_products where ne_grounding=0 and ne_brand_id = ?" + 
						"  and ne_price>=? and ne_price<=? " + 
						" order by ne_products.ne_time desc) A) WHERE RN BETWEEN ? AND ?";
				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, brandId);
					pstmt.setDouble(2, priceBegin);
					pstmt.setDouble(3, priceEnd);
					pstmt.setInt(4, start);
					pstmt.setInt(5, end);
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

	//获取搜索内容数量
	public int getNeProductsByCount(int classifyId ,int brandId ,
			String bewrite, double priceBegin, double priceEnd){
		if(priceEnd <= 1){
			priceBegin = 0;
			priceEnd = 1000000;
		}
		int count = 0;
		conn = this.getConnection();
		if(classifyId <=0 && brandId <=0){
			String sql = "SELECT count(*) FROM ne_products where ne_grounding=0 and " +
					" ne_introduce like ? and ne_price>= ? and ne_price<= ?";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%"+bewrite+"%");
				pstmt.setDouble(2, priceBegin);
				pstmt.setDouble(3, priceEnd);
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
		}else if(classifyId >0 && brandId <=0){
			String sql = "SELECT count(*) FROM ne_products " +
					" where ne_grounding=0 and ne_classify_id = ? " + 
					" and ne_price>=? and ne_price<=?";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, classifyId);
				pstmt.setDouble(2, priceBegin);
				pstmt.setDouble(3, priceEnd);
				rs = pstmt.executeQuery();
				if(rs.next()){
					count =  rs.getInt(1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				this.closeAll(conn, pstmt, rs);
			}
			return count;
		}else{
			String sql = "SELECT count(*) FROM ne_products " +
					"where ne_grounding=0 and ne_brand_id = ? " + 
					"and ne_price>=? and ne_price<=?";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, brandId);
				pstmt.setDouble(2, priceBegin);
				pstmt.setDouble(3, priceEnd);
				rs = pstmt.executeQuery();
				if(rs.next()){
					count =  rs.getInt(1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				this.closeAll(conn, pstmt, rs);
			}
			return count;
		}
	}
}
