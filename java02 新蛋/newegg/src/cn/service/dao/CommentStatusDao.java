package cn.service.dao;

import java.util.List;

import cn.entity.CommentStatus;

/*
 * 评论状态表 DAO 接口
 * */
public interface CommentStatusDao {

	//评论状态列表
	public List<CommentStatus> commentStatusList();
}
