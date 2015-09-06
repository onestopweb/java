package cn.service.biz;

import java.util.List;

import cn.entity.Comment;

/*
 * 评论联表 业务逻辑层 接口
 * */
public interface CommentBiz {
	
	//评论分页 联表（评论表，评论状态表）
	public List<Comment>  getCommentByPage(int pageIndex, int pageSize,
			int id, String userId);
}
