package cn.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
/**
 * 班级 实体类及注解
 * */
@Entity  
@Table
public class Classes {
	@Id  
	@GeneratedValue(generator="seq_classes",strategy=GenerationType.SEQUENCE)  
	@SequenceGenerator(name="seq_classes",sequenceName="seq_classes",allocationSize=1,initialValue=1)   
	private Integer id;//班级编号
	@Column(nullable=false) 
	private String cname;//班级名称
	public Classes() {
	}
	public Classes(String cname) {
		this.cname = cname;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
}
