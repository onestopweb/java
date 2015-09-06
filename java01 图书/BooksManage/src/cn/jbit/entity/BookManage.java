package cn.jbit.entity;

import java.io.Serializable;
public class BookManage implements Serializable {
	private int id;//id
	private String name;//图书名称
	private String author;//图书作者
	private String time;//购买时间
	private String type;//图书分类
	
	public BookManage() {}//无参构造方法
	public BookManage(int id, String name, String author, String time,
			String type) {//有参构造方法
		this.id = id;
		this.name = name;
		this.author = author;
		this.time = time;
		this.type = type;
	}
	public int getId() {//得到 id 
		return id;
	}
	public void setId(int id) {//设置 id
		this.id = id;
	}
	public String getName() {//得到 图书名称
		return name;
	}
	public void setName(String name) {//设置 图书名称
		this.name = name;
	}
	public String getAuthor() {//得到 图书作者
		return author;
	}
	public void setAuthor(String author) {//设置 图书作者
		this.author = author;
	}
	public String getTime() {//得到 购买时间
		return time;
	}
	public void setTime(String time) {//设置 购买时间
		this.time = time;
	}
	public String getType() {//得到 图书分类
		return type;
	}
	public void setType(String type) {//设置 图书分类
		this.type = type;
	}
}
