package cn.client.biz.impl;

import java.util.ArrayList;
import java.util.List;

import cn.client.biz.OrderFatherBiz;
import cn.client.dao.NeOrderFatherDao;
import cn.client.dao.NeOrderSonDao;
import cn.client.dao.NeProductsDao;
import cn.client.dao.OrderFatherStatusDao;
import cn.client.dao.impl.NeOrderFatherDaoImpl;
import cn.client.dao.impl.NeOrderSonDaoImpl;
import cn.client.dao.impl.NeProductsDaoImpl;
import cn.client.dao.impl.OrderFatherStatusDaoImpl;
import cn.entity.NeOrderFather;
import cn.entity.NeOrderSon;
import cn.entity.NeProducts;
import cn.entity.OrderFather;
import cn.entity.OrderFatherStatus;
import cn.entity.OrderSon;
import cn.client.tool.Tool;

/*
 * 订单主表联表 业务逻辑层 实现
 * */
public class OrderFatherBizImpl implements OrderFatherBiz {

	//分页查询，联表（订单主表，订单子表，订单状态表，商品表）
	public List<OrderFather> getOrderFatherByPage(int pageIndex, int pageSize,
			String username) {
		NeOrderFatherDao neOrderFatherDao = new NeOrderFatherDaoImpl();
		List<NeOrderFather> neOrderFatherList = neOrderFatherDao.getNeOrderFatherByPage(pageIndex, pageSize, username);
		OrderFatherStatusDao orderFatherStatusDao = new OrderFatherStatusDaoImpl();
		List<OrderFatherStatus> orderFatherStatusList = orderFatherStatusDao.orderFatherStatusList();
		NeProductsDao neProductsDao = new NeProductsDaoImpl();
		List<NeProducts> neProductsList = neProductsDao.neProductsList();
		NeOrderSonDao neOrderSonDao = new NeOrderSonDaoImpl();
		List<NeOrderSon> neOrderSonList = null;
		List<OrderFather> orderFatherList=new ArrayList<OrderFather>();
		OrderFather orderFatherItem = null;
		Tool.totaPrice=0;
		for(int i =0; i<neOrderFatherList.size(); i++){
			String order_father_id  = neOrderFatherList.get(i).getNe_order_father_id();
			String user_id = neOrderFatherList.get(i).getNe_user_id();
			String order_time = neOrderFatherList.get(i).getNe_order_time();
			String status = null;
			double total = 5.0;
			for(int j=0; j<orderFatherStatusList.size(); j++){
				if(neOrderFatherList.get(i).getNe_status_id()==orderFatherStatusList.get(j).getOrder_father_status_id()){
					status = orderFatherStatusList.get(j).getOrder_father_status_content();
					break;
				}
			}
			List<OrderSon> orderSonList = new ArrayList<OrderSon>();
			OrderSon orderSonItem = null;
			neOrderSonList = neOrderSonDao.neOrderSonList(neOrderFatherList.get(i).getNe_order_father_id());
			for(int j=0; j<neOrderSonList.size(); j++){
				String order_father_id2 = neOrderSonList.get(j).getNe_order_father_id();
				int products_id = neOrderSonList.get(j).getNe_products_id();
				double money = neOrderSonList.get(j).getNe_money();
				int number = neOrderSonList.get(j).getNe_number();
				total+=money*number;
				String model=null;
				String introduce=null;
				String bewrite=null;
				String print=null;
				String picture=null;
				double price=0.0;
				int ne_number=0;
				String ne_grounding=null;
				for(int k=0; k<neProductsList.size();k++){
					if(neOrderSonList.get(j).getNe_products_id()==neProductsList.get(k).getNe_products_id()){
						model = neProductsList.get(k).getNe_model();
						introduce = neProductsList.get(k).getNe_introduce();
						bewrite = neProductsList.get(k).getNe_bewrite();
						print = neProductsList.get(k).getNe_print();
						picture = neProductsList.get(k).getNe_picture();
						price = neProductsList.get(k).getNe_price();
						ne_number = neProductsList.get(k).getNe_number();
						ne_grounding = neProductsList.get(k).getNe_grounding();
					}
				}
				orderSonItem = new OrderSon(
						order_father_id2, 
						products_id, 
						money, 
						number, 
						model, 
						introduce,
						bewrite, 
						print, 
						picture, 
						price, 
						ne_number, 
						ne_grounding);
				orderSonList.add(orderSonItem);
			}
			Tool.totaPrice += total;
			orderFatherItem = new OrderFather(
					order_father_id,
					user_id, 
					order_time,
					status, 
					total,
					orderSonList);
			orderFatherList.add(orderFatherItem);
		}
		return orderFatherList;
	}
}
