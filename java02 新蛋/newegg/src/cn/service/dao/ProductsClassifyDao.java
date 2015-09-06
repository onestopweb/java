package cn.service.dao;

import java.util.List;

import cn.entity.ProductsClassify;

/*
 * 商品类型表 DAO 接口
 * */
public interface ProductsClassifyDao {
	//商品类型表列表
	public List<ProductsClassify> productsClassifyList();

	//根据名称获得对应的值
	public int selectKey(String productsClassifyContent);

	//根据类型插入数据
	public int insert(String productsClassify);
	
	//根据分类id修改分类内容
	public int update(String productsClassifyContent, int productsClassifyId);
	
}
