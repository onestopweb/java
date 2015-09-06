package cn.dao;
import java.util.List;
import cn.entity.Answers;
/**
 * 应答表 DAO
 * */
public interface AnswersDao {
	/**
	 * 插入应答表数据
	 * @param answers
	 */
	void insert(Answers answers);
	/**
	 * 根据外键查询应答表列表
	 * @param qid
	 * @return
	 */
	List<Answers> findAnswersList(Integer qid);
}
