package cn.client.tool;

import java.sql.Connection;
import java.sql.DriverManager;

public class Test {
	private static String driver ="oracle.jdbc.driver.OracleDriver";// 数据库驱动字符串  
	private static String url = "jdbc:oracle:thin:@localhost:1521:oracle11";// 连接URL字符串  
	private static String user = "newegg"; // 数据库用户名  
	private static String password = "newegg"; // 用户密码  
	public static void main(String[] args) {  
		Connection conn=null;  
		//1、加载驱动  
		try{  
			 Class.forName(driver);  
		}catch(ClassNotFoundException e){  
			System.out.println("加载驱动失败");  
		}  
		//2、建立连接  
		try{  
			conn = DriverManager.getConnection(url, user, password);  
			System.out.println("建立连接成功");  
		}catch(Exception e){  
			System.out.println("建立连接失败");  
		}finally{  
			//3、关闭连接  
			try{  
				if(null !=conn){  
					conn.close();  
					System.out.println("关闭连接成功");  
				}  
			}catch(Exception e){  
				System.out.println("关闭连接失败");  
			}  
		}  
	} 
}
