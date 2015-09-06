package cn.client.biz.impl;

import java.util.ArrayList;
import java.util.List;

import cn.client.biz.PlanOrderBiz;
import cn.client.dao.NePlanOrderDao;
import cn.client.dao.NeProductsDao;
import cn.client.dao.impl.NePlanOrderDaoImpl;
import cn.client.dao.impl.NeProductsDaoImpl;
import cn.entity.NePlanOrder;
import cn.entity.NeProducts;
import cn.entity.PlanOrder;

/*
 * 预订单表 业务逻辑层 接口
 * */
public class PlanOrderBizImpl implements PlanOrderBiz {

	//预订单表联表（预订单表，商品表）
	public List<PlanOrder> planOrderList(String username, int statusId){
		NePlanOrderDao nePlanOrderDao= new NePlanOrderDaoImpl();
		List<NePlanOrder> nePlanOrderList = nePlanOrderDao.nePlanOrderList(username, statusId);
		NeProductsDao  neProductsDao = new NeProductsDaoImpl();
		NeProducts neProductsItem = null;
		List<PlanOrder> planOrderList = new ArrayList<PlanOrder>();
		PlanOrder planOrderItem = null;
		for(int i=0; i<nePlanOrderList.size();i++){
			int products_id = nePlanOrderList.get(i).getNe_products_id();
			int number= nePlanOrderList.get(i).getNe_number();
			String user_id = nePlanOrderList.get(i).getNe_user_id();
			String time = nePlanOrderList.get(i).getNe_time();
			int status_id = nePlanOrderList.get(i).getNe_status_id();
			neProductsItem = neProductsDao.select(nePlanOrderList.get(i).getNe_products_id());
			String model = neProductsItem.getNe_model();
			String introduce = neProductsItem.getNe_introduce();
			String bewrite = neProductsItem.getNe_bewrite();
			String print = neProductsItem.getNe_print();
			String picture = neProductsItem.getNe_picture();
			double price = neProductsItem.getNe_price();
			planOrderItem = new PlanOrder(
					products_id, 
					number,
					user_id, 
					time, 
					status_id, 
					model, 
					introduce, 
					bewrite, 
					print, 
					picture, 
					price);
			planOrderList.add(planOrderItem);
		}
		return planOrderList;
	}
}
