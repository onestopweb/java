package dao;

import java.util.List;
import org.hibernate.HibernateException;
import entity.Goods;
/**
 * 商品数据访问层接口
 * */
public interface GoodsDao {
	//获取所有商品的信息
	public List<Goods> getAll() throws HibernateException;
	//根据多个id获取商品信息
	public List<Goods> getGoodsByIds(Integer[] ids) throws HibernateException;
	//保存订单
	public void saveOrder(List<Goods> goodsList,Integer[] amounts,String name,String address); 
}
