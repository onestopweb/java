package cn.service.biz;

import java.util.List;

import cn.entity.User;

/*
 * 用户联表 业务逻辑层 接口
 * */
public interface UserBiz {
	
	//用户列表分页联表(用户表和用户级别表)
	public List<User> userList(int pageIndex, 
			int pageSize, int levelId,String userId );
	
	//查找用用户数据联表(用户表和用户级别表)
	public User select(String userId);
}
