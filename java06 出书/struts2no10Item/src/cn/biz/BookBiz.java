package cn.biz;

import java.util.List;

import cn.entity.Book;

/**
 * Book 业务逻辑层接口
 * */
public interface BookBiz {

	public long findTotal();
	
	/**
	 * 查询一页的数据
	 * 
	 * @param pageIndex 从哪页开始
	 * @param pageSize 得到的页数
	 * @param sort 排序的列
	 * @param order 排序的方式 desc/asc
	 * @return
	 */
	public List<Book> findPageBooks(final int pageIndex, final int pageSize, final String sort, final String order);
	
	public int addBook(Book book);
	
	public int deleteBook(int id);
	
	public int updateBook(Book book);
}
