package biz;

import java.util.List;
import org.hibernate.HibernateException;
import entity.Goods;
import entity.Order;
import entity.OrderDetail;
/**
 * 商品业务逻辑层接口
 * */
public interface GoodsBiz {
	//获取所有商品的信息
	public List<Goods> getAll() throws HibernateException;
	//根据多个id获取商品信息
	public List<Goods> getGoodsByIds(Integer[] ids) throws HibernateException;
	//保存订单
	public void saveOrder(Integer[] ids,Integer[] amounts,String name,String address);
	//根据id获取订单信息
	public Order getOrderByIds(Integer oId) throws HibernateException;
	//根据多个id获取OrderDetail信息
	public List<OrderDetail> getOrderDetailByOdIds(List<Integer> odIds) throws HibernateException;
}
