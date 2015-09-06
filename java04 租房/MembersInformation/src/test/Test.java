package test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.MembersInfo;

import util.HibernateSessionFactory;

public class Test {
	public static void main(String[] args) {
		/*
		 * List<MembersInfo> membersInfos = getMembersInfoByPage(2, 3); for
		 * (MembersInfo membersInfo : membersInfos) {
		 * System.out.println(membersInfo
		 * .getMid()+" "+membersInfo.getMaddress()); }
		 */

		/*
		 * MembersInfo membersInfo = getMembersInfoByMid(2);
		 * System.out.println(membersInfo
		 * .getMid()+" "+membersInfo.getMaddress());
		 */
		MembersInfo membersInfo = new MembersInfo(2, "何开6", "男", 18,
				"新凤凰直街18号", "963AA@qq.com");
		update(membersInfo);

	}

	private static void update(MembersInfo membersInfo) {
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.update(membersInfo);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

	private static MembersInfo getMembersInfoByMid(int mid) {
		Session session = HibernateSessionFactory.getSession();
		String hql = "from MembersInfo where mid=:mid";
		Query query = session.createQuery(hql);
		query.setInteger("mid", mid);
		MembersInfo membersInfo = (MembersInfo) query.uniqueResult();
		HibernateSessionFactory.closeSession();
		return membersInfo;
	}

	private static List<MembersInfo> getMembersInfoByPage(int pageIndex,
			int pageSize) {
		Session session = HibernateSessionFactory.getSession();
		String hql = "from MembersInfo";
		Query query = session.createQuery(hql);
		query.setFirstResult((pageIndex - 1) * pageSize);
		query.setMaxResults(pageSize);
		List<MembersInfo> membersInfos = query.list();
		HibernateSessionFactory.closeSession();
		return membersInfos;
	}
}
