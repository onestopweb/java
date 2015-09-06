package dao;

import java.util.List;

import org.hibernate.HibernateException;

import bean.Movie;
import bean.MovieCondition;

public interface MovieDao {
	
	//查找全部
	public List<Movie>  getAll() throws HibernateException;
	//根据条件动态查找
	public List<Movie>  searchByCondition(MovieCondition  condition) throws HibernateException;
	//添加
	public void save(Movie movie) throws HibernateException;
	//根据条件动态查找,因为有价格的范围
	public List<Movie> search(String actor,String director,String titile,double priceBegin,double priceEnd,int typeid) throws HibernateException;
}
