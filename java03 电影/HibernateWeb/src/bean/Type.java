package bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
/**
 * Type 实体类及注解
 * */
@Entity
@Table
public class Type {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq_type")
	@SequenceGenerator(sequenceName="seq_type",name="seq_type",initialValue=1,allocationSize=1)
	private int id;//类型编号
	@Column
	private String name;//类型名称
	
	/*
	 * 构造方法
	 * */
	public Type() {
	}
	public Type(String name) {
		this.name = name;
	}

	/*
	 * 封装方法
	 * */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
