package cn.dao.impl;
import java.util.List;
import cn.dao.FavDAO;
import cn.entity.Favorite;
public class FavDAOImpl extends BaseDaoImpl<Favorite> implements FavDAO {
	@Override
	public List<Favorite> search(String type) {
		String hql = "from Favorite f where 1=1";
		if("-1".equals(type)){
			//-1 指全部，什么也不处理
		}else if("0".equals(type)){//0 表示未分类
			hql +="and f.tags is null or f.tags=''";
		}else if(type != null&&!"".equals(type)){
			hql+="and f.tags like '%"+type+"%'";
		}
		return super.find(hql);
	}
}
