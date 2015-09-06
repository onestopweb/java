package dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import util.HibernateSessionFactory;

import bean.Movie;
import bean.MovieCondition;
import dao.MovieDao;

public class MovieDaoImpl implements MovieDao {
	// 查找全部
	public List<Movie> getAll() throws HibernateException {
		Session session = HibernateSessionFactory.getSession();
		Criteria criteria = session.createCriteria(Movie.class);
		List<Movie> movies = criteria.list();
		return movies;
	}
	// 添加
	public void save(Movie movie) throws HibernateException {

		Session session = HibernateSessionFactory.getSession();
		Transaction tx = null;
		tx = session.beginTransaction();
		session.save(movie);
		tx.commit();
		HibernateSessionFactory.closeSession();

	}
	// 根据条件动态查找
	public List<Movie> searchByCondition(MovieCondition condition)
			throws HibernateException {
		StringBuffer hql = new StringBuffer("from Movie where 1=1");
		if (null != condition.getTitile()) {
			hql.append(" AND titile like :titile");
		}
		if (null != condition.getActor()) {
			hql.append(" AND actor like :actor");
		}
		if (null != condition.getDirector()) {
			hql.append(" AND director like :director");
		}
		if (null != condition.getType()) {
			hql.append(" AND type=:type");
		}
		if (null != condition.getMinPrice()) {
			hql.append(" AND price>=:minPrice");
		}
		if (null != condition.getMinPrice()) {
			hql.append(" AND price<=:maxPrice");
		}
		// 根据条件动态拼接hql
		Session session = HibernateSessionFactory.getSession();
		Query query = session.createQuery(hql.toString());
		// 整个参数放入
		query.setProperties(condition);
		List<Movie> movies = query.list();
		return movies;
	}
	// 根据条件动态查找,因为有价格的范围
	public List<Movie> search(String actor, String director, String titile,
			double priceBegin, double priceEnd, int typeid)
			throws HibernateException {
		DetachedCriteria dc = DetachedCriteria.forClass(Movie.class);
		if (actor != null) {
			dc.add(Restrictions.eq("actor", actor));
		}
		if (director != null) {
			dc.add(Restrictions.eq("director", director));
		}
		if (titile != null) {
			dc.add(Restrictions.eq("titile", titile));
		}
		Criteria critera = dc.getExecutableCriteria(HibernateSessionFactory
				.getSession());
		List<Movie> movies = critera.list();
		return movies;
	}
}
