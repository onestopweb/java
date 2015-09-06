package cn.entity;
import java.util.Date;
/**
 * 应答表
 * */
@SuppressWarnings("serial")
public class Answers implements java.io.Serializable {
	private Integer id;//答案 id
	private Duestions duestions;//一对多映射
	private String anscontent;//答案内容
	private Date ansdate;//回答时间
	@Override
	public String toString() {
		return "Answers [id=" + id + ", anscontent=" + anscontent + ", ansdate=" + ansdate + "]";
	}
	public Answers() {
	}
	public Answers(Duestions duestions, String anscontent) {
		this.duestions = duestions;
		this.anscontent = anscontent;
	}
	public Answers(Duestions duestions, String anscontent, Date ansdate) {
		this.duestions = duestions;
		this.anscontent = anscontent;
		this.ansdate = ansdate;
	}
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Duestions getDuestions() {
		return this.duestions;
	}
	public void setDuestions(Duestions duestions) {
		this.duestions = duestions;
	}
	public String getAnscontent() {
		return this.anscontent;
	}
	public void setAnscontent(String anscontent) {
		this.anscontent = anscontent;
	}
	public Date getAnsdate() {
		return this.ansdate;
	}
	public void setAnsdate(Date ansdate) {
		this.ansdate = ansdate;
	}
}