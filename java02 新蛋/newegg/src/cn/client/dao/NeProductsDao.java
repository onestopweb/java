package cn.client.dao;

import java.util.List;

import cn.entity.NeProducts;
/*
 * 商品表 DAO 接口
 * */
public interface NeProductsDao {

	//商品列表
	public List<NeProducts> neProductsList();

	//手机摄影类
	public List<NeProducts> nePhone_photographyList(); 

	//电脑平板类
	public List<NeProducts> neComputer_tabletList();

	//根据类来获取列表
	public List<NeProducts> neRankList(int classifyId);

	//推荐系列
	public List<NeProducts> neGroomList(int statusId);

	//根据状态号来获取列表
	public List<NeProducts> neListBystatusId(int statusId);

	//根据 id 查找商品的数据
	public NeProducts select(int id);

	//搜索分页
	public List<NeProducts> getNeProductsByPage(int pageIndex, 
			int pageSize, int classifyId ,int brandId ,String bewrite, double priceBegin,
			double priceEnd, int statusNum);

	//获取搜索内容数量
	public int getNeProductsByCount(int classifyId ,int brandId ,
			String bewrite, double priceBegin, double priceEnd);
	
}
