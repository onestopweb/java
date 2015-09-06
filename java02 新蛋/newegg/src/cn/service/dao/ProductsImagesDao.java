package cn.service.dao;

import java.util.List;

import cn.entity.ProductsImages;

/*
 * 大小图表 DAO 接口
 * */
public interface ProductsImagesDao {
	
	//根据 id 查找商品大小图的数据
	public List<ProductsImages> selectList(int id);
	
	//根据id删除商品大小图的数据
	public int delete(int id);
	
	//根据id和小图名称删除单个商品大小图的数据
	public int delete(int id, String productsSmallmap);
	
	//根据id插入大小图
	public int insert(int id, String productsSmallmap, String productsLarge);
}
