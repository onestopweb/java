package cn.jbit.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.jbit.dao.BaseDao;
import cn.jbit.dao.BookManageDao;
import cn.jbit.entity.BookManage;
//BookManageDaoImpl 继承 BaseDao 实现  BookManageDao
public class BookManageDaoImpl extends BaseDao implements BookManageDao {
	Connection conn = null;//数据库连接
	PreparedStatement pstmt = null;//数据库操作
	ResultSet rs = null;//保存查询结果
	//查询一条数据
	public BookManage select(int id) {
		BookManage item = null;//声明 BookManage 对象，用来保存查询的数据
		String sql = "select b_id, b_name, b_author, to_char(b_time,'yyyy-mm-dd'), b_type " +
				"from bookmanage where b_id=?";//编写预处理 SQL
		conn = this.getConnection();//使用父类的数据库连接
		try {
			pstmt =conn.prepareStatement(sql);//实例化 PreparedStatement  
			pstmt.setInt(1, id);//设置 “？”的内容，要使用 id 查询
			rs = pstmt.executeQuery();//实例化 ResultSet 对象  
			if(rs.next()){//指针向下移动  
				item = new BookManage(//把查询到的内容保存到 BookManage 对象中
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5)
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//使用父类的关闭数据库连接，把所有都关闭
			this.closeAll(conn, pstmt, rs);
		}
		//返回保存的数据的 BookManage 对象
		return item;
	}
	//查询所有数据
	public List<BookManage> list() {
		//使用泛型集合来保存一组数据，约束类型是 BookManage 类型
		List<BookManage> list = new ArrayList<BookManage>();
		BookManage item = null;//声明 BookManage 对象，用来一行行数据
		//此处不需要设置任何内容  
		String sql ="select b_id, b_name, b_author, to_char(b_time,'yyyy-mm-dd'), b_type from bookmanage";
		conn = this.getConnection();//使用父类的数据库连接
		try {
			pstmt =conn.prepareStatement(sql);//实例化 PreparedStatement  
			rs = pstmt.executeQuery();//实例化 ResultSet 对象  
			while(rs.next()){//指针向下移动  
				item = new BookManage(//装进 BookManage 对象中
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5)
						);
				list.add(item);//再添加到泛型集合
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//使用父类的关闭数据库连接，把所有都关闭
			this.closeAll(conn, pstmt, rs);
		}
		//返回泛型集合，里面装着所有所有数据
		return list;
	}
	//添加一条数据
	public int Add(BookManage item) {
		//编写预处理 SQL
		String sql = "insert into BookManage (B_ID, B_NAME, B_AUTHOR, B_TIME, B_TYPE)" +
				"values (SEQ_BOOKMANAGE.Nextval,?,?, to_date(?, 'yyyy-mm-dd'), ?)";
		return this.executeUpdate(sql, new Object[]{
				item.getName(),
				item.getAuthor(),
				item.getTime(),
				item.getType()
		});//返回SQL语句和要添加的 Object 对象
	}
	//删除一条数据
	public int delete(int id) {
		//编写预处理 SQL
		String sql = "delete bookmanage where b_id = ?";
		return this.executeUpdate(sql, new Object[]{id});
	}//返回SQL语句根据 id 删除

	//修改一条数据
	public int update(BookManage item) {
		//编写预处理 SQL
		String sql = 
				"update bookmanage" +
						"   set b_name = ?," + 
						"       b_author = ?," + 
						"       b_time =to_date(?,'yyyy-mm-dd')," + 
						"       b_type =?" + 
						" where b_id = ?";
		
		return this.executeUpdate(sql, new Object[]{
				item.getName(),
				item.getAuthor(),
				item.getTime(),
				item.getType(),
				item.getId()
		});//返回SQL语句和要修改的 Object 对象，根据 id 来修改
	}
}
