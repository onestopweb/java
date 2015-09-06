package cn.biz.impl;
import java.util.List;
import cn.biz.TagBiz;
import cn.dao.TagDAO;
import cn.entity.Tag;
public class TagBizImpl implements TagBiz {
	private TagDAO tagDAO;
	public void setTagDAO(TagDAO tagDAO) {
		this.tagDAO = tagDAO;
	}
	@Override
	public void dealWithTag(String tagName) {
		Tag tag = tagDAO.get(tagName);
		//有则加 1 更新
		if(null != tag){
			tag.setCount(tag.getCount()+1);
			tagDAO.update(tag);
		}else{
			//没有则新加 1 个
			tag = new Tag();
			tag.setName(tagName);
			tag.setCount(1);
			tagDAO.add(tag);
		}
	}
	@Override
	public List<Tag> search(Tag condition) {
		return this.tagDAO.search(condition);
	}
}
