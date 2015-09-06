package cn.biz.impl;
import java.util.List;
import cn.biz.FavBiz;
import cn.biz.TagBiz;
import cn.dao.FavDAO;
import cn.entity.Favorite;
public class FavBizImpl implements FavBiz {
	private FavDAO favDAO;
	public void setFavDAO(FavDAO favDAO) {
		this.favDAO = favDAO;
	}
	private TagBiz tagBiz;
	public void setTagBiz(TagBiz tagBiz) {
		this.tagBiz = tagBiz;
	}
	@Override
	public void add(Favorite fav) {
		//往 Fav 表中加入一条记录
		favDAO.add(fav);
		String tags = fav.getTags();
		//循环处理每一条标签
		if(null != tags && !"".equals(tags.trim())){
			String[] arrTags = tags.split(",");
			if(null != arrTags && arrTags.length > 0){
				for (String tag : arrTags) {
					//调用另一个业务类的方法
					tagBiz.dealWithTag(tag);
				}
			}
		}
	}
	@Override
	public List<Favorite> search(String type) {
		return this.favDAO.search(type);
	}

}
