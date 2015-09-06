package cn.client.tool;

import java.util.List;

import cn.client.biz.PlanOrderBiz;
import cn.client.biz.impl.PlanOrderBizImpl;
import cn.entity.PlanOrder;

//工具类
public class Tool {
	
	//用来接收订单的总价的
	public static double totaPrice;
	
	//用来判断是否跳转的
	public static int skip;
	
	//根据状态号和姓名获取预订单总价
	public static double totaPrice(String username, int statusId){
		PlanOrderBiz planOrderBiz = new PlanOrderBizImpl();
		List<PlanOrder> planOrderList = planOrderBiz.planOrderList(username, statusId);
		double totaPrice = 0.0;
		for(int i=0; i<planOrderList.size();i++){
			totaPrice += planOrderList.get(i).getPrice()*planOrderList.get(i).getNumber();
		}
		return totaPrice;
	}
	
	//控制搜索页显示的数量
	public static final int pageSize = 4;
}
