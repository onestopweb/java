package cn.jbit.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * 数据库连接与关闭工具类。
 */
public class BaseDao {
	private static String driver ="oracle.jdbc.driver.OracleDriver";// 数据库驱动字符串
	private static String url = "jdbc:oracle:thin:@localhost:1521:oracle11";// 连接URL字符串
	private static String user = "book"; // 数据库用户名
	private static String password = "accp"; // 用户密码
	/**
	 * 获取数据库连接对象。
	 */
	public Connection getConnection() {
		Connection conn = null;// 数据连接对象
		// 获取连接并捕获异常
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();// 异常处理
		}
		return conn;// 返回连接对象
	}
	/**
	 * 关闭数据库连接。
	 * @param conn 数据库连接
	 * @param stmt Statement对象
	 * @param rs 结果集
	 */
	public void closeAll(Connection conn, PreparedStatement pstmt, 
					ResultSet rs) {
		// 若结果集对象不为空，则关闭
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 若Statement对象不为空，则关闭
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 若数据库连接对象不为空，则关闭
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * 执行更新、删除、插入SQL语句命令
	 * @param sql
	 * @param pars
	 * @return int
	 */
	public int executeUpdate(String sql, Object[] pars) {
		int rowCount =0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = this.getConnection();
			pstmt = conn.prepareStatement(sql);
			if(pars!=null){
				for(int i=0;i<pars.length;i++){
					pstmt.setObject(i+1, pars[i]);
				}
			}
			rowCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeAll(conn, pstmt, null);
		}
		return rowCount;
	}
}
