package cn.action;

import java.util.HashMap;
import java.util.Map;

import cn.biz.BookBiz;
import cn.biz.impl.BookBizImpl;
import cn.entity.Book;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Book 控制器
 * */
public class BookAction extends ActionSupport {
	
	private BookBiz bookBiz = new BookBizImpl();//业务类
	private Book book;//一本书
	private int page;//当前第几页
	private Map<String, Object> data = new HashMap<String, Object>();//封装数据
	private int rows;//页面大小
	private String order;//排序方向 desc 和 asc
	private String sort;//排序属性名，如：price

	public void setOrder(String order) {
		this.order = order;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPage() {
		return page;
	}

	public Map<String, Object> getData() {
		return data;
	}

	private boolean operateSuccess;

	public boolean isOperateSuccess() {
		return operateSuccess;
	}

	public void setOperateSuccess(boolean operateSuccess) {
		this.operateSuccess = operateSuccess;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public void setBookBiz(BookBiz bookBiz) {
		this.bookBiz = bookBiz;
	}
	/**
	 * 查询某一页的书籍
	 * 
	 * @return
	 */
	public String list(){
		data.clear();
		if(sort == null){
			sort = "title";
		}
		if(order == null){
			order = "asc";
		}
		data.put("rows", bookBiz.findPageBooks(page, rows, sort, order));
		data.put("total", bookBiz.findTotal());
		return SUCCESS;
	}
	
	/**
	 * 添加书籍
	 * 
	 * @return
	 */
	public String addBook(){
		operateSuccess = (bookBiz.addBook(book)>0);
		return SUCCESS;
	}
	
	/**
	 * 更新书籍
	 * 
	 * @return
	 */
	public String updateBook(){
		operateSuccess = (bookBiz.updateBook(book)>0);
		return SUCCESS;
	}
	
	/**
	 * 删除书籍
	 * 
	 * @return
	 */
	public String deleteBook(){
		operateSuccess = (bookBiz.deleteBook(book.getId())>0);
		return SUCCESS;
	}
}
