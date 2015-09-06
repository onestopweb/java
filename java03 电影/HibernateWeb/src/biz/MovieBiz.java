package biz;

import java.util.List;

import org.hibernate.HibernateException;

import bean.Movie;
import bean.MovieCondition;
import bean.Type;

public interface MovieBiz {
	//获取所有
	public List<Movie> getAll() throws HibernateException;
	//添加业务
	public void addMovie(Movie movie) throws HibernateException;
	//查询操作
	public List<Movie> searchMovie(MovieCondition condition) throws HibernateException;
	//获取所有的type
	public List<Type> getAllType() throws HibernateException ;
	//根据 id 查找 Type
	public Type getTypeById(int id) throws HibernateException;
}
