package cn.dao;

import java.util.List;

import cn.entity.Book;
/**
 * Book 数据访问层接口
 * */
public interface BookDao {
	/**
	 * 查询共有多少记录
	 * 
	 * @return
	 */
	public long findTotal();
	
	/**
	 * 查询一页的数据
	 * 
	 * @param begin 从哪条开始 0
	 * @param end 得到多少条
	 * @param sort 排序的列
	 * @param order 排序的方式 desc/asc
	 * @return
	 */
	public List<Book> findPageBooks(final int begin, final int end, final String sort, final String order);
	
	/**
	 * 增加一条数据
	 * 
	 * @param book 传来的参数不包括 id
	 * @return
	 */
	public int addBook(Book book);
	
	/**
	 * 删除一条数据
	 * 
	 * @param id 根据 id 作删除
	 * @return
	 */
	public int deleteBook(int id);
	
	/**
	 * 修改一条数据
	 * 
	 * @param book 传来的参数包括 id
	 * @return
	 */
	public int updateBook(Book book);
}
