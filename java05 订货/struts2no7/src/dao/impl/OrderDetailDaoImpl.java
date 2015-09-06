package dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateSessionFactory;
import dao.OrderDetailDao;
import entity.OrderDetail;
/**
 * 订单明细数据访问层实现
 * */
public class OrderDetailDaoImpl implements OrderDetailDao {

	public List<OrderDetail> getOrderDetailByOdIds(List<Integer> odIds)
			throws HibernateException {
		String hql="from OrderDetail where id=:odId";
		List<OrderDetail> orderDetails=new ArrayList<OrderDetail>();
		Session session=HibernateSessionFactory.getSession();
		for (int i=0; i<odIds.size(); i++) {
			Query query=session.createQuery(hql);
			query.setInteger("odId", odIds.get(i));
			orderDetails.add((OrderDetail)query.uniqueResult());
		}
		HibernateSessionFactory.closeSession();
		return orderDetails;
	}
}
