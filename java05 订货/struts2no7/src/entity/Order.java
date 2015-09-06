package entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
/**
 * 订单表
 * */
@Entity
@Table(name="t_order")
public class Order {
	@Id
	@GeneratedValue(generator="seq_order",strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="seq_order",sequenceName="seq_order",allocationSize=1,initialValue=1)
	private Integer id;//订单号
	@Column
	private String name;//收货人
	@Column
	private String  address;//收货地址
	@Column
	private Date createTime;//订单创建时间
	@OneToMany
	@Cascade(CascadeType.SAVE_UPDATE)
	@JoinColumn(name="order_id")
	private Set<OrderDetail> details=new HashSet<OrderDetail>();
	public Order() {
	}
	public Order(String name, String address, Date createTime) {
		this.name = name;
		this.address = address;
		this.createTime = createTime;

	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Set<OrderDetail> getDetails() {
		return details;
	}
	public void setDetails(Set<OrderDetail> details) {
		this.details = details;
	}
}
