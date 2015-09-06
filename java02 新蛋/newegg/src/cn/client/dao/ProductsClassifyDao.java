package cn.client.dao;

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
	
	//根据值找到name
	public String selectName(int productsClassifyId);
}
