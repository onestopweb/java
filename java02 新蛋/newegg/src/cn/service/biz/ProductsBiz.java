package cn.service.biz;

import java.util.List;

import cn.entity.Products;

/*
 * 商品联表 业务逻辑层 接口
 * */
public interface ProductsBiz {

	//商品分页（商品表，商品品牌表，商品类型类，商品状态表）
	public List<Products> getProductsByPage(int pageIndex, 
			int pageSize, int classifyId ,int brandId ,String bewrite, int statusNum);

	//根据 id 查找商品的数据（商品表，商品品牌表，商品类型类，商品状态表）
	public  Products select(int id);
}
