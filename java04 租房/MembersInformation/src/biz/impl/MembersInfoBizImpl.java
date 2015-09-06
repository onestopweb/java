package biz.impl;

import java.util.List;

import org.hibernate.HibernateException;

import dao.MembersInfoDao;
import dao.impl.MembersInfoDaoImpl;

import entity.MembersInfo;
import biz.MembersInfoBiz;

/**
 * MembersInfo 业务逻辑层实现
 * */
public class MembersInfoBizImpl implements MembersInfoBiz {
	
	//全局 MembersInfoDao 对象
	MembersInfoDao dao = new MembersInfoDaoImpl();
	
	//列表分页
	public List<MembersInfo> getMembersInfoByPage(int pageIndex, int pageSize) throws HibernateException{
		return dao.getMembersInfoByPage(pageIndex, pageSize);
	}

	//根据 mid 查询会员信息
	public MembersInfo getMembersInfoByMid(int mid) throws HibernateException{
		return dao.getMembersInfoByMid(mid);
	}

	//修改数据
	public void update(MembersInfo membersInfo) throws HibernateException{
		dao.update(membersInfo);
	}
}
