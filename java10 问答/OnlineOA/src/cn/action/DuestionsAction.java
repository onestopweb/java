package cn.action;
import java.util.Date;
import java.util.List;
import cn.biz.DuestionsBiz;
import cn.entity.Answers;
import cn.entity.Duestions;
import com.opensymphony.xwork2.ActionSupport;
@SuppressWarnings("serial")
public class DuestionsAction extends ActionSupport {
	private DuestionsBiz duestionsBiz;
	private List<Duestions> duestions;
	private List<Answers> answers;
	private Answers answer;
	private Duestions duestion;
	private Integer id;
	/**
	 * 显示列表
	 * @return
	 * @throws Exception
	 */
	public String getAll() throws Exception{
		/*
		 * 如果 id 不为空，代表是从 findDetatil.acton 传来的数据
		 * 第一步：根据 id 获取问题表的数据
		 * 第二步：插入应答表的数据，主键是问题表
		 * 第三步：设置问题表的应答次数，和最新的时间
		 * 第四步：修改问题表数据
		 */
		if(id != null){
			duestion = duestionsBiz.findById(id);
			duestionsBiz.insert(new Answers(duestion, answer.getAnscontent(), new Date()));
			duestion.setAnsewercount(duestionsBiz.findAnswersList(id).size());
			duestion.setLastmodidfied(new Date());
			duestionsBiz.update(duestion);
			id = null;//清空，要不然重复插入应答表的数据
		}
		//最后，显示列表
		duestions = duestionsBiz.findAll();
		return SUCCESS;
	}
	/**
	 * 应答表列表
	 * @return
	 * @throws Exception
	 */
	public String findDetatil() throws Exception{
		//传过的 id 来获取数据
		if(id != null){
		duestion = duestionsBiz.findById(id);
		answers = duestionsBiz.findAnswersList(id);
		}
		return SUCCESS;
	}
	/**
	 * 插入问题表数据
	 * @return
	 * @throws Exception
	 */
	public String doAdd() throws Exception{
		if(duestion!=null){
			duestionsBiz.add(new Duestions(duestion.getTitle(), duestion.getDetaildesc(), 0, new Date()));
		}
		return SUCCESS;
	}
	public DuestionsBiz getDuestionsBiz() {
		return duestionsBiz;
	}
	public void setDuestionsBiz(DuestionsBiz duestionsBiz) {
		this.duestionsBiz = duestionsBiz;
	}
	public List<Duestions> getDuestions() {
		return duestions;
	}
	public void setDuestions(List<Duestions> duestions) {
		this.duestions = duestions;
	}
	public Duestions getDuestion() {
		return duestion;
	}
	public void setDuestion(Duestions duestion) {
		this.duestion = duestion;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public List<Answers> getAnswers() {
		return answers;
	}
	public void setAnswers(List<Answers> answers) {
		this.answers = answers;
	}
	public Answers getAnswer() {
		return answer;
	}
	public void setAnswer(Answers answer) {
		this.answer = answer;
	}
}
