package cn.test;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.biz.TagBiz;
import cn.dao.TagDAO;
import cn.entity.Tag;
public class TagTest {
	TagDAO tagDAO;
	TagBiz tagBiz;
	static ApplicationContext ctx;
	@BeforeClass  
	public static void init(){
		ctx=new	ClassPathXmlApplicationContext("applicationContext.xml");
	}
	@Before 
	public void setUp(){
		tagDAO=(TagDAO) ctx.getBean("tagDAO");
		tagBiz=(TagBiz) ctx.getBean("tagBiz");
	}
	@After
	public void tearDown(){
		tagDAO=null;
		tagBiz=null;
	}
	@AfterClass
	public static void destory(){
		ctx=null;
	}
	//@Test
	public void testGet(){
		Tag tag = tagDAO.get("spring");
		System.out.println(tag);
	}
	@Test
	public void testSearch(){
		List<Tag> tags = tagBiz.search(null);
		for (Tag tag : tags) {
			System.out.println(tag);
		}
	}
}

