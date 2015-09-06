package cn.client.biz;

import java.util.List;

import cn.entity.PlanOrder;

/*
 * 预订单表 业务逻辑层 接口
 * */
public interface PlanOrderBiz {
	
	//预订单表联表（预订单表，商品表）
	public List<PlanOrder> planOrderList(String username, int statusId);
	
}
