package dao;

import java.util.List;

import org.hibernate.HibernateException;

import bean.Type;

public interface TypeDao {

	// 保存和查询需要加装所有的类型

	// 查找全部
	public List<Type> getAll() throws HibernateException;

	// 根据id返回type
	public Type getTypeById(int id) throws HibernateException;

}
