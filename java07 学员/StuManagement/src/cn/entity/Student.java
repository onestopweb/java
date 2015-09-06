package cn.entity;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
/**
 * 学生 实体类及注解
 * */
@Entity  
@Table
public class Student {
	@Id  
	@GeneratedValue(generator="seq_student",strategy=GenerationType.SEQUENCE)  
	@SequenceGenerator(name="seq_student",sequenceName="seq_student",allocationSize=1,initialValue=1)  
	private Integer id;//学员编号
	@Column(nullable=false) 
	private String sname;//学员姓名
	@Column(nullable=false) 
	private Date birthday;//生日
	@Column(nullable=false) 
	private String gender;//性别
	@Column(nullable=false) 
	private String telephone;//电话
	@Column(nullable=false) 
	private String email;//Email
	@ManyToOne(targetEntity=Classes.class)  
	@JoinColumn(name="classid")  
	private Classes classes;//班级编号,多对一，多个学生对一个班级
	public Student() {
	}
	public Student(String sname, Date birthday, String gender,
			String telephone, String email, Classes classes) {
		this.sname = sname;
		this.birthday = birthday;
		this.gender = gender;
		this.telephone = telephone;
		this.email = email;
		this.classes = classes;
	}

	public Student(Integer id, String sname, Date birthday, String gender,
			String telephone, String email, Classes classes) {
		this.id = id;
		this.sname = sname;
		this.birthday = birthday;
		this.gender = gender;
		this.telephone = telephone;
		this.email = email;
		this.classes = classes;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Classes getClasses() {
		return classes;
	}
	public void setClasses(Classes classes) {
		this.classes = classes;
	}
}
