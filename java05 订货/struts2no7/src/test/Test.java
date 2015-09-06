package test;

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
/**
 * 用于添加测试的
 * */
public class Test {

	public static void main(String[] args) throws Exception {

		//initGoods();//添加商品表

		Test test=new Test();
		Integer[] ids={1,2,3};
		List<Goods> goodsList=test.getGoodsByIds(ids);
		Integer[] amounts={1,2,3};
		String name="吴者然";
		String address="新凤凰直街18号";
		saveOrder(goodsList, amounts, name, address);
		System.out.println(Tool.oId);
		System.out.println(Tool.odIds);
	}

	private static void saveOrder(List<Goods> goodsList,Integer[] amounts,String name,String address) {
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

	private static void initGoods() {
		Goods goods=new Goods(123.0, "Kingston 金士顿", "Kingston 金士顿 DataTraveler 101 G2 8GB 优盘", "金士顿制造商");
		Session session=HibernateSessionFactory.getSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			session.save(goods);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}finally{
			HibernateSessionFactory.closeSession();
		}

	}

	public List<Goods> getGoodsByIds(Integer[] ids) throws Exception {
		String hql="from Goods where id=:id";
		List<Goods> goods=new ArrayList<Goods>();
		Session session=HibernateSessionFactory.getSession();

		for (int i = 0; i < ids.length; i++) {
			Query query=session.createQuery(hql);
			query.setInteger("id", ids[i]);
			goods.add((Goods)query.uniqueResult());
		}
		HibernateSessionFactory.closeSession();
		return goods;
	}
}
