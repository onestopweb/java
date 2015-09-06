package cn.dao.impl;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import cn.dao.StudentDao;
import cn.entity.Student;
import cn.util.HibernateSessionFactory;
/**
 * 学生 数据访问层实现
 * */
public class StudentDaoImpl implements StudentDao {
	/**
	 * 获取全部的学生列表，包括班级
	 * @return
	 * @throws HibernateException
	 */
	@SuppressWarnings("unchecked")
	public List<Student> getAll() throws HibernateException {
		String hql="from Student";  
		List<Student> students=null;  
		Session session=HibernateSessionFactory.getSession();  
		Query query=session.createQuery(hql);  
		students=query.list();  
		HibernateSessionFactory.closeSession();  
		return students;  
	}
	/**
	 * 根据 id 查找学生信息
	 * @param id
	 * @return
	 * @throws HibernateException
	 */
	public Student getStudentById(Integer id) throws HibernateException {
		String hql="from Student where id =:id";  
		Student student=null;  
        Session session=HibernateSessionFactory.getSession();  
        Query query=session.createQuery(hql);  
        query.setInteger("id", id);  
        student = (Student) query.uniqueResult();  
        HibernateSessionFactory.closeSession();  
        return student;  
	}
	/**
	 * 修改学生信息
	 * @param student
	 * @return
	 * @throws HibernateException
	 */
	public int update(Student student) throws HibernateException {
		Session session = HibernateSessionFactory.getSession();  
        Transaction tx = null;  
        int id =0;
        try {  
            tx = session.beginTransaction();  
            session.update(student);  
            tx.commit();  
            id =1;
        } catch (HibernateException e) {  
            e.printStackTrace();  
            tx.rollback();  
        }finally{  
            HibernateSessionFactory.closeSession();  
        }  
        return id;
	}

}
