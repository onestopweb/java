package cn.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import cn.entity.Book;
import cn.util.HibernateSessionFactory;

public class Test {
	public static void main(String[] args) {
		Test test = new Test();
		
//		save();
		
//		System.out.println(test.findTotal());

//		List<Book> books = new ArrayList<Book>();
//		books = test.findPageBooks(1, 2, "title", "asc");
//		for (Book book : books) {
//			System.out.println(book.getId()+" "+book.getTitle()+"  "+book.getPubdate());
//		}

//		Book book = new Book("345345-232-132", "Java编程思想2", 99.00, new Date(), "一本全面介绍Java的书籍，适合任何层次的读者");
//		int id = test.addBook(book);
//		System.out.println("这是添加的结果"+id);

//		System.out.println("这是删除的结果"+test.deleteBook(108));
		
//		Book book = new Book(104,"345345-232-132", "Java编程思想2", 99.00, new Date(), "一本全面介绍Java的书籍，适合任何层次的读者");
//		int id = test.updateBook(book);
//		System.out.println("这是修改的结果"+id);


	}
	private static void save() {
		Book book = new Book("345345-232-132", "Java编程思想", 99.00, new Date(), "一本全面介绍Java的书籍，适合任何层次的读者");
		Session session=HibernateSessionFactory.getSession(); 
		Transaction tx=null; 
		try {
			tx=session.beginTransaction();
			session.save(book);
			tx.commit(); 
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();  
		}finally{
			HibernateSessionFactory.closeSession();  
		}
	}
	public long findTotal(){
		Session session=HibernateSessionFactory.getSession(); 
		Long count = (Long)session.createQuery("select count(*) from Book").uniqueResult();
		return count;
	}
	public List<Book> findPageBooks(final int pageIndex, final int pageSize, final String sort, final String order){
		Session session=HibernateSessionFactory.getSession(); 
		Criteria criteria = session.createCriteria(Book.class);
		if("desc".equals(order)){
			criteria.addOrder(Order.desc(sort));
		}else{
			criteria.addOrder(Order.asc(sort));
		}
		criteria.setFirstResult(pageIndex).setMaxResults(pageSize);
		List<Book> books = criteria.list();
		HibernateSessionFactory.closeSession(); 
		return books;
	}
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
