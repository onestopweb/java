package biz.impl;

import java.util.List;
import org.hibernate.HibernateException;
import entity.Goods;
import entity.Order;
import entity.OrderDetail;
import biz.GoodsBiz;
import dao.GoodsDao;
import dao.OrderDao;
import dao.OrderDetailDao;
import dao.impl.GoodsDaoImpl;
import dao.impl.OrderDaoImpl;
import dao.impl.OrderDetailDaoImpl;
/**
 * 商品业务逻辑层实现
 * */
public class GoodsBizImpl implements GoodsBiz
{
	private GoodsDao goodsDao=new GoodsDaoImpl();
	private OrderDao orderDao =  new OrderDaoImpl();
	private OrderDetailDao orderDetailDao = new OrderDetailDaoImpl();
	//获取所有商品的信息
	public List<Goods> getAll() throws HibernateException {
		return goodsDao.getAll();
	}
	//根据多个id获取商品信息
	public List<Goods> getGoodsByIds(Integer[] ids) throws HibernateException {
		return goodsDao.getGoodsByIds(ids);
	}
	//保存订单
	public void saveOrder(Integer[] ids,Integer[] amounts,String name,String address){
		List<Goods> goodsList = goodsDao.getGoodsByIds(ids);
		goodsDao.saveOrder(goodsList, amounts, name, address);
	}
	//根据id获取订单信息
	public Order getOrderByIds(Integer oId) throws HibernateException{
		return orderDao.getOrderByIds(oId);
	}
	//根据多个id获取OrderDetail信息
	public List<OrderDetail> getOrderDetailByOdIds(List<Integer> odIds) throws HibernateException{
		return orderDetailDao.getOrderDetailByOdIds(odIds);
	}
}
