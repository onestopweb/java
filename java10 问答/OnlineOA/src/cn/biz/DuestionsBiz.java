package cn.biz;
import java.util.List;
import cn.entity.Answers;
import cn.entity.Duestions;
/**
 * 问题表 业务类
 * */
public interface DuestionsBiz {
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
	 * 插入应答表数据
	 * @param answers
	 */
	void insert(Answers answers);
	/**
	 * 添加问题表数据
	 * @param duestions
	 */
	void add(Duestions duestions);
	/**
	 * 根据外键查询应答表列表
	 * @param qid
	 * @return
	 */
	List<Answers> findAnswersList(Integer qid);
	/**
	 * 修改问题表数据
	 * @param duestions
	 */
	void update(Duestions duestions);
}
