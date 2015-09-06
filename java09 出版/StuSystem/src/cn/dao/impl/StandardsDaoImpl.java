package cn.dao.impl;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import cn.dao.StandardsDao;
import cn.entity.Standards;
public class StandardsDaoImpl extends HibernateDaoSupport implements
StandardsDao {
	@SuppressWarnings("unchecked")
	@Override
	public List<Standards> findAll() {
		return super.getHibernateTemplate().find("from Standards");
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Standards> findByPage(int begin, int end) {
		DetachedCriteria criteria=DetachedCriteria.forClass(Standards.class);
		return super.getHibernateTemplate().findByCriteria(criteria, begin, end);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Standards> findByPageOfsearch(int begin, int end, String stdNum) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Standards.class);
		criteria.add(Restrictions.like("stdNum", "%"+stdNum+"%"));
		return super.getHibernateTemplate().findByCriteria(criteria, begin, end);
	}
	@Override
	public Standards findById(Integer stdId) {
		return (Standards) super.getHibernateTemplate().get(Standards.class, stdId);
	}
	@Override
	public void update(Standards standards) {
		super.getHibernateTemplate().update(standards); 
	}
	@Override
	public void insert(Standards standards) {
		super.getHibernateTemplate().save(standards);
	}
	@Override
	public void deleteByIds(Integer[] stdIds) {
		for (int i = 0; i < stdIds.length; i++) {
			Standards standard = (Standards) super.getHibernateTemplate().get(Standards.class, stdIds[i]);
			if (standard != null) {
				super.getHibernateTemplate().delete(standard);
			}
		}
	}
}
