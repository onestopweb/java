package cn.dao;
import java.util.List;
import org.hibernate.HibernateException;
import cn.entity.Classes;
/**
 * 班级 数据访问层接口
 * */
public interface ClassesDao {
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
