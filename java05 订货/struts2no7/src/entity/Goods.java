package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
/**
 * 商品表
 * */
@Entity
@Table(name="t_goods")
public class Goods {
	@Id
	@GeneratedValue(generator="seq_goods",strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="seq_goods",sequenceName="seq_goods",allocationSize=1,initialValue=1)
	private Integer id;//商品编号
	@Column
	private Double price;//商品价格
	@Column
	private String name;//商品名称
	@Column
	private String specification;//商品介绍
	@Column
	private String manufacture;//制造商
	public Goods() {
	}
	public Goods(Double price, String name, String specification,String manufacture) {
		this.price = price;
		this.name = name;
		this.specification = specification;
		this.manufacture = manufacture;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSpecification() {
		return specification;
	}
	public void setSpecification(String specification) {
		this.specification = specification;
	}
	public String getManufacture() {
		return manufacture;
	}
	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}
}
