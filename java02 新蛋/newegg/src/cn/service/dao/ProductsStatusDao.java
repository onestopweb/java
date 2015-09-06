package cn.service.dao;

import java.util.List;

import cn.entity.ProductsStatus;

/*
 * 商品状态表 DAO 接口
 * */
public interface ProductsStatusDao {
	//商品状态表列表
	public List<ProductsStatus> productsStatusList();
}
