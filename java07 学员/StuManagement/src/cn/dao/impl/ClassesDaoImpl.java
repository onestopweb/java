package cn.dao.impl;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import cn.dao.ClassesDao;
import cn.entity.Classes;
import cn.util.HibernateSessionFactory;
/**
 * 班级 数据访问层实现
 * */
public class ClassesDaoImpl implements ClassesDao {
	/**
	 * 获取班级的列表
	 * @return
	 * @throws HibernateException
	 */
	@SuppressWarnings("unchecked")
	public List<Classes> getClassesList() throws HibernateException {
		String hql="from Classes";  
		List<Classes> classes=null;  
		Session session=HibernateSessionFactory.getSession();  
		Query query=session.createQuery(hql);  
		classes=query.list();  
		HibernateSessionFactory.closeSession();  
		return classes;  
	}
	/**
	 * 根据 id 获取班级
	 * @param id
	 * @return
	 * @throws HibernateException
	 */
	public Classes getClassesById(Integer id) throws HibernateException {
		String hql="from Classes where id =:id";  
		Classes classes=null;  
        Session session=HibernateSessionFactory.getSession();  
        Query query=session.createQuery(hql);  
        query.setInteger("id", id);  
        classes = (Classes) query.uniqueResult();  
        HibernateSessionFactory.closeSession();  
        return classes; 
	}

}
