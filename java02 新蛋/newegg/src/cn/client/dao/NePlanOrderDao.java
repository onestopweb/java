package cn.client.dao;

import java.util.List;

import cn.entity.NePlanOrder;
/*
 * 预订单表 DAO 接口
 * */
public interface NePlanOrderDao {

	//预订单的列表，根据名字和状态号来获取列表数据
	public List<NePlanOrder> nePlanOrderList(String username, int statusId);

	//删除预订单，根据商品id和名字和状态号
	public int deletePlanOrder(int id, String username, int statusId);

	//删除预订单，根据用户名字和状态号
	public int deletePlanOrder(String username, int statusId);
	
	//修改除预订单，根据商品id和名字和状态号和数量
	public int updatePlanOrder(int id, String username, int statusId, int number);
	
	//插入一条数据，根据商品id和名字和状态号和数量
	public int insertPlanOrder(int id, String username, int statusId, int number);
	
	//判断是否已经存在相同的产品，根据商品id和名字和状态号
	public int selectPlanOrde(int id, String username, int statusId);
}
