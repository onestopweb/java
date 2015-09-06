package cn.client.dao;

import java.util.List;

import cn.entity.ProductsImages;

/*
 * 大小图表 DAO 接口
 * */
public interface ProductsImagesDao {
	
	//根据 id 查找商品大小图的数据
	public List<ProductsImages> selectList(int id);
}
