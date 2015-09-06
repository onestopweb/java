package cn.dao.impl;
import java.io.Serializable;
import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import cn.dao.BaseDao;
/**
 * BaseDao 实现类
 */
public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {
	@Override
	public T add(T entity) {
		super.getHibernateTemplate().save(entity);
		return entity;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<T> find(T condition) {
		return super.getHibernateTemplate().findByExample(condition);
	}
	@Override
	public void update(T entity) {
		super.getHibernateTemplate().update(entity);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<T> find(String hql) {
		return super.getHibernateTemplate().find(hql);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<T> find(String hql, String[] paramNames, Object[] values) {
		return super.getHibernateTemplate().findByNamedParam(hql, paramNames, values);
	}
	@Override
	public T get(Class<T> entityClass, Serializable id) {
		return super.getHibernateTemplate().get(entityClass, id);
	}
	@Override
	public void deleteById(Class<T> entityClass, Serializable id) {
		super.getHibernateTemplate().delete(this.get(entityClass, id));

	}
	@Override
	public List<T> findAll(Class<T> entityClass) {
		return super.getHibernateTemplate().loadAll(entityClass);
	}
}
