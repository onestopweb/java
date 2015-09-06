package cn.biz.impl;
import java.util.List;
import org.hibernate.HibernateException;
import cn.biz.StudentBiz;
import cn.dao.ClassesDao;
import cn.dao.StudentDao;
import cn.dao.impl.ClassesDaoImpl;
import cn.dao.impl.StudentDaoImpl;
import cn.entity.Classes;
import cn.entity.Student;
/**
 * 学生 业务逻辑层实现
 * */
public class StudentBizImpl implements StudentBiz {
	//学生 数据访问层
	private StudentDao studentDao = new StudentDaoImpl();
	//班级 数据访问层
	private ClassesDao classesDao = new ClassesDaoImpl();
	/**
	 * 获取全部的学生列表，包括班级
	 * @return
	 * @throws HibernateException
	 */
	public List<Student> getAll() throws HibernateException {
		return studentDao.getAll();
	}
	/**
	 * 根据 id 查找学生信息
	 * @param id
	 * @return
	 * @throws HibernateException
	 */
	public Student getStudentById(Integer id) throws HibernateException {
		return studentDao.getStudentById(id);
	}
	/**
	 * 修改学生信息
	 * @param student
	 * @return
	 * @throws HibernateException
	 */
	public int update(Student student) throws HibernateException {
		return studentDao.update(student);
	}
	/**
	 * 获取班级的列表
	 * @return
	 * @throws HibernateException
	 */
	public List<Classes> getClassesList() throws HibernateException {
		return classesDao.getClassesList();
	}
	/**
	 * 根据 id 获取班级
	 * @param id
	 * @return
	 * @throws HibernateException
	 */
	public Classes getClassesById(Integer id) throws HibernateException {
		return classesDao.getClassesById(id);
	}

}
