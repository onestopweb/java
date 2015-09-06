package dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import tool.Tool;
import util.HibernateSessionFactory;
import entity.Goods;
import entity.Order;
import entity.OrderDetail;
import dao.GoodsDao;
/**
 * 商品数据访问层实现
 * */
public class GoodsDaoImpl implements GoodsDao {
	//获取所有商品的信息
	@SuppressWarnings("unchecked")
	public List<Goods> getAll() throws HibernateException {
		String hql="from Goods";
		List<Goods> goods=null;
		Session session=HibernateSessionFactory.getSession();
		Query query=session.createQuery(hql);
		goods=query.list();
		HibernateSessionFactory.closeSession();
		return goods;
	}
	//根据多个id获取商品信息
	public List<Goods> getGoodsByIds(Integer[] ids) throws HibernateException {
		String hql="from Goods where id=:id";
		List<Goods> goods=new ArrayList<Goods>();
		Session session=HibernateSessionFactory.getSession();

		for (int i=0; i<ids.length; i++) {
			Query query=session.createQuery(hql);
			query.setInteger("id", ids[i]);
			goods.add((Goods)query.uniqueResult());
		}
		HibernateSessionFactory.closeSession();
		return goods;
	}
	//保存订单
	public void saveOrder(List<Goods> goodsList,Integer[] amounts,String name,String address){
		Session session=HibernateSessionFactory.getSession();
		Order order=new Order(name,address,new Date());
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			Tool.oId = (Integer) session.save(order);
			for(int i=0; i<amounts.length; i++){
				OrderDetail detail = new OrderDetail(amounts[i], goodsList.get(i), order);
				Integer odId =(Integer) session.save(detail);
				Tool.odIds.add(odId);
			}
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}finally{
			HibernateSessionFactory.closeSession();
		}
	}
}
