package entity;

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
 * 订单明细表
 * */
@Entity
@Table
public class OrderDetail {
	@Id
	@GeneratedValue(generator="seq_orderDetail",strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="seq_orderDetail",sequenceName="seq_orderDetail",allocationSize=1,initialValue=1)
	private Integer id;//订单明细编号
	@Column(nullable=false)
	private Integer amount;//商品数量
	@ManyToOne(targetEntity=Goods.class)
	@JoinColumn(name="goods_id")
	private Goods goods;
	@ManyToOne(targetEntity=Order.class)
	@JoinColumn(name="order_id")
	private Order order;
	public OrderDetail() {
	}
	public OrderDetail(Integer amount, Goods goods, Order order) {
		super();
		this.amount = amount;
		this.goods = goods;
		this.order = order;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
}
