package cn.service.dao;

import java.util.List;

import cn.entity.NeProducts;

/*
 * 商品表 DAO 接口
 * */
public interface NeProductsDao {

	//商品列表
	public List<NeProducts> neProductsList();

	//商品分页
	public List<NeProducts> getNeProductsLisByPage(int pageIndex, 
			int pageSize, int classifyId ,int brandId ,String bewrite, int statusNum);

	//根据分类，品牌和描述来获取商品数量
	public int getNeProductsLisByCount(int classifyId ,int brandId ,String bewrite);

	//上架和下架
	public int updateGrounding(int id, String grounding);

	//修改价格
	public int updatePrice(int id, double price);

	//修改数量
	public int updateNumber(int id, int number);

	//根据 id 查找商品的数据
	public NeProducts select(int id);

	//根据id修改内容
	public int updateById(int id, String model,String introduce,String bewrite,
			double price, int number, int statusId);

	//根据 id 修改内容
	public int updateById(int id, int classifyId,int brandId,
			String model,String introduce,String bewrite,
			double price, int number, int statusId,int grounding);

	//判断些id是否存在
	public int selectId(int id);
	
	//根据id 更新小图和中图
	public int update(int id,String print, String picture);
	
	//插入一条商品数据
	public int insert( int classifyId,int brandId,
			String model,String introduce,String bewrite,
			double price, int number, int statusId,int grounding);

}
