package dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateSessionFactory;

import dao.MembersInfoDao;
import entity.MembersInfo;

/**
 * MembersInfo 数据访问层实现
 * */
public class MembersInfoDaoImpl implements MembersInfoDao {
	
	//列表分页
	public List<MembersInfo> getMembersInfoByPage(int pageIndex, int pageSize) throws HibernateException{
		Session session = HibernateSessionFactory.getSession();
		String hql = "from MembersInfo";
		 Query query = session.createQuery(hql); 
		 query.setFirstResult((pageIndex - 1) * pageSize);  
         query.setMaxResults(pageSize);
         List<MembersInfo> membersInfos = query.list(); 
         HibernateSessionFactory.closeSession();
		return membersInfos;
	}

	//根据 mid 查询会员信息
	public MembersInfo getMembersInfoByMid(int mid) throws HibernateException{
		Session session = HibernateSessionFactory.getSession();  
        String hql = "from MembersInfo where mid=:mid";  
        Query query= session.createQuery(hql);  
        query.setInteger("mid", mid);  
        MembersInfo membersInfo = (MembersInfo) query.uniqueResult();  
        HibernateSessionFactory.closeSession();
		return membersInfo;
	}

	//修改数据
	public void update(MembersInfo membersInfo) throws HibernateException{
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.update(membersInfo);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}finally{
			HibernateSessionFactory.closeSession();
		}
	}
}
