package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * MembersInfo 实体类及注解
 */
@Entity
@Table
public class MembersInfo {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq_membersinfo")
	@SequenceGenerator(sequenceName="seq_membersinfo",name="seq_membersinfo",initialValue=1,allocationSize=1)
	private int mid;//会员编号
	@Column
	private String mname;//会员姓名
	@Column
	private String mgender;//会员性别
	@Column
	private int mage;//会员年龄
	@Column
	private String maddress;//家庭住址
	@Column
	private String memail;//电子邮件
	/*
	 * 构造方法
	 * */
	public MembersInfo() {
	}
	public MembersInfo(String mname, String mgender, int mage, String maddress,
			String memail) {
		this.mname = mname;
		this.mgender = mgender;
		this.mage = mage;
		this.maddress = maddress;
		this.memail = memail;
	}
	public MembersInfo(int mid, String mname, String mgender, int mage,
			String maddress, String memail) {
		this.mid = mid;
		this.mname = mname;
		this.mgender = mgender;
		this.mage = mage;
		this.maddress = maddress;
		this.memail = memail;
	}

	/*
	 * 封装方法
	 * */
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getMgender() {
		return mgender;
	}
	public void setMgender(String mgender) {
		this.mgender = mgender;
	}
	public int getMage() {
		return mage;
	}
	public void setMage(int mage) {
		this.mage = mage;
	}
	public String getMaddress() {
		return maddress;
	}
	public void setMaddress(String maddress) {
		this.maddress = maddress;
	}
	public String getMemail() {
		return memail;
	}
	public void setMemail(String memail) {
		this.memail = memail;
	}
}
