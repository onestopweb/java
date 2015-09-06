package cn.client.dao;

import java.util.List;

import cn.entity.ProductsContent;

/*
 * 内容表 DAO 接口
 * */
public interface ProductsContentDao {
	
	//根据 id 查找商品内容的数据
	public List<ProductsContent> selectList(int id);
}
