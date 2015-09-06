package cn.test;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.biz.FavBiz;
import cn.dao.FavDAO;
import cn.entity.Favorite;
public class FavTest {
	FavDAO favDAO;
	FavBiz favBiz;
	static ApplicationContext ctx;
	@BeforeClass  
	public static void init(){
		ctx=new	ClassPathXmlApplicationContext("applicationContext.xml");
	}
	@Before 
	public void setUp(){
		favDAO=(FavDAO) ctx.getBean("favDAO");
		favBiz=(FavBiz) ctx.getBean("favBiz");
	}
	@After
	public void tearDown(){
		favDAO=null;
		favBiz=null;
	}
	@AfterClass
	public static void destory(){
		ctx=null;
	}
	//@Test
	public void testSearch(){
		List<Favorite> favorites = favDAO.search("0");
		for (Favorite favorite : favorites) {
			System.out.println(favorite);
		}
	}
	@Test
	public void testAdd(){
		Favorite favorite = new Favorite("Java2", "http://www.Java.org", "spring,Java", "这是Java");
		favBiz.add(favorite);
	}
	//@Test
	public void testSearchBiz(){
		List<Favorite> favorites = favBiz.search("-1");
		for (Favorite favorite : favorites) {
			System.out.println(favorite);
		}
		
	}
}

