package cn.biz.impl;
import java.util.List;
import cn.biz.DuestionsBiz;
import cn.dao.AnswersDao;
import cn.dao.DuestionsDao;
import cn.entity.Answers;
import cn.entity.Duestions;
public class DuestionsBizImpl implements DuestionsBiz {
	private AnswersDao answersDao;
	private DuestionsDao duestionsDao;
	public void setAnswersDao(AnswersDao answersDao) {
		this.answersDao = answersDao;
	}
	public void setDuestionsDao(DuestionsDao duestionsDao) {
		this.duestionsDao = duestionsDao;
	}
	@Override
	public List<Duestions> findAll() {
		return duestionsDao.findAll();
	}
	@Override
	public Duestions findById(Integer id) {
		return duestionsDao.findById(id);
	}
	@Override
	public void insert(Answers answers) {
		answersDao.insert(answers);
	}
	@Override
	public void add(Duestions duestions) {
		duestionsDao.add(duestions);
	}
	@Override
	public List<Answers> findAnswersList(Integer qid) {
		return answersDao.findAnswersList(qid);
	}
	@Override
	public void update(Duestions duestions) {
		duestionsDao.update(duestions);
	}
}
