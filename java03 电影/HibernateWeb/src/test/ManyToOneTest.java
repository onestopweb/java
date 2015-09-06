package test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateSessionFactory;

import bean.Movie;
import bean.Type;

public class ManyToOneTest {
	public static void main(String[] args) {
		manyToOne();
	}

	private static void manyToOne() {	
		Movie movie1 = new Movie("电影名称111","导演111" , "主演111", 111.00);
		Movie movie2 = new Movie("电影名称222","导演222" , "主演222", 55.00);
		Movie movie3 = new Movie("电影名称333","导演333" , "主演333", 222.00);
		Movie movie4 = new Movie("电影名称444","导演444" , "主演444", 55.00);
		Movie movie5 = new Movie("电影名称555","导演555" , "主演555", 55.00);
		Type type1 = new Type("3D片");
		Type type2 = new Type("动作片");
		Type type3 = new Type("爱情片");
		Type type4 = new Type("喜剧片");
		Type type5 = new Type("其他");
		movie1.setType(type1);
		movie2.setType(type3);
		movie3.setType(type4);
		movie4.setType(type4);
		movie5.setType(type2);
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(movie1);
			session.save(movie2);
			session.save(movie3);
			session.save(movie4);
			session.save(movie5);
			session.save(type1);
			session.save(type2);
			session.save(type3);
			session.save(type4);
			session.save(type5);
			tx.commit();
			System.out.println("成功");
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}finally{
			HibernateSessionFactory.closeSession();
		}
	}

}
