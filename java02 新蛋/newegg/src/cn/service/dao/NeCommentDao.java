package cn.service.dao;

import java.util.List;

import cn.entity.NeComment;

/*
 * 评论表 DAO 接口
 * */
public interface NeCommentDao {

	//评论分页
	public List<NeComment> getNeCommentByPage(int pageIndex, 
			int pageSize, int id, String userId);

	//根据商品id和用户名来获取评论数量
	public int getNeCommentByCount( int id, String userId);
	
	//根据商品id和用户名修改评论状态
	public int updateStatusId(int id,String userId, int statusId);
	
	//根据商品id和用户名获取数据
	public NeComment getComment(int id,String userId);
	
	//根据商品id和用户名修改评论内容
	public int updateComment(int id,String userId,String comment);
	
}
