package cn.biz;
import java.util.List;
import cn.entity.Standards;
public interface StandardsBiz {
	/**
	 * 列表
	 * @return
	 */
	List<Standards> findAll();
	/**
	 * 列表分页
	 * @param begin
	 * @param end
	 * @return
	 */
	List<Standards> findByPage(int pageIndex, int pageSize);
	/**
	 * 根据标准号查询列表分页
	 * @param begin
	 * @param end
	 * @param stdNum
	 * @return
	 */
	List<Standards> findByPageOfsearch(int pageIndex,int pageSize,String stdNum);
	/**
	 * 根据 id 查询
	 * @param stdId
	 * @return
	 */
	Standards findById(Integer stdId);
	/**
	 * 修改内容
	 * @param standards
	 */
	void update(Standards standards);
	/**
	 * 增加内容
	 * @param standards
	 */
	void insert(Standards standards);
	/**
	 * 多条信息删除
	 * @param stdIds
	 */
	void deleteByIds(Integer[] stdIds);
}
