package cn.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import cn.dao.BookDao;
import cn.entity.Book;
import cn.util.HibernateSessionFactory;

/**
 * Book 数据访问层实现
 * */
public class BookDaoImpl implements BookDao {

	/**
	 * 查询共有多少记录
	 * 
	 * @return
	 */
	public long findTotal(){
		Session session=HibernateSessionFactory.getSession(); 
		Long count = (Long)session.createQuery("select count(*) from Book").uniqueResult();
		return count;
	}

	/**
	 * 查询一页的数据
	 * 
	 * @param begin 从哪条开始 0
	 * @param end 得到多少条
	 * @param sort 排序的列
	 * @param order 排序的方式 desc/asc
	 * @return
	 */
	public List<Book> findPageBooks(final int begin, final int end, final String sort, final String order){
		Session session=HibernateSessionFactory.getSession(); 
		Criteria criteria = session.createCriteria(Book.class);
		if("desc".equals(order)){
			criteria.addOrder(Order.desc(sort));
		}else{
			criteria.addOrder(Order.asc(sort));
		}
		criteria.setFirstResult(begin).setMaxResults(end);
		List<Book> books = criteria.list();
		HibernateSessionFactory.closeSession(); 
		return books;
	}

	/**
	 * 增加一条数据
	 * 
	 * @param book 传来的参数不包括 id
	 * @return
	 */
	public int addBook(Book book){
		Session session=HibernateSessionFactory.getSession(); 
		Transaction tx=null; 
		int id = 0;
		try {
			tx=session.beginTransaction();
			id = (Integer)session.save(book);
			tx.commit(); 
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();  
		}finally{
			HibernateSessionFactory.closeSession();  
		}
		return id;
	}

	/**
	 * 删除一条数据
	 * 
	 * @param id 根据 id 作删除
	 * @return
	 */
	public int deleteBook(int id){
		Session session=HibernateSessionFactory.getSession(); 
		Transaction tx = null;
		int num = 0;
		try {
			tx=session.beginTransaction();
			Book book = new Book();  
			book.setId(id); 
			session.delete(book); 
			tx.commit();
			num = 1;
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}finally{
			HibernateSessionFactory.closeSession();  
		}
		return num;
	}

	/**
	 * 修改一条数据
	 * 
	 * @param book 传来的参数包括 id
	 * @return
	 */
	public int updateBook(Book book){
		Session session=HibernateSessionFactory.getSession(); 
		Transaction tx = null;
		int id = 0;
		try {
			tx=session.beginTransaction();
			session.update(book);
			tx.commit();
			id = 1;
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}finally{
			HibernateSessionFactory.closeSession();  
		}
		return id;
	}

}
