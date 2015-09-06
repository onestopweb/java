package cn.dao;
import java.util.List;
import cn.entity.Duestions;
/**
 * 问题表 DAO
 * */
public interface DuestionsDao {
	/**
	 * 查询问题表列表
	 * @return
	 */
	List<Duestions> findAll();
	/**
	 * 根据 id 查询问题表的一条数据
	 * @param id
	 * @return
	 */
	Duestions findById(Integer id);
	/**
	 * 添加问题表数据
	 * @param duestions
	 */
	void add(Duestions duestions);
	/**
	 * 修改问题表数据
	 * @param duestions
	 */
	void update(Duestions duestions);
}
