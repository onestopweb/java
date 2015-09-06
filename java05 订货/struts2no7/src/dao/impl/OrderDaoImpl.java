package dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateSessionFactory;
import dao.OrderDao;
import entity.Order;
/**
 * 订单数据访问层实现
 * */
public class OrderDaoImpl implements OrderDao {

	public Order getOrderByIds(Integer oId) throws HibernateException {
		String hql="from Order where id =:oId";
		Order order=null;
		Session session=HibernateSessionFactory.getSession();
		Query query=session.createQuery(hql);
		query.setInteger("oId", oId);
		order = (Order) query.uniqueResult();
		HibernateSessionFactory.closeSession();
		return order;
	}

}
