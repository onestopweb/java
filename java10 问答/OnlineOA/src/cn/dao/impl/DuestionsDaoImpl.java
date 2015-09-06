package cn.dao.impl;
import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import cn.dao.DuestionsDao;
import cn.entity.Duestions;
public class DuestionsDaoImpl extends HibernateDaoSupport implements
		DuestionsDao {
	@SuppressWarnings("unchecked")
	@Override
	public List<Duestions> findAll() {
		return super.getHibernateTemplate().find("from Duestions");
	}
	@Override
	public Duestions findById(Integer id) {
		return (Duestions) super.getHibernateTemplate().get(Duestions.class,id);
	}
	@Override
	public void add(Duestions duestions) {
		super.getHibernateTemplate().save(duestions);
	}
	@Override
	public void update(Duestions duestions) {
		super.getHibernateTemplate().update(duestions); 
	}
}
