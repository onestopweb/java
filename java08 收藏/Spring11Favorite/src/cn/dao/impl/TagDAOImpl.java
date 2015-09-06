package cn.dao.impl;
import java.util.List;
import cn.dao.TagDAO;
import cn.entity.Tag;
public class TagDAOImpl extends BaseDaoImpl<Tag> implements TagDAO {
	@Override
	public Tag get(String tagName) {
		@SuppressWarnings("unchecked")
		List<Tag> rets = super.getHibernateTemplate().find("from Tag t where t.name = ?",tagName);
		if(rets.size() != 0){
			return rets.get(0);
		}
		return null;
	}
	@Override
	public List<Tag> search(Tag condition) {
		if(condition==null){
			return super.find("from Tag t order by t.name asc");
		}else{
			return super.find(condition);
		}
	}
}
