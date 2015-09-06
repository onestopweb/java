package cn.service.dao;

import java.util.List;

import cn.entity.UserLevel;

/*
 * 用户级别表 Dao 接口
 * */
public interface UserLevelDao {
	
	//用户级别表列表
	public List<UserLevel> userLevelList();
}
