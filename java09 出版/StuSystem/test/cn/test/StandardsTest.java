package cn.test;
import java.sql.Date;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import cn.biz.StandardsBiz;
import cn.entity.Standards;
public class StandardsTest {
	StandardsBiz standardsBiz;
	static ApplicationContext ctx;
	@BeforeClass  
	public static void init(){
		ctx=new	ClassPathXmlApplicationContext("applicationContext.xml");
	}
	@Before 
	public void setUp(){
		standardsBiz=(StandardsBiz) ctx.getBean("standardsBiz");
	}
	@After
	public void tearDown(){
		standardsBiz=null;
	}
	@AfterClass
	public static void destory(){
		ctx=null;
	}
	//@Test
	public void testFindAll(){
		List<Standards> standards = standardsBiz.findAll();
		for (Standards standard : standards) {
			System.out.println(standard);
		}
	}
	//@Test
	public void testFindByPage(){
		List<Standards> standards = standardsBiz.findByPage(2, 3);
		for (Standards standard : standards) {
			System.out.println(standard);
		}
	}
	//@Test
	public void testFindByPageOfsearch(){
		List<Standards> standards = standardsBiz.findByPageOfsearch(2, 3, "号");
		for (Standards standard : standards) {
			System.out.println(standard);
		}
	}
	//@Test
	public void testFindById(){
		Standards standards = standardsBiz.findById(2);
		System.out.println(standards);
	}
	//@Test
	public void testUpdate(){
		@SuppressWarnings("deprecation")
		Standards standards = new Standards(1, "aaaa", "bbb", "cccc", "bbbb", new Date(1911, 10, 16), new Date(1912, 10, 18), "imges.abc");
		standardsBiz.update(standards);
	}
	//@Test
	public void testInsert(){
		@SuppressWarnings("deprecation")
		Standards standards = new Standards( "aaaa", "bbb", "cccc", "bbbb", new Date(1911, 10, 16), new Date(1912, 10, 18), "imges.abc");
		standardsBiz.insert(standards);
	}
	//@Test
	public void testDeleteByIds(){
		Integer[] ids = {1,3,5};
		standardsBiz.deleteByIds(ids);
	}
}
