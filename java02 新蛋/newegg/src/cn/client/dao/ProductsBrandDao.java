package cn.client.dao;

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

	//根据名称和分类号获得对应的值
	public int selectKey(String productsBrandContent, int productsClassifyId);

	//根据名称获得对应的分类的值
	public int selectClassifyKey(String productsBrandContent);

	//根据分类号来获取列表
	public List<ProductsBrand> productsBrandList(int productsClassifyId);
}
