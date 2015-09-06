package dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.classic.Session;

import util.HibernateSessionFactory;
import bean.Type;
import dao.TypeDao;

public class TypeDaoImpl implements TypeDao{

	public List<Type> getAll() throws HibernateException {
		List<Type> types=null;
		String hql="from Type";
		Session session=HibernateSessionFactory.getSession();
		Query query=session.createQuery(hql);
		types=query.list();
		HibernateSessionFactory.closeSession();
		return types;
	}

	// 根据id返回type
	public Type getTypeById(int id) throws HibernateException{
		Session session = HibernateSessionFactory.getSession();
		String hql = "from Type where id=:id";
		Query query= session.createQuery(hql);
		query.setInteger("id", id);
		Type type = (Type) query.uniqueResult(); 
		return type;
	}

}
