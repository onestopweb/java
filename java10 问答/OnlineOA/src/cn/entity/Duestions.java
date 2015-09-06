package cn.entity;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
/**
 * 问题表
 * */
@SuppressWarnings("serial")
public class Duestions implements java.io.Serializable {
	private Integer id;//问题 id
	private String title;//问题名
	private String detaildesc;//问题描述
	private Integer ansewercount;//回答次数
	private Date lastmodidfied;//最后修改时间
	@SuppressWarnings("rawtypes")
	private Set answerses = new HashSet(0);//多对一映射
	@Override
	public String toString() {
		return "Duestions [id=" + id + ", title=" + title + ", detaildesc="
				+ detaildesc + ", ansewercount=" + ansewercount
				+ ", lastmodidfied=" + lastmodidfied + "]";
	}
	public Duestions() {
	}
	public Duestions(String title, Integer ansewercount) {
		this.title = title;
		this.ansewercount = ansewercount;
	}
	@SuppressWarnings("rawtypes")
	public Duestions(String title, String detaildesc, Integer ansewercount,
			Date lastmodidfied, Set answerses) {
		this.title = title;
		this.detaildesc = detaildesc;
		this.ansewercount = ansewercount;
		this.lastmodidfied = lastmodidfied;
		this.answerses = answerses;
	}
	public Duestions(String title, String detaildesc, Integer ansewercount,
			Date lastmodidfied) {
		this.title = title;
		this.detaildesc = detaildesc;
		this.ansewercount = ansewercount;
		this.lastmodidfied = lastmodidfied;
	}
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return this.title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDetaildesc() {
		return this.detaildesc;
	}
	public void setDetaildesc(String detaildesc) {
		this.detaildesc = detaildesc;
	}
	public Integer getAnsewercount() {
		return this.ansewercount;
	}
	public void setAnsewercount(Integer ansewercount) {
		this.ansewercount = ansewercount;
	}
	public Date getLastmodidfied() {
		return this.lastmodidfied;
	}
	public void setLastmodidfied(Date lastmodidfied) {
		this.lastmodidfied = lastmodidfied;
	}
	@SuppressWarnings("rawtypes")
	public Set getAnswerses() {
		return this.answerses;
	}
	@SuppressWarnings("rawtypes")
	public void setAnswerses(Set answerses) {
		this.answerses = answerses;
	}
}