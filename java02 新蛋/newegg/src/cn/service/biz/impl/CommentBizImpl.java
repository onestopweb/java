package cn.service.biz.impl;

import java.util.ArrayList;
import java.util.List;

import cn.entity.Comment;
import cn.entity.CommentStatus;
import cn.entity.NeComment;
import cn.service.biz.CommentBiz;
import cn.service.dao.CommentStatusDao;
import cn.service.dao.NeCommentDao;
import cn.service.dao.impl.CommentStatusDaoImpl;
import cn.service.dao.impl.NeCommentDaoImpl;

/*
 * 评论联表 业务逻辑层 实现
 * */
public class CommentBizImpl implements CommentBiz {

	//评论分页 联表（评论表，评论状态表）
	public List<Comment> getCommentByPage(int pageIndex, int pageSize, int id,
			String userId) {
		
		//评论表
		NeCommentDao neCommentDao = new NeCommentDaoImpl();
		List<NeComment> neCommentlist = neCommentDao.getNeCommentByPage(pageIndex, pageSize, id, userId);

		//评论状态表
		CommentStatusDao commentStatusDao = new CommentStatusDaoImpl();
		List<CommentStatus> commentStatusList = commentStatusDao.commentStatusList();
		
		//开始联表
		List<Comment> list = new ArrayList<Comment>();
		Comment item = null;
		
		for(int i=0; i<neCommentlist.size();i++){
			int products_id = neCommentlist.get(i).getNe_products_id();
			String content = neCommentlist.get(i).getNe_content();
			String user_id = neCommentlist.get(i).getNe_user_id();
			String time = neCommentlist.get(i).getNe_time();
			int status_id = neCommentlist.get(i).getNe_status_id();
			String status_content =null;
			for(int j=0; j<commentStatusList.size();j++){
				if(neCommentlist.get(i).getNe_status_id()==commentStatusList.get(j).getComment_status_id()){
					status_content = commentStatusList.get(j).getComment_status_content();
					break;
				}
			}
			item = new Comment(products_id, content, user_id, time, status_id, status_content);
			list.add(item);
		}
		return list;
	}

}
