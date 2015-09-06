package cn.biz;
import java.util.List;
import org.hibernate.HibernateException;
import cn.entity.Classes;
import cn.entity.Student;
/**
 * 学生 业务逻辑层接口
 * */
public interface StudentBiz {
	/**
	 * 获取全部的学生列表，包括班级
	 * @return
	 * @throws HibernateException
	 */
	public List<Student> getAll() throws HibernateException;
	/**
	 * 根据 id 查找学生信息
	 * @param id
	 * @return
	 * @throws HibernateException
	 */
	public Student getStudentById(Integer id) throws HibernateException;
	/**
	 * 修改学生信息
	 * @param student
	 * @return
	 * @throws HibernateException
	 */
	public int update(Student student) throws HibernateException;
	/**
	 * 获取班级的列表
	 * @return
	 * @throws HibernateException
	 */
	public List<Classes> getClassesList() throws HibernateException;
	/**
	 * 根据 id 获取班级
	 * @param id
	 * @return
	 * @throws HibernateException
	 */
	public Classes getClassesById(Integer id) throws HibernateException;
}
