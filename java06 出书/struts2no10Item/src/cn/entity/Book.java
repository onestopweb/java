package cn.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
/**
 * BOOK 实体类
 */
@Entity  
@Table(name="BOOK")  
public class Book {
	@Id  
	@GeneratedValue(generator="BOOK_SEQ",strategy=GenerationType.SEQUENCE)  
	@SequenceGenerator(name="BOOK_SEQ",sequenceName="BOOK_SEQ",allocationSize=1,initialValue=1)  
	private int id;//编号
	@Column
	private String isbn;//书号
	@Column
	private String title;//标题
	@Column
	private double price;//价格 
	@Column
	private Date pubdate;//出版日期
	@Column
	private String intro;//简介
	public Book() {
	}
	public Book(String isbn, String title, double price, Date pubdate,
			String intro) {
		this.isbn = isbn;
		this.title = title;
		this.price = price;
		this.pubdate = pubdate;
		this.intro = intro;
	}
	
	public Book(int id, String isbn, String title, double price, Date pubdate,
			String intro) {
		this.id = id;
		this.isbn = isbn;
		this.title = title;
		this.price = price;
		this.pubdate = pubdate;
		this.intro = intro;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Date getPubdate() {
		return pubdate;
	}
	public void setPubdate(Date pubdate) {
		this.pubdate = pubdate;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
}
