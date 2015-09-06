package cn.client.dao;

import java.util.List;

import cn.entity.NeComment;

/*
 * 评论表 DAO 接口
 * */
public interface NeCommentDao {
	
	//根据设置商品id来获取总页数
	public int getTotalCount(int id);
	
	//根据设置每页的数目和第几页和商品id来获取列表数据
	public List<NeComment> getNeCommentByPage(int pageIndex, int pageSize,int id);
	
	//根据商品的id和用户名插入评论内容
	public int addNeComment(int id, String username, String content);
	
	//根据名字来在获取评论数
	public int getTotalCount(String username);
	
	//根据状态号获取列表信息
	public List<NeComment> getNeCommentByStatus(int statusId);
	
	//根据商品id和用户名来判断是否评论过
	public int selectComment(int id, String username);
}
