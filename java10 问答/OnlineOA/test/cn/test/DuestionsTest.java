package cn.test;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.biz.DuestionsBiz;
import cn.entity.Answers;
import cn.entity.Duestions;
public class DuestionsTest {
	DuestionsBiz duestionsBiz;
	static ApplicationContext ctx;
	@BeforeClass  
	public static void init(){
		ctx=new	ClassPathXmlApplicationContext("applicationContext.xml");
	}
	@Before 
	public void setUp(){
		duestionsBiz=(DuestionsBiz) ctx.getBean("duestionsBiz");
	}
	@After
	public void tearDown(){
		duestionsBiz=null;
	}
	@AfterClass
	public static void destory(){
		ctx=null;
	}
	//@Test
	public void testFindAll(){
		List<Duestions> dList = duestionsBiz.findAll();
		for (Duestions duestions : dList) {
			System.out.println(duestions);
		}
	}
	@Test
	public void testFindById(){
		Duestions duestions = duestionsBiz.findById(2);
		System.out.println(duestions);
	}
	//@Test
	public void testInsert(){
		Duestions duestions = duestionsBiz.findById(2);
		Answers answers = new Answers(duestions,"这是回答XX",  new Date());
		duestionsBiz.insert(answers);
	}
	//@Test
	public void testFindAnswersList(){
		List<Answers> answers = duestionsBiz.findAnswersList(2);
		for (Answers answer : answers) {
			System.out.println(answer);
		}
	}
	//@Test
	public void testAdd(){
		Duestions duestions = new Duestions("这是title", 1);
		duestionsBiz.add(duestions);
	}
	//@Test
	public void testUpdate(){
		List<Answers> answers = duestionsBiz.findAnswersList(2);
		Duestions duestions = new Duestions();
		duestions.setId(2);
		duestions.setTitle("工");
		duestions.setAnsewercount(answers.size());
		duestionsBiz.update(duestions);
	}
	
}
