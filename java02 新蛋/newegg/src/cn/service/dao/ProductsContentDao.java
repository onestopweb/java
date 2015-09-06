package cn.service.dao;

import java.util.List;

import cn.entity.ProductsContent;

/*
 * 内容表 DAO 接口
 * */
public interface ProductsContentDao {
	//根据 id 查找商品内容的数据
	public List<ProductsContent> selectList(int id);

	//根据id删除商品内容的数据
	public int delete(int id);

	//根据id和内容名称删除单个商品内容的数据
	public int delete(int id, String productsContent);

	//根据id插入内容图
	public int insert(int id, String productsContent);
}
