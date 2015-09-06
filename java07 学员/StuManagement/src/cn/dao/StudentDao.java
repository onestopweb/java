package cn.dao;
import java.util.List;
import org.hibernate.HibernateException;
import cn.entity.Student;
/**
 * 学生 数据访问层接口
 * */
public interface StudentDao {
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
}
