package cn.service.biz.impl;

import java.util.ArrayList;
import java.util.List;

import cn.entity.NeProducts;
import cn.entity.Products;
import cn.entity.ProductsBrand;
import cn.entity.ProductsClassify;
import cn.entity.ProductsStatus;
import cn.service.biz.ProductsBiz;
import cn.service.dao.NeProductsDao;
import cn.service.dao.ProductsBrandDao;
import cn.service.dao.ProductsClassifyDao;
import cn.service.dao.ProductsStatusDao;
import cn.service.dao.impl.NeProductsDaoImpl;
import cn.service.dao.impl.ProductsBrandDaoImpl;
import cn.service.dao.impl.ProductsClassifyDaoImpl;
import cn.service.dao.impl.ProductsStatusDaoImpl;

/*
 * 商品联表 业务逻辑层 实现
 * */
public class ProductsBizImpl implements ProductsBiz {

	//商品分页（商品表，商品品牌表，商品类型类，商品状态表）
	public List<Products> getProductsByPage(int pageIndex, int pageSize,
			int classifyId, int brandId, String bewrite2, int statusNum) {
		NeProductsDao  neProductsDao = new NeProductsDaoImpl();
		List<NeProducts> neProductslist = neProductsDao.getNeProductsLisByPage(
				pageIndex, 
				pageSize,
				classifyId, 
				brandId, 
				bewrite2, 
				statusNum);

		ProductsClassifyDao productsClassifyDao = new ProductsClassifyDaoImpl();
		List<ProductsClassify> productsClassifyList = productsClassifyDao.productsClassifyList();

		ProductsBrandDao  productsBrandDao = new ProductsBrandDaoImpl();
		List<ProductsBrand> productsBrandList = productsBrandDao.productsBrandList();

		ProductsStatusDao productsStatusDao = new ProductsStatusDaoImpl();
		List<ProductsStatus> productsStatusList = productsStatusDao.productsStatusList();

		List<Products> productsList = new ArrayList<Products>();
		Products item = null;


		for(int i=0; i<neProductslist.size();i++){
			int products_id =neProductslist.get(i).getNe_products_id();
			String classify = null;
			for(int j=0; j<productsClassifyList.size(); j++){
				if(neProductslist.get(i).getNe_classify_id()==productsClassifyList.get(j).getProducts_classify_id()){
					classify = productsClassifyList.get(j).getProducts_classify_content();
					break;
				}
			}
			String brand = null;
			for(int j=0; j<productsBrandList.size();j++){
				if(neProductslist.get(i).getNe_brand_id()==productsBrandList.get(j).getProducts_brand_id()){
					brand = productsBrandList.get(j).getProducts_brand_content();
					break;
				}
			}
			String model = neProductslist.get(i).getNe_model();
			String introduce = neProductslist.get(i).getNe_introduce();
			String bewrite = neProductslist.get(i).getNe_bewrite();
			String print = neProductslist.get(i).getNe_print();
			String picture = neProductslist.get(i).getNe_picture();
			double price = neProductslist.get(i).getNe_price();
			int number = neProductslist.get(i).getNe_number();
			String time = neProductslist.get(i).getNe_time();
			String status_content = null;
			String status_img = null;
			for(int j=0; j<productsStatusList.size(); j++){
				if(neProductslist.get(i).getNe_status_id()==productsStatusList.get(j).getProducts_status_id()){
					status_content = productsStatusList.get(j).getProducts_status_content();
					status_img = productsStatusList.get(j).getProducts_status_img();
					break;
				}
			}
			int status_id = neProductslist.get(i).getNe_status_id();
			String grounding = neProductslist.get(i).getNe_grounding();
			item = new Products(
					products_id,
					classify, 
					brand, 
					model, 
					introduce, 
					bewrite, 
					print, 
					picture, 
					price, 
					number, 
					time, 
					status_content, 
					status_img, 
					status_id, 
					grounding);
			productsList.add(item);
		}
		return productsList;
	}

	//根据 id 查找商品的数据（商品表，商品品牌表，商品类型类，商品状态表）
	public  Products select(int id){
		NeProductsDao  neProductsDao = new NeProductsDaoImpl();
		NeProducts neProductslist = neProductsDao.select(id);

		ProductsClassifyDao productsClassifyDao = new ProductsClassifyDaoImpl();
		List<ProductsClassify> productsClassifyList = productsClassifyDao.productsClassifyList();

		ProductsBrandDao  productsBrandDao = new ProductsBrandDaoImpl();
		List<ProductsBrand> productsBrandList = productsBrandDao.productsBrandList();

		ProductsStatusDao productsStatusDao = new ProductsStatusDaoImpl();
		List<ProductsStatus> productsStatusList = productsStatusDao.productsStatusList();

		int products_id = neProductslist.getNe_products_id();
		int classifyId = neProductslist.getNe_classify_id();
		String classify = null;
		for(int j=0; j<productsClassifyList.size(); j++){
			if(neProductslist.getNe_classify_id()==productsClassifyList.get(j).getProducts_classify_id()){
				classify = productsClassifyList.get(j).getProducts_classify_content();
				break;
			}
		}
		int brandId = neProductslist.getNe_brand_id();
		String brand = null;
		for(int j=0; j<productsBrandList.size();j++){
			if(neProductslist.getNe_brand_id()==productsBrandList.get(j).getProducts_brand_id()){
				brand = productsBrandList.get(j).getProducts_brand_content();
				break;
			}
		}
		String model = neProductslist.getNe_model();
		String introduce = neProductslist.getNe_introduce();
		String bewrite = neProductslist.getNe_bewrite();
		String print = neProductslist.getNe_print();
		String picture = neProductslist.getNe_picture();
		double price = neProductslist.getNe_price();
		int number = neProductslist.getNe_number();
		String time = neProductslist.getNe_time();
		String status_content = null;
		String status_img = null;
		for(int j=0; j<productsStatusList.size(); j++){
			if(neProductslist.getNe_status_id()==productsStatusList.get(j).getProducts_status_id()){
				status_content = productsStatusList.get(j).getProducts_status_content();
				status_img = productsStatusList.get(j).getProducts_status_img();
				break;
			}
		}
		int status_id =  neProductslist.getNe_status_id();
		String grounding = neProductslist.getNe_grounding();
		Products item = new Products(
				products_id,
				classifyId, 
				classify, 
				brandId, 
				brand, 
				model, 
				introduce, 
				bewrite, 
				print, 
				picture, 
				price, 
				number, 
				time, 
				status_content, 
				status_img, 
				status_id, 
				grounding
				);
		return item;
	}

}
