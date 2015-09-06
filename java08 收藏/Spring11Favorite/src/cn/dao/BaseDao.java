package cn.dao;
import java.io.Serializable;
import java.util.List;
/**
 * BaseDao接口，包含常用的方法 
 */
public interface BaseDao<T> {
	/**
	 * 查询所有的记录
	 */
	List<T> findAll(Class<T> entityClass);
	/**
	 * 根据主键加载一条数据。
	 * @param id 主键
	 * @return 查找到的数据
	 */
	T get(Class<T> entityClass,Serializable id);
	/**
	 * 添加数据到数据库。
	 * @param entity 将要添加的数据
	 * @return 包含了主键信息的数据
	 */
	T add(T entity);
	/**
	 * 根据主键删除数据。
	 * @param id
	 */
	void deleteById(Class<T> entityClass,Serializable id);
	/**
	 * 更新数据。
	 * @param entity 将要更新的数据，包含主键信息
	 */
	void update(T entity);
	/**
	 * 查找数据。
	 * @param condition 查询条件
	 * @return 查询结果
	 */
	List<T> find(T condition);
	/**
	 * 查找数据。
	 * @param hql 查询语句
	 * @return 查询结果
	 */
	List<T> find(String hql);
	/**
	 * 查找数据。
	 * @param hql 查询语句 paramNames 参数名 values参数值
	 * @return 查询结果
	 */
	List<T> find(String hql, String[] paramNames, Object[] values);
}