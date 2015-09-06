package biz.impl;

import java.util.List;

import org.hibernate.HibernateException;

import bean.Movie;
import bean.MovieCondition;
import bean.Type;
import biz.MovieBiz;
import dao.MovieDao;
import dao.TypeDao;
import dao.impl.MovieDaoImpl;
import dao.impl.TypeDaoImpl;

public class MovieBizImpl implements MovieBiz {
	private MovieDao movieDao = new MovieDaoImpl();
	private TypeDao typeDao = new TypeDaoImpl();
	// 获取所有
	public List<Movie> getAll() throws HibernateException {
		return movieDao.getAll();
	}
	// 添加业务
	public void addMovie(Movie movie) throws HibernateException {
		movieDao.save(movie);
	}
	// 查询操作
	public List<Movie> searchMovie(MovieCondition condition)
			throws HibernateException {
		return movieDao.searchByCondition(condition);
	}
	// 获取所有的type
	public List<Type> getAllType() throws HibernateException {
		return typeDao.getAll();
	}
	// 根据 id 查找 Type
	public Type getTypeById(int id) throws HibernateException {
		return typeDao.getTypeById(id);
	}
}
