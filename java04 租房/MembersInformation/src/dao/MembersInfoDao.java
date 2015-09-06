package dao;

import java.util.List;

import org.hibernate.HibernateException;

import entity.MembersInfo;

/**
 * MembersInfo 数据访问层接口
 * */
public interface MembersInfoDao {
	
	//列表分页
	public List<MembersInfo> getMembersInfoByPage(int pageIndex, int pageSize) throws HibernateException;
	
	//根据 mid 查询会员信息
	public MembersInfo getMembersInfoByMid(int mid) throws HibernateException;
	
	//修改数据
	public void update(MembersInfo membersInfo) throws HibernateException;
}
