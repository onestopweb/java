package cn.client.biz;

import java.util.List;

import cn.entity.Products;

/*
 * 商品联表 业务逻辑层 接口
 * */
public interface ProductsBiz {
	//手机摄影类,联表（商品表，商品品牌表，商品类型类，商品状态表）
	public List<Products> phone_photographyList();

	//电脑平板类,联表（商品表，商品品牌表，商品类型类，商品状态表）
	public List<Products> computer_tabletList();

	//排行榜,联表（商品表，商品品牌表，商品类型类，商品状态表）根据类别
	public List<Products> rankList(int classifyId);

	//推荐系列联表（商品表，商品品牌表，商品类型类，商品状态表）根据状态号
	public List<Products> groomList(int statusId);

	//根据状态号来获取列表（商品表，商品品牌表，商品类型类，商品状态表
	public List<Products> listBystatusId(int statusId);

	//根据 id 查找商品的数据（商品表，商品品牌表，商品类型类，商品状态表）
	public  Products select(int id);

	//搜索分页（商品表，商品品牌表，商品类型类，商品状态表）
	public List<Products> getProductsByPage(int pageIndex, 
			int pageSize, int classifyId ,int brandId ,String bewrite2, double priceBegin,
			double priceEnd, int statusNum);
}
