package cn.service.biz;

import java.util.List;

import cn.entity.OrderFather;

/*
 * 订单主表联表 业务逻辑层 接口
 * */
public interface OrderFatherBiz {
	//分页查询，联表（订单主表，订单子表，订单状态表，商品表）
	public List<OrderFather> getOrderFatherByPage(int pageIndex, int pageSize,String orderFatherId ,String userId);
}
