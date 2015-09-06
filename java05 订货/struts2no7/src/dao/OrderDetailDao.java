package dao;

import java.util.List;
import org.hibernate.HibernateException;
import entity.OrderDetail;
/**
 * 订单明细数据访问层接口
 * */
public interface OrderDetailDao {
	//根据多个id获取OrderDetail信息
	public List<OrderDetail> getOrderDetailByOdIds(List<Integer> odIds) throws HibernateException;
}
