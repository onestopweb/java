package cn.client.biz.impl;

import java.util.ArrayList;
import java.util.List;

import cn.client.biz.ProductsBiz;
import cn.client.dao.NeProductsDao;
import cn.client.dao.ProductsBrandDao;
import cn.client.dao.ProductsClassifyDao;
import cn.client.dao.ProductsStatusDao;
import cn.client.dao.impl.NeProductsDaoImpl;
import cn.client.dao.impl.ProductsBrandDaoImpl;
import cn.client.dao.impl.ProductsClassifyDaoImpl;
import cn.client.dao.impl.ProductsStatusDaoImpl;
import cn.entity.NeProducts;
import cn.entity.Products;
import cn.entity.ProductsBrand;
import cn.entity.ProductsClassify;
import cn.entity.ProductsStatus;
/*
 * 商品联表 业务逻辑层 实现
 * */
public class ProductsBizImpl implements ProductsBiz {

	//手机摄影类,联表（商品表，商品品牌表，商品类型类，商品状态表）
	public List<Products> phone_photographyList() {
		NeProductsDao  neProductsDao = new NeProductsDaoImpl();
		List<NeProducts> neProductslist = neProductsDao.nePhone_photographyList();

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

	//电脑平板类,联表（商品表，商品品牌表，商品类型类，商品状态表）
	public List<Products> computer_tabletList() {
		NeProductsDao  neProductsDao = new NeProductsDaoImpl();
		List<NeProducts> neProductslist = neProductsDao.neComputer_tabletList();

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

	//排行榜,联表（商品表，商品品牌表，商品类型类，商品状态表）根据类别
	public List<Products> rankList(int classifyId){
		NeProductsDao  neProductsDao = new NeProductsDaoImpl();
		List<NeProducts> neProductslist = neProductsDao.neRankList(classifyId);

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

	//推荐系列联表（商品表，商品品牌表，商品类型类，商品状态表）根据状态号
	public List<Products> groomList(int statusId){
		NeProductsDao  neProductsDao = new NeProductsDaoImpl();
		List<NeProducts> neProductslist = neProductsDao.neGroomList(statusId);

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

	//根据状态号来获取列表（商品表，商品品牌表，商品类型类，商品状态表
	public List<Products> listBystatusId(int statusId){
		NeProductsDao  neProductsDao = new NeProductsDaoImpl();
		List<NeProducts> neProductslist = neProductsDao.neListBystatusId(statusId);

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
		String classify = null;
		for(int j=0; j<productsClassifyList.size(); j++){
			if(neProductslist.getNe_classify_id()==productsClassifyList.get(j).getProducts_classify_id()){
				classify = productsClassifyList.get(j).getProducts_classify_content();
				break;
			}
		}
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
		return item;
	}

	//搜索分页（商品表，商品品牌表，商品类型类，商品状态表）
	public List<Products> getProductsByPage(int pageIndex, 
			int pageSize, int classifyId ,int brandId ,String bewrite2, double priceBegin,
			double priceEnd, int statusNum){
		NeProductsDao  neProductsDao = new NeProductsDaoImpl();
		List<NeProducts> neProductslist = neProductsDao.getNeProductsByPage(pageIndex, 
				pageSize, 
				classifyId, 
				brandId, 
				bewrite2, 
				priceBegin, 
				priceEnd, 
				statusNum
				);

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
}
