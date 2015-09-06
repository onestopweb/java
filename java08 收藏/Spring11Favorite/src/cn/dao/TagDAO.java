package cn.dao;
import java.util.List;
import cn.entity.Tag;
/**
 * 标签接口
 */
public interface TagDAO extends BaseDao<Tag> {
	public List<Tag> search(Tag condition);
	/**
	 * 根据标签名字查询标签
	 * @param tagName
	 * @return
	 */
	public Tag get(String tagName);
}
