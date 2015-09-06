package dao;

import org.hibernate.HibernateException;
import entity.Order;
/**
 * 订单数据访问层接口
 * */
public interface OrderDao {
	//根据id获取订单信息
	public Order getOrderByIds(Integer oId) throws HibernateException;
}
