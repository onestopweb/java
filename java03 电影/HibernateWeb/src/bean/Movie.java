package bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
/**
 * Movie 实体类及注解
 * */
//多对一
@Entity
@Table
public class Movie {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq_movie")
	@SequenceGenerator(sequenceName="seq_movie",name="seq_movie",initialValue=1,allocationSize=1)
	private int id;//编号
	@Column
	private String titile;//电影名称
	@Column
	private String director;//导演
	@Column
	private String actor;//主演
	@Column
	private Double price;//价格
	@ManyToOne
	@Cascade(CascadeType.SAVE_UPDATE)
	@JoinColumn(name="typeid")
	private Type   type;//类型
	
	/*
	 * 构造方法
	 * */
	public Movie() {
	}
	public Movie(String titile, String director, String actor, Double price) {
		this.titile = titile;
		this.director = director;
		this.actor = actor;
		this.price = price;
	}
	
	public Movie(String titile, String director, String actor, Double price,
			Type type) {
		this.titile = titile;
		this.director = director;
		this.actor = actor;
		this.price = price;
		this.type = type;
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
	public String getTitile() {
		return titile;
	}
	public void setTitile(String titile) {
		this.titile = titile;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
}
