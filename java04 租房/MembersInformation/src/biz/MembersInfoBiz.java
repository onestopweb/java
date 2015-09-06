package biz;

import java.util.List;

import org.hibernate.HibernateException;

import entity.MembersInfo;

/**
 * MembersInfo 业务逻辑层接口
 * */
public interface MembersInfoBiz {
	//列表分页
	public List<MembersInfo> getMembersInfoByPage(int pageIndex, int pageSize) throws HibernateException;

	//根据 mid 查询会员信息
	public MembersInfo getMembersInfoByMid(int mid) throws HibernateException;

	//修改数据
	public void update(MembersInfo membersInfo) throws HibernateException;
}
