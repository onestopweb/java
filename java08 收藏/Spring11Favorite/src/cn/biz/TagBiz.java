package cn.biz;
import java.util.List;
import cn.entity.Tag;
/**
 * 标签
 *
 */
public interface TagBiz {
	/**
	 * 通过标签名字进行处理
	 * @param tagName
	 */
	public void dealWithTag(String tagName);
	public List<Tag> search(Tag condition);
}
