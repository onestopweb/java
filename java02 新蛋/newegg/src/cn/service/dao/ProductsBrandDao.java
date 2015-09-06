package cn.service.dao;

import java.util.List;

import cn.entity.ProductsBrand;

/*
 * 商品品牌表 DAO 接口
 * */
public interface ProductsBrandDao {
	//商品品牌表列表
	public List<ProductsBrand> productsBrandList();

	//根据名称获得对应的值
	public int selectKey(String productsBrandContent);

	//根据品牌名和分类Id插入数据
	public int insert(String productsBrand,int productsClassifyId);

	//根据分类id修改分类内容
	public int update(String productsBrandContent, int productsBrandId);

	//根据分类号来获取列表
	public List<ProductsBrand> productsBrandList(int productsClassifyId);
}
