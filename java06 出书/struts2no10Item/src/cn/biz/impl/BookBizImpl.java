package cn.biz.impl;

import java.util.List;

import cn.biz.BookBiz;
import cn.dao.BookDao;
import cn.dao.impl.BookDaoImpl;
import cn.entity.Book;

/**
 * Book 业务逻辑层实现
 * */
public class BookBizImpl implements BookBiz {

	private BookDao bookDao = new BookDaoImpl();
	
	public long findTotal() {
		return bookDao.findTotal();
	}

	/**
	 * 查询一页的数据
	 * 
	 * @param pageIndex 当前页号
	 * @param pageSize 页面大小
	 * @param sort 排序的列
	 * @param order 排序的方式 desc/asc
	 * @return
	 */
	public List<Book> findPageBooks(int pageIndex, int pageSize, String sort,
			String order) {
		int begin = (pageIndex - 1)*pageSize;
		return bookDao.findPageBooks(begin, pageSize, sort, order);
	}

	public int addBook(Book book) {
		return bookDao.addBook(book);
	}

	public int deleteBook(int id) {
		return bookDao.deleteBook(id);
	}

	public int updateBook(Book book) {
		return bookDao.updateBook(book);
	}

}
