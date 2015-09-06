package cn.dao.impl;
import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import cn.dao.AnswersDao;
import cn.entity.Answers;
public class AnswersDaoImpl extends HibernateDaoSupport implements AnswersDao {
	@Override
	public void insert(Answers answers) {
		super.getHibernateTemplate().save(answers);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Answers> findAnswersList(Integer qid) {
		return  (List<Answers>) super.getHibernateTemplate().find("from Answers a where a.duestions.id ="+qid);
	}
}
